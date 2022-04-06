package com.issoft.store;

import com.issoft.domain.Category;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {



    private List<Category> categoryList = new ArrayList<>();

    public void addCategory(Category category) {
        categoryList.add(category);

    }

    public void printAllCategoriesAndProducts() {
        for (Category category : categoryList) {
            category.printAllProducts();
        }
    }



}
