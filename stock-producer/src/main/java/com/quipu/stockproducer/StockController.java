package com.quipu.stockproducer;

import com.quipu.shared.StockPrice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class StockController {

    private final CreateStockService createStockService;

    StockController(CreateStockService createStockService) {
        this.createStockService = createStockService;
    }

    @PostMapping(name = "/api/stock")
    void createStock(@RequestBody StockPrice stockPrice) {
        createStockService.create(stockPrice);
    }

}
