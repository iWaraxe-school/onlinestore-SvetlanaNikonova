package com.issoft.domain.categories;

import com.issoft.domain.Category;
import com.issoft.domain.Product;

public class BikeCategory extends Category implements IProduct {

    public BikeCategory() {
        super("Bike products");
        addProductToCategory(new Product("Cross", 550.00, 2.5));
        addProductToCategory(new Product("Azimut", 150.00, 1.5));
        addProductToCategory(new Product("Romet", 400.00, 1.5));
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
