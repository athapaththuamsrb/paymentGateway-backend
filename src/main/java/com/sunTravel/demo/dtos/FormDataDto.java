package com.sunTravel.demo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FormDataDto
{
    @JsonProperty("ACCOUNT")
    private String ACCOUNT;
    @JsonProperty("AMOUNT")
    private String AMOUNT;
    @JsonProperty("AUTO_SETTLE_FLAG")
    private String AUTO_SETTLE_FLAG;
    @JsonProperty("BILLING_CO")
    private String BILLING_CO;
    @JsonProperty("BILLING_CODE")
    private String BILLING_CODE;
    @JsonProperty("CARD_PAYMENT_BUTTON")
    private String CARD_PAYMENT_BUTTON;
    @JsonProperty("COMMENT1")
    private String COMMENT1;
    @JsonProperty("CURRENCY")
    private String CURRENCY;
    @JsonProperty("CUSTOM_FIELD_NAME")
    private String CUSTOM_FIELD_NAME;
    @JsonProperty("CUST_NUM")
    private String CUST_NUM;
    @JsonProperty("HPP_ADDRESS_MATCH_INDICATOR")
    private String HPP_ADDRESS_MATCH_INDICATOR;
    @JsonProperty("HPP_BILLING_CITY")
    private String HPP_BILLING_CITY;
    @JsonProperty("HPP_BILLING_COUNTRY")
    private String HPP_BILLING_COUNTRY;
    @JsonProperty("HPP_BILLING_POSTALCODE")
    private String HPP_BILLING_POSTALCODE;
    @JsonProperty("HPP_BILLING_STREET1")
    private String HPP_BILLING_STREET1;
    @JsonProperty("HPP_BILLING_STREET2")
    private String HPP_BILLING_STREET2;
    @JsonProperty("HPP_BILLING_STREET3")
    private String HPP_BILLING_STREET3;
    @JsonProperty("HPP_CHALLENGE_REQUEST_INDICATOR")
    private String HPP_CHALLENGE_REQUEST_INDICATOR;
    @JsonProperty("HPP_CHANNEL")
    private String HPP_CHANNEL;
    @JsonProperty("HPP_CUSTOMER_EMAIL")
    private String HPP_CUSTOMER_EMAIL;
    @JsonProperty("HPP_CUSTOMER_PHONENUMBER_MOBILE")
    private String HPP_CUSTOMER_PHONENUMBER_MOBILE;
    @JsonProperty("HPP_LANG")
    private String HPP_LANG;
    @JsonProperty("HPP_SHIPPING_CITY")
    private String HPP_SHIPPING_CITY;
    @JsonProperty("HPP_SHIPPING_COUNTRY")
    private String HPP_SHIPPING_COUNTRY;
    @JsonProperty("HPP_SHIPPING_POSTALCODE")
    private String HPP_SHIPPING_POSTALCODE;
    @JsonProperty("HPP_SHIPPING_STATE")
    private String HPP_SHIPPING_STATE;
    @JsonProperty("HPP_SHIPPING_STREET1")
    private String HPP_SHIPPING_STREET1;
    @JsonProperty("HPP_SHIPPING_STREET2")
    private String HPP_SHIPPING_STREET2;
    @JsonProperty("HPP_SHIPPING_STREET3")
    private String HPP_SHIPPING_STREET3;
    @JsonProperty("HPP_VERSION")
    private String HPP_VERSION;
    @JsonProperty("MERCHANT_ID")
    private String MERCHANT_ID;
    @JsonProperty("MERCHANT_RESPONSE_URL")
    private String MERCHANT_RESPONSE_URL;
    @JsonProperty("ORDER_ID")
    private String ORDER_ID;
    @JsonProperty("PROD_ID")
    private String PROD_ID;
    @JsonProperty("SHA1HASH")
    private String SHA1HASH;
    @JsonProperty("SHIPPING_CO")
    private String SHIPPING_CO;
    @JsonProperty("SHIPPING_CODE")
    private String SHIPPING_CODE;
    @JsonProperty("TIMESTAMP")
    private String TIMESTAMP;
    @JsonProperty("VAR_REF")
    private String VAR_REF;
 }
