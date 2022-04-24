package com.issoft.domain.categories;

import com.issoft.domain.Category;
import com.issoft.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class Patterns {
    public static void main(String[] args) {
        CategoryFactory categoryFactory = new CategoryFactory();
        Category bike = categoryFactory.getCategory(CategoryType.BIKE);
        Category milk = categoryFactory.getCategory(CategoryType.MILK);
        Category phone = categoryFactory.getCategory(CategoryType.PHONE);
        List<Category> categories = new ArrayList<>();
        categories.add(bike);
        categories.add(milk);
        categories.add(phone);

        for (Category category: categories) {
            category.printAllProducts();
        }
    }}
