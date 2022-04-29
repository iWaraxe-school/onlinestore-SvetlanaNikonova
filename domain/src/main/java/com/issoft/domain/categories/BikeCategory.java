package com.issoft.domain.categories;

import com.issoft.domain.Category;
import com.issoft.domain.Product;

public class BikeCategory extends Product implements IProduct {

    public BikeCategory() {
        super("Bike", 50.00, 2.00);
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
