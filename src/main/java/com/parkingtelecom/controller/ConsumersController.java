package com.parkingtelecom.controller;

import com.parkingtelecom.controller.service.ConsumerService;
import com.parkingtelecom.entity.ConsumerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ConsumersController {

    @Autowired
    ConsumerService consumerService;
    @PostMapping("/rabbit/consumers")
    @ResponseBody
    public ResponseEntity<?> produceMessage(@RequestBody ConsumerEntity consumer) throws Exception {
        consumerService.consumeMessages(consumer) ;
        return null;
    }

}
