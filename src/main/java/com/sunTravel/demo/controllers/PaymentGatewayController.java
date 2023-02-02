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

@RestController
@RequestMapping(value = "api/v1/paymentGateway")
@CrossOrigin
public class PaymentGatewayController
{
    @Autowired
    private PaymentGatewayService paymentGatewayService;
    @PostMapping("get")
    public ResponseEntity<FormDataDto> get( @RequestBody FormDataDto formData){
        System.out.println(formData.getAMOUNT());
        paymentGatewayService.getGateway(formData);
        return new ResponseEntity( formData,HttpStatus.OK);
    }

}
