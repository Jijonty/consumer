package com.parkingtelecom.controller.service.Impl;

import com.parkingtelecom.controller.service.ConsumerService;
import com.parkingtelecom.entity.ConsumerEntity;
import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    private static final Logger log = LoggerFactory.getLogger(ConsumerServiceImpl.class);
    @Override
    public void consumeMessages(ConsumerEntity consumerEntity) throws IOException, TimeoutException {

                ExecutorService executorService = Executors.newFixedThreadPool(consumerEntity.getConsumers());
                ConnectionFactory factory = new ConnectionFactory();

                Connection connection = factory.newConnection(executorService);
                Channel channel = connection.createChannel();
                channel.queueDeclarePassive(consumerEntity.getQueue());

                Consumer consumer = new DefaultConsumer(channel) {
                    @Override
                    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                            throws IOException {
                        String message = new String(body, "UTF-8");
                        log.info("Received '" + message + "'");
                    }
                };
                channel.basicConsume(consumerEntity.getQueue(), true, consumer);
            }
        }