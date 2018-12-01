package com.quipu.stockproducer;

import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

@Component
class DomainEventPublisher {

    private final Source source;

    DomainEventPublisher(Source source) {
        this.source = source;
    }

    void publish(Object event) {
        Map<String, Object> headers = Collections.singletonMap("__type", "new-stock-price");
        source.output().send(new GenericMessage<>(event, headers));
    }
}
