package com.quipu.shared;

public class StockPrice {
    private String name;
    private String price;
    private long time;

    public StockPrice() {

    }

    public StockPrice(String name, String price, long time) {
        this.name = name;
        this.price = price;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "StockPrice{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", time=" + time +
                '}';
    }
}
