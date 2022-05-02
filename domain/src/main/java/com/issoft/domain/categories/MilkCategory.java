package com.issoft.domain.categories;

import com.issoft.domain.Category;
import com.issoft.domain.Product;

public class MilkCategory extends Category implements IProduct {

    public MilkCategory() {
        super("Milk products");
        addProductToCategory(new Product("Milk",2.00, 1.5));
        addProductToCategory(new Product("Kefir",1.00, 1.5));
        addProductToCategory(new Product("Yougurt",2.50, 2.0));
    }

    @Override
    public void putOnShelves() {
        System.out.println("hello from milk");
    }

    // @ Override
  //  public void addProduct(Product product) {
  //      this.productList.add(product);
  //  }
}
