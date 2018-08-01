package com.parkingtelecom.entity;

public class ConsumerEntity {
   private String queue;
   private Integer consumers;

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public Integer getConsumers() {
        return consumers;
    }

    public void setConsumers(Integer consumers) {
        this.consumers = consumers;
    }
}
