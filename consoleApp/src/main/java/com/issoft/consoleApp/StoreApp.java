package com.issoft.consoleApp;


import com.issoft.domain.Product;
import com.issoft.store.Store;
import com.issoft.store.helpers.StoreHelper;
import com.issoft.store.helpers.TimerCleanupTask;
import com.issoft.store.helpers.populators.*;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class StoreApp {

    public static void main(String[] args)  {

        IPopulator populator = null;

        try{
        Store onlineStore = Store.getStore();
        StoreHelper storeHelper = new StoreHelper(onlineStore);

            CategoryEnum populatorType = CategoryEnum.HttpPopulator;

            switch (populatorType) {
                case RandomStorePopulator:
                    populator = new RandomStorePopulator();
                    break;
                case DBPopulator:
                    populator = new DBPopulator();
                    break;
                case HttpPopulator:
                    populator = new HttpPopulator();
                    break;
            }

        storeHelper.fillStoreRandomly();
        onlineStore.printAllCategoriesAndProducts();



        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

           Timer timer = new Timer();
           timer.schedule(new TimerCleanupTask(),0, 60000);




        boolean flag = true;
        while (flag) {

            System.out.println("Enter command sort/top/createOrder/ad/quit: ");
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
                case "addToCart":
                    System.out.println("Enter name of product to add");
                    String product = reader.readLine();

                    if (populator instanceof  HttpPopulator) {
                        ((HttpPopulator) populator).addToCart(product);
                        System.out.println("Products in the cart:");
                        onlineStore.printListProducts(((HttpPopulator)populator).getProducts());
                    }
                    else {
                        System.out.println(" 'Add to cart' command is not found");
                    }
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






