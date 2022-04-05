package com.issoft.store;

import com.issoft.domain.Category;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {

    private Map<Category, Integer> categoryProductMap = new HashMap<>();

    private List<Category> categoryList = new ArrayList<Category>();

    public Store() {

    }

    public void printAllCategoriesAndProducts() {
        for (Category category : categoryList) {
            category.printAllProducts();
        }
    }

    public void addCategory(Category category) {
        categoryList.add(category);
    }

}
