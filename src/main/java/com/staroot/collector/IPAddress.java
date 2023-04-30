package com.staroot.collector;


import org.springframework.util.StringUtils;

import jakarta.persistence.Embeddable;


/**
 * @author yjjung
 * @version 0.1.0
 * @since 2021/03/05
 */
@Embeddable
public class IPAddress {

    private final String ipAddress;

    public IPAddress(){
        this.ipAddress = "";
    }

    public static IPAddress from(String ipAddress){
        return new IPAddress(ipAddress);
    }

    private IPAddress(String ipAddress){
        if(!StringUtils.hasText(ipAddress))
            throw new IllegalArgumentException("값을 입력해주세요");

        this.ipAddress = ipAddress;
    }
}
