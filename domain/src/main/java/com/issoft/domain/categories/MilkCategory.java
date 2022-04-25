package com.issoft.domain.categories;

import com.issoft.domain.Category;

public class MilkCategory extends Category implements IProduct {

    public MilkCategory() {
        super("Milk");
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
