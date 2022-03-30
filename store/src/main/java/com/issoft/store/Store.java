package com.issoft.store;

import com.issoft.domain.Category;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Category> categoryList = new ArrayList<>();


    public void printAllCategoriesAndProducts() {
        for (Category category : categoryList) {
            category.printAllProducts();
        }
    }

}
