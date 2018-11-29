package com.quipu.stockconsumer;

import com.quipu.shared.StockPrice;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@Component
class MessageListener {

    @StreamListener(value = Sink.INPUT)
    void receive(StockPrice stockPrice) {
        System.out.println("Received message ..." + stockPrice.toString());
    }

}
