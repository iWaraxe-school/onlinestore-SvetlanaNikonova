package com.issoft.consoleApp;


import com.issoft.domain.Product;
import com.issoft.domain.categories.PhoneCategory;
import com.issoft.store.Store;
//import com.issoft.store.helpers.CreatedOrder;
import com.issoft.store.helpers.StoreHelper;
import com.issoft.store.helpers.TimerCleanupTask;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StoreApp {

    public static void main(String[] args)  {

        try{
        Store onlineStore = Store.getStore();
        StoreHelper storeHelper = new StoreHelper(onlineStore);

        storeHelper.fillStoreRandomly();
        onlineStore.printAllCategoriesAndProducts();



        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            Timer timer = new Timer();

            timer.schedule(new TimerCleanupTask(),0, 30000);




        Boolean flag = true;
        while (flag) {

            System.out.println("Enter command sort/top/createOrder/quit: ");
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
                case "createOrder":
                    System.out.println("Enter name of product to order: ");
                    String productName = reader.readLine();

                    storeHelper.createOrder(productName);
                    break;
                case "quit":
                    timer.cancel();
                    storeHelper.shutdownThreads();

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






