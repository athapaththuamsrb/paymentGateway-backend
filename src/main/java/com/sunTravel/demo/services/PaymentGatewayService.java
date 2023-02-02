package com.sunTravel.demo.services;

import com.sunTravel.demo.credintal.Env;
import com.sunTravel.demo.dtos.FormDataDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

@Service
@Transactional
public class PaymentGatewayService
{
    public FormDataDto getGateway( FormDataDto formDataDto ){
        String timestamp=createTimeStamp();
        formDataDto.setTIMESTAMP(timestamp);
        String sha1hash=createShareSecret( formDataDto.getTIMESTAMP(),Env.merchantId,formDataDto.getORDER_ID(),formDataDto.getAMOUNT(),formDataDto.getCURRENCY() );
        formDataDto.setMERCHANT_ID( Env.merchantId );
        formDataDto.setSHA1HASH( sha1hash );
        return formDataDto;
    }

    private String createTimeStamp()
    {   final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
        final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        final String utcTime = sdf.format(new Date());
        System.out.println(utcTime);
        String[] dateList= utcTime.split( "-" );
        String[] dayList=dateList[2].split( " " );
        String[] timeList=dayList[1].split( ":" );
        String time=dateList[0]+dateList[1]+dayList[0]+timeList[0]+timeList[1]+timeList[2];
        System.out.println(time);
        return time;
    }
    private String convertByteToHexadecimal(byte[] byteArray)
    {
        StringBuilder hex = new StringBuilder();
        // Iterating through each byte in the array
        for (byte i : byteArray) {
            hex.append( String.format( "%02x", i ) );
        }
       return hex.toString();
    }
    private String createShareSecret(String timeStamp,String merchantId,String orderId,String amount,String currency)
    {MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
            String  hashSequence1 = timeStamp+"."+merchantId+"."+orderId+"."+amount+"."+currency;
            byte[] hash1Bytes = md.digest(hashSequence1.getBytes("UTF-8"));
            String hash1=convertByteToHexadecimal( hash1Bytes );
            System.out.println(hash1);
            String hashSequence2 = hash1+"."+ Env.sharedSecret;
            byte[] hash2Bytes = md.digest(hashSequence2.getBytes("UTF-8"));
            String hash2 = convertByteToHexadecimal( hash2Bytes );
            System.out.println(hash2);
            return hash2;
        }
        catch( NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        catch( UnsupportedEncodingException e )
        {
            throw new RuntimeException( e );
        }

    }
}
