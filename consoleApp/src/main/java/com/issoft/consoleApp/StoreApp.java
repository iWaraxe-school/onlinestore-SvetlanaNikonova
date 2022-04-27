package com.issoft.consoleApp;


import com.issoft.domain.Product;
import com.issoft.store.Store;
import com.issoft.store.helpers.StoreHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StoreApp {

    public static <sortList> void main(String[] args) throws IOException {
        try {
        Store onlineStore =  Store.getStore();

        StoreHelper storeHelper = new StoreHelper(onlineStore);
        storeHelper.fillStoreRandomly();
//        onlineStore.printAllCategoriesAndProducts();
//        List<Product> sortedProducts = storeHelper.sortAllProducts(Map.of("price", "desc"));
//        System.out.println("\n\nTOP 5 products sorted by price, desc:");
//        storeHelper.getTopNProducts(sortedProducts, 5).forEach(System.out::println);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Boolean flag = true;
        while (flag) {

            System.out.println("Enter command sort/top/quit: ");
            String command = reader.readLine();

            System.out.println("Your command is : " + command);
            switch (command) {
                case "sort":
                    List products = storeHelper.sortAllProducts();
                   storeHelper.printProducts(products);
                    break;
                case "top":
                    System.out.println("Print top 5 products sorted via price desc.");
                    List<Product> sortedProducts = storeHelper.sortAllProducts();
                    List<Product> topNProducts = storeHelper.getTopNProducts(sortedProducts, 5);
                    storeHelper.printProducts(topNProducts);
                    break;
                case "quit":
                    flag = false;
                    break;
                default:
                    System.out.println("The command is not recognized.");
            }
        }
    } catch(
    Exception e)

    {
        System.out.println("Error: the exception was thrown with message:" + e.getMessage());
    }

}

}