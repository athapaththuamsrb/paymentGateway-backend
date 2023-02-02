package com.sunTravel.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HostedPaymentDataDto
{
    private String CustomerEmail;
    private String CustomerPhoneMobile;
    private Boolean AddressesMatch;
}
