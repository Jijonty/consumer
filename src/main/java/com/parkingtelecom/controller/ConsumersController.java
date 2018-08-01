package com.parkingtelecom.controller;

import com.parkingtelecom.Consumer;
import com.parkingtelecom.entity.ConsumerEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ConsumersController {

    @PostMapping("/rabbit/consumers")
    @ResponseBody
    public ResponseEntity<?> produceMessage(@RequestBody ConsumerEntity dto) {
        return null;
    }

}
