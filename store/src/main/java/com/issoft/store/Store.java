package com.issoft.store;

import com.issoft.domain.Category;
import com.issoft.domain.Product;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Product> getAllProducts() {
        return categoryList.stream()
                .flatMap(category -> category.getProductList().stream())
                .collect(Collectors.toList());
    }


    public void sortAllProducts() {
    }

    public void getTop5() {
    }
}
