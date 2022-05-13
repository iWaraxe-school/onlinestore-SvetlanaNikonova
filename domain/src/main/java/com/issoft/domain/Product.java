package com.issoft.domain;

public class Product {
    public String name;
    public String category;
    public Double price;
    public Double rate;


    public  Product(String name, String category, Double price, Double rate) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.rate = rate;
    }

    @Override
    public String toString() {
        String productInfo = String.format("Name: '%s', Price: %s, Rate: %s", name, price, rate);
        return productInfo;
    }
}
