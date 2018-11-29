package com.quipu.stockproducer;

import com.quipu.shared.StockPrice;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

import java.util.Random;

@Profile("producerScheduler")
public class StockProducer {

    @Bean
    @InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "2000", maxMessagesPerPoll = "1"))
    public MessageSource<StockPrice> timerMessageSource() {
        String price = String.valueOf(new Random().nextInt());
        return () -> new GenericMessage<>(new StockPrice("google", price, System.currentTimeMillis()));
    }
}
