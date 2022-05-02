package com.issoft.consoleApp;


import com.issoft.domain.Product;
import com.issoft.domain.categories.PhoneCategory;
import com.issoft.store.Store;
import com.issoft.store.helpers.CreatedOrder;
import com.issoft.store.helpers.StoreHelper;
import com.issoft.store.helpers.TimerCleanupTask;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StoreApp {

    public static <sortList> void main(String[] args) throws Exception {
        List<Product> totalProducts = Collections.synchronizedList(new ArrayList<>()); // bookkeeping
            Store onlineStore = Store.getStore();
            StoreHelper storeHelper = new StoreHelper(onlineStore);

            storeHelper.fillStoreRandomly();
            onlineStore.printAllCategoriesAndProducts();

            CreatedOrder order = new CreatedOrder(storeHelper.store.getAllProducts());
            CreatedOrder order1 = new CreatedOrder(storeHelper.store.getAllProducts());
            CreatedOrder order2 = new CreatedOrder(storeHelper.store.getAllProducts()); // 3 customers
            order.setTotalOrder(totalProducts);
            order1.setTotalOrder(totalProducts);
            order2.setTotalOrder(totalProducts);
            storeHelper.sortAllProducts();

            Thread thread = new Thread(order);
            thread.start();
            Thread thread1 = new Thread(order1);
            thread1.start();
            Thread thread2 = new Thread(order2);
            thread2.start();
            thread.join();
            thread1.join();
            thread2.join();

        System.out.println("**************************");
        System.out.println("Total bought products");
        System.out.println("**************************");
        totalProducts.forEach(System.out::println);

            //     System.out.println("Get products");


            //  onlineStore.printAllCategoriesAndProducts();
            //  List<Product> sortedProducts = storeHelper.sortAllProducts(Map.of("price", "desc"));
            //  System.out.println("\n\nTOP 5 products sorted by price, desc:");
            //  storeHelper.getTopNProducts(sortedProducts, 5).forEach(System.out::println);

//            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            Timer timer = new Timer();
            timer.schedule(new TimerCleanupTask(order.getTotalOrder()), 0L, 60_000L);

     /*
        boolean flag = true;
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

      */

    }
}