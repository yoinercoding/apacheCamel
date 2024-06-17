package com.apache.camel.microservices.beans;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class GetTimeBean {

    public String getTimeBean(){
        return "La hora es = " + LocalDateTime.now();
    }
}