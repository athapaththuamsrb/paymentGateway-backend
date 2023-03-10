package com.sunTravel.demo.util;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public class PaymentGatewayUtil
{
    public static String getUrl( String urlEncode ) throws IOException
    {
        URL url = new URL("https://pay.sandbox.realexpayments.com/pay");
        HttpURLConnection conn= (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setInstanceFollowRedirects(false);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("charset", "utf-8");
        conn.setRequestProperty("Content-Length", Integer.toString(urlEncode.length() ));
        conn.setUseCaches(false);
        try( DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
            wr.write( urlEncode.getBytes( StandardCharsets.UTF_8 ));
            Map<String,List<String>> map = conn.getHeaderFields();
//            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
//                System.out.println("Key : " + entry.getKey() +
//                                           " ,Value : " + entry.getValue());
//            }
            return map.get("location").get( 0 );
        }catch(IOException e  ){

        }
        return null;

    }

    public static String getUrlEncode( HashMap<String,String> formData )
    {   ArrayList<String> encoded=new ArrayList<>();
        for( Map.Entry<String, String> entry : formData.entrySet() ){
            encoded.add( URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8) + '=' + URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8) ) ;
        }
        String reqBody = String.join("&", encoded).replace("+", "%20");
        System.out.println(reqBody);
        return reqBody;
    }

    public static String createTimeStamp()
    {   final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
        final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        sdf.setTimeZone( TimeZone.getTimeZone("UTC"));
        final String utcTime = sdf.format(new Date());
        System.out.println(utcTime);
        String[] dateList= utcTime.split( "-" );
        String[] dayList=dateList[2].split( " " );
        String[] timeList=dayList[1].split( ":" );
        String time=dateList[0]+dateList[1]+dayList[0]+timeList[0]+timeList[1]+timeList[2];
//        System.out.println(time);
        return time;
    }
    public static String convertByteToHexadecimal(byte[] byteArray)
    {
        StringBuilder hex = new StringBuilder();
        // Iterating through each byte in the array
        for (byte i : byteArray) {
            hex.append( String.format( "%02x", i ) );
        }
        return hex.toString();
    }
    public static String createShareSecret(String timeStamp,String merchantId,String orderId,String amount,String currency,String sharedSecret)
    {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
            String  hashSequence1 = timeStamp+"."+merchantId+"."+orderId+"."+amount+"."+currency;
            byte[] hash1Bytes = md.digest(hashSequence1.getBytes("UTF-8"));
            String hash1=convertByteToHexadecimal( hash1Bytes );
//            System.out.println(hash1);
            String hashSequence2 = hash1+"."+ sharedSecret;
            byte[] hash2Bytes = md.digest(hashSequence2.getBytes("UTF-8"));
            String hash2 = convertByteToHexadecimal( hash2Bytes );
//            System.out.println(hash2);
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
