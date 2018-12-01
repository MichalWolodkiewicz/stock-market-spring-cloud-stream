package com.quipu.stockproducer

import com.quipu.shared.StockPrice
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import spock.lang.Specification

import static org.mockito.Mockito.verify

@SpringBootTest
class StockControllerUsingMockBeanTest extends Specification {

    @Autowired
    private StockController stockController
    @Autowired
    private StockRepository stockRepository
    @MockBean
    private DomainEventPublisher domainEventPublisher

    def "should send message that new stock price is created"() {
        given:
        def stockPrice = new StockPrice("quipu", "1000\$", System.currentTimeMillis())

        when: "stock is created"
        stockController.createStock(stockPrice)

        then: "message is sent"
        stockRepository.getHistory().size() == 1
        verify(domainEventPublisher).publish(stockPrice)
    }

}
