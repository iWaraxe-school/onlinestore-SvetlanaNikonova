package com.issoft.domain.categories;

import com.issoft.domain.Category;
import com.issoft.domain.Product;

public class PhoneCategory extends Product implements IProduct {


    public PhoneCategory() {
        super("Phone", 500.00, 3.00);
    }


    @Override
    public void putOnShelves() {
        System.out.println("hello from phone");
    }
}
