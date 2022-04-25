package com.issoft.domain.categories;

import com.issoft.domain.Category;

import java.util.ArrayList;
import java.util.List;

public class Patterns {
    public static void main(String[] args) {
        CategoryFactory categoryFactory = new CategoryFactory();
        IProduct bike = categoryFactory.getCategory(ProductType.BIKE);
        IProduct milk = categoryFactory.getCategory(ProductType.MILK);
        IProduct phone = categoryFactory.getCategory(ProductType.PHONE);
        List<IProduct> categories = new ArrayList<>();
        categories.add(bike);
        categories.add(milk);
        categories.add(phone);

        for (IProduct category: categories) {
            category.putOnShelves();
        }
    }
}
