package com.issoft.domain.categories;

import com.issoft.domain.Category;
import com.issoft.domain.Product;

public class PhoneCategory extends Category implements IProduct {


    public PhoneCategory() {
        super("Phone products");

    }


    @Override
    public void putOnShelves() {
        System.out.println("hello from phone");
    }
}
