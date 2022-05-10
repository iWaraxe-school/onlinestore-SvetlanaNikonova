package com.issoft.domain.categories;

import com.issoft.domain.Category;
import com.issoft.domain.Product;

public class BikeCategory extends Category implements IProduct {

    public BikeCategory() {
        super("Bike products");

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
