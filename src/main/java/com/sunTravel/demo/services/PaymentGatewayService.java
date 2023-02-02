package com.sunTravel.demo.services;

import com.sunTravel.demo.credintal.Env;
import com.sunTravel.demo.dtos.FormDataDto;
import com.sunTravel.demo.util.PaymentGatewayUtil;
import jakarta.transaction.Transactional;
import org.aspectj.apache.bcel.classfile.annotation.NameValuePair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

@Service
@Transactional
public class PaymentGatewayService
{
    @Value("${negorate.globalPaymentGateway.sharedSecret}")
    private String sharedSecret;
    @Value("${negorate.globalPaymentGateway.merchantId}")
    private String merchantId;
    public String getGateway( HashMap<String,String> formData ) throws IOException
    {
        String timestamp= PaymentGatewayUtil.createTimeStamp();
        formData.put("TIMESTAMP",timestamp);
        String sha1hash=PaymentGatewayUtil.createShareSecret( formData.get("TIMESTAMP"),merchantId,formData.get("ORDER_ID"),formData.get("AMOUNT"),formData.get("CURRENCY"),sharedSecret );
        formData.put("MERCHANT_ID",merchantId );
        formData.put("SHA1HASH", sha1hash);
        String urlEncode=PaymentGatewayUtil.getUrlEncode(formData);
        String url=PaymentGatewayUtil.getUrl(urlEncode);
        return url;
    }
}
