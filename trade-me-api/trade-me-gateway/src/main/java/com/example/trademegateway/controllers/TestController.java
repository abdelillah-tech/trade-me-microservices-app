package com.example.trademegateway.controllers;

import com.example.trademegateway.services.QueueProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/")
public class TestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private QueueProducer producer;

    @PostMapping
    public void sendMessage(@RequestBody Map<String, String>  msg) {
        LOGGER.info("Gateway send", msg.get("msg"));
        producer.send(msg.get("msg"));
    }
}
