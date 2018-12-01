package com.quipu.stockproducer;

import com.quipu.shared.StockPrice;
import org.springframework.stereotype.Component;

@Component
class CreateStockService {

    private final DomainEventPublisher domainEventPublisher;
    private final StockRepository stockRepository;

    CreateStockService(DomainEventPublisher domainEventPublisher, StockRepository stockRepository) {
        this.domainEventPublisher = domainEventPublisher;
        this.stockRepository = stockRepository;
    }

    void create(StockPrice stockPrice) {
        stockRepository.save(stockPrice);
        domainEventPublisher.publish(stockPrice);
    }
}
