package com.issoft.store;

import com.issoft.domain.Category;
import com.issoft.domain.Product;


import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Store {

    private static Store StoreSingle = new Store();
  //  public ObjectInputStream.ValidationList purchasedCollection;

    private Store() {}

    public static Store getStore() {
        return StoreSingle;
    }

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
