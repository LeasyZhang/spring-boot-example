package com.springboot.example.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.springboot.example.message.Price;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class PriceQueueProducer extends MessageProducer<Price> {

    private final int messageSize = 20;

    public PriceQueueProducer(AmazonSQS amazonSQS, String queueUrl) {
        this.amazonSQS = amazonSQS;
        this.queueUrl = queueUrl;
    }

    @Override
    public List<Price> prepare() {
        List<Price> priceList = new ArrayList<>(messageSize);
        Random generator = new Random();
        for (int i = 0; i < messageSize; i++) {
            Price newPrice = new Price();
            newPrice.setProductId(generator.nextInt(10000) + 1);
            newPrice.setNewPrice(generator.nextDouble());
            priceList.add(newPrice);
        }
        return priceList;
    }
}
