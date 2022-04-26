package com.issoft.domain.categories;

import com.issoft.domain.Category;

public class BikeCategory extends Category implements IProduct {

    public BikeCategory() {
        super("Bike");
    }

    @Override
    public void putOnShelves() {
        System.out.println("hello from bike");
    }

    // @Override
    //public void addProduct(Product product) {
    //    this.productList.add(product);
    //}
}
