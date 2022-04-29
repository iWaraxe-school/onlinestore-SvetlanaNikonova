package com.issoft.domain.categories;

import com.issoft.domain.Category;
import com.issoft.domain.Product;

public class MilkCategory extends Product implements IProduct {

    public MilkCategory() {
        super("Milk", 20.0, 3.00);
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
