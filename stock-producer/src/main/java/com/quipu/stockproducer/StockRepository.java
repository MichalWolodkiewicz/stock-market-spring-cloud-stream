package com.quipu.stockproducer;

import com.quipu.shared.StockPrice;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
class StockRepository {

    private List<StockPrice> history = new ArrayList<>(10);

    void save(StockPrice stockPrice) {
        history.add(stockPrice);
    }

    List<StockPrice> getHistory() {
        return Collections.unmodifiableList(history);
    }
}
