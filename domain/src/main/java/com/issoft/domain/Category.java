package com.issoft.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class Category {
    private String name;
    private List<Product> productList;

    public Category(String name) {
        this.name = name;
        this.productList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void addProductToCategory(Product product) {
        productList.add(product);
    }



    public void printAllProducts() {

        System.out.println(String.format("%s","--------------------------------------------------------"));
        System.out.println("Category: " + name + ".");
        System.out.println(String.format("%s","--------------------------------------------------------"));

        for (Product product : productList) {
            System.out.println(product.toString());
        }
    }




}
