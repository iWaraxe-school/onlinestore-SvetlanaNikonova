package com.issoft.domain.categories;

import com.issoft.domain.Category;
import com.issoft.domain.Product;

public class PhoneCategory extends Category implements IProduct {


    public PhoneCategory() {
        super("Phone products");
        addProductToCategory(new Product("Apple", 750.00, 2.0));
        addProductToCategory(new Product("Samsung", 650.00, 1.5));
        addProductToCategory(new Product("Huawei", 350.00, 2.0));
    }


    @Override
    public void putOnShelves() {
        System.out.println("hello from phone");
    }
}
