package com.parkingtelecom.controller.service;

import com.parkingtelecom.entity.ConsumerEntity;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public interface ConsumerService {
    void consumeMessages(ConsumerEntity consumer) throws IOException, TimeoutException;
}
