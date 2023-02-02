package com.sunTravel.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDto
{
    private String streetAddress1;
    private String streetAddress2;
    private String streetAddress3;
    private String city;
    private String postalCode;
    private String country;
    private String state;

}
