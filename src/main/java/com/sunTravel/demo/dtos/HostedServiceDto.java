package com.sunTravel.demo.dtos;

public class HostedServiceDto
{
    private GatewayConfigDto gatewayConfigDto;
    public HostedServiceDto( GatewayConfigDto config )
    {
        this.gatewayConfigDto=config;
    }
}
