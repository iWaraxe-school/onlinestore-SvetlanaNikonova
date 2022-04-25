package com.issoft.domain.categories;

import com.issoft.domain.Category;

public class PhoneCategory extends Category implements IProduct {


    public PhoneCategory() {
        super("Phone");
    }


    @Override
    public void putOnShelves() {
        System.out.println("hello from phone");
    }
}
