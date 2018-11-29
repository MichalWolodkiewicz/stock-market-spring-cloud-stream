package com.quipu.stockproducer;

import com.quipu.shared.StockPrice;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class StockController {

    private final Source source;

    StockController(Source source) {
        this.source = source;
    }

    @PostMapping(name = "/api/stock")
    void createStock(@RequestBody StockPrice stockPrice) {
        source.output().send(new GenericMessage<>(stockPrice));
    }

}
