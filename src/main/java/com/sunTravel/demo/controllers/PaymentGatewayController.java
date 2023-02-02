package com.sunTravel.demo.controllers;

import com.sunTravel.demo.dtos.FormDataDto;
import com.sunTravel.demo.services.PaymentGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "api/v1/paymentGateway")
@CrossOrigin
public class PaymentGatewayController
{
    @Autowired
    private PaymentGatewayService paymentGatewayService;
    @PostMapping("get")
    public ResponseEntity<FormDataDto> get( @RequestBody HashMap<String,String> formData) throws IOException
    {
        String url=paymentGatewayService.getGateway( formData );
//        for( Map.Entry<String, String> entry : formData.entrySet() ){
//            System.out.println( entry.getKey() + " => " + entry.getValue() );
//        }
        HashMap<String,String> map=new HashMap<>();
        System.out.println(url);
        map.put( "location",url );
        return new ResponseEntity( map,HttpStatus.OK);
    }

}
