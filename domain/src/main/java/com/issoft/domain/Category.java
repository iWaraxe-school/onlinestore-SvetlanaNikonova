package com.issoft.domain;


import java.util.ArrayList;
import java.util.List;

public class Category {
    public String name;
    public List<Product> productList;

    public Category(String name) {

        this.name = name;
    }

    public  Category() {
    }

    public void addProducts(List<Product> products) {
        if (productList == null) {
            productList = new ArrayList<>();
        }
         productList.addAll(products);
    }

    public  void printAllProduct() {

        System.out.println("Category " + name + " : ");

        for (Product product : productList) {
            System.out.println(product.toString());
        }
    }
}