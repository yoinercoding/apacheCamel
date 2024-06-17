package com.apache.camel.microservices.routes.a;

import com.apache.camel.microservices.beans.GetTimeBean;
import com.apache.camel.microservices.beans.Logging;
import com.apache.camel.microservices.beans.LoggingProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

//@Component
public class TimerRouter extends RouteBuilder {

    @Autowired
    private GetTimeBean getTimeBean;

    @Autowired
    private Logging logging;

    @Autowired
    private LoggingProcessor loggingProcessor;

    @Override
    public void configure() throws Exception {
        //timer
        //transformation
        //log
        from("timer:first-timer")
                .log("${body}") //null
                .transform().constant("Mandando un mensajito") //usamos transform para mandar una constant que tiene como valor un string
                .log("${body}")
                .transform().constant("La hora es = " + LocalDateTime.now())
                .bean("getTimeBean") //lo mismo que el transform de arriba pero capturando un bean
                .bean(getTimeBean) //lo mismo que arriba con la inyeccion del autowired
                .process(new LoggingProcessor())
                .bean(logging) //logueando con el bean
                .to("log:first-timer");
    }
}