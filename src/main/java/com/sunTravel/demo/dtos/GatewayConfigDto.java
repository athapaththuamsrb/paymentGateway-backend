package com.sunTravel.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GatewayConfigDto
{
    private String merchantId;
    private String AccountId;
    private String SharedSecret;
    private String ServiceUrl;
    private HostedPaymentConfigDto hostedPaymentConfig;
}
