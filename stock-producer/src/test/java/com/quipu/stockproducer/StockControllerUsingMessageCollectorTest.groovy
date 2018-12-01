package com.quipu.stockproducer

import com.quipu.shared.StockPrice
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.stream.messaging.Source
import org.springframework.cloud.stream.test.binder.MessageCollector
import org.springframework.messaging.Message
import spock.lang.Specification

import java.util.concurrent.BlockingQueue

@SpringBootTest(classes = StockProducerApplication.class)
class StockControllerUsingMessageCollectorTest extends Specification {

    @Autowired
    private StockController stockController
    @Autowired
    private StockRepository stockRepository
    @Autowired
    private MessageCollector messageCollector
    @Autowired
    private Source source;
    private BlockingQueue<Message> events

    def setup() {
        events = messageCollector.forChannel(source.output())
    }

    def "should send message that new stock price is created"() {
        given:
        def stockPrice = new StockPrice("quipu", "1000\$", System.currentTimeMillis())

        when: "stock is created"
        stockController.createStock(stockPrice)

        then: "message has been received"
        stockRepository.getHistory().size() == 1
        events.poll().headers.containsValue('new-stock-price')
    }

}
