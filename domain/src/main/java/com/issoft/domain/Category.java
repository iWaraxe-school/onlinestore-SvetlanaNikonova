package com.issoft.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class Category {
    private String name;
    protected List<Product> productList;

    public Category(String name) {
        this.name = name;
        this.productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.productList.add(product);
    }



    public void printAllProducts() {

        System.out.println(String.format("%s","--------------------------------------------------------"));
        System.out.println("Category: " + name + ".");
        System.out.println(String.format("%s","--------------------------------------------------------"));

        for (Product product : productList) {
            System.out.println(product.toString());
        }
    }

    public String getName(){
        return this.name;
    }


}
