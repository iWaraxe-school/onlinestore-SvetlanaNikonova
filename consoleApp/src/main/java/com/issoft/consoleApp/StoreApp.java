package com.issoft.consoleApp;


import com.issoft.domain.Product;
import com.issoft.store.Store;
import com.issoft.store.helpers.StoreHelper;

import java.util.*;

public class StoreApp {

public static void main(String[] args){
    Store onlineStore = new Store();
    StoreHelper storeHelper = new StoreHelper(onlineStore);
    storeHelper.fillStoreRandomly();
    onlineStore.printAllCategoriesAndProducts();
    List<Product> sortedProducts = storeHelper.sortAllProducts(Map.of("price", "desc"));
    System.out.println("\n\nTOP 5 products sorted by price, desc:");
    storeHelper.getTopNProducts(sortedProducts, 5).forEach(System.out::println);


}



}