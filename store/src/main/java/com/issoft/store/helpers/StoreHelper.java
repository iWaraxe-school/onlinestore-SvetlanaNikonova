package com.issoft.store.helpers;


import com.issoft.domain.Category;
import com.issoft.domain.Product;
import com.issoft.store.Store;
import com.issoft.store.helpers.comparators.ProductComparator;
import com.issoft.store.helpers.comparators.XMLParser;
import com.issoft.store.helpers.populators.RandomStorePopulator;
import org.reflections.Reflections;

import javax.xml.parsers.ParserConfigurationException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StoreHelper {

    Store store;
    public ExecutorService executorService = Executors.newFixedThreadPool(3);

    public StoreHelper(Store store) {
        this.store = store;
    }


    public void fillStoreRandomly() {

        RandomStorePopulator populator = new RandomStorePopulator();
        Map<Category, Integer> categoryMap = createCategoryMap();

        for (Map.Entry<Category, Integer> entry : categoryMap.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {

                Product product = new Product(
                        populator.getProductName(entry.getKey().getName()),
                        populator.getProductCategory(),
                        populator.getPrice(),
                        populator.getRate());
                entry.getKey().addProductToCategory(product);
            }
            this.store.addCategory(entry.getKey());
        }
    }

    private static Map<Category, Integer> createCategoryMap() {
        Map<Category, Integer> categoryToPut = new HashMap<>();

        Reflections reflections = new Reflections("com.issoft.domain.categories");

        Set<Class<? extends Category>> subTypes = reflections.getSubTypesOf(Category.class);

        for (Class<? extends Category> type : subTypes) {
            try {
                Random random = new Random();
                categoryToPut.put(type.getConstructor().newInstance(), random.nextInt(10));
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return categoryToPut;
    }


    public List<Product> sortAllProducts() throws Exception {
        Map<String, String> sortBy;
        try {
            XMLParser xml = new XMLParser();
            sortBy = xml.getAllPropertiesToSort();
        } catch (ParserConfigurationException e) {
            throw new Exception("Error : Config file exception.");
        }
        return sortAllProducts(sortBy);

    }

    public List<Product> sortAllProducts(Map<String, String> sortBy) {

        List<Product> allProducts = this.store.getAllProducts();
        allProducts.sort(new ProductComparator(sortBy));

        return allProducts;
    }

    public List<Product> getTopNProducts(List<Product> products, int n) {

        return products.subList(0, n);

    }

    public void printProducts(List<Product> products) {
       products.forEach(System.out::println);
    }

    public void createOrder(String productName) {

        System.out.println(String.format("%s", "createOrder() is started " + Thread.currentThread().getName()));

        Product orderedProduct = getOrderedProduct(productName);
        int threadTime = new Random().nextInt(30);

        executorService.execute(() -> {
            try {
                System.out.println(String.format("Starting order thread %s", Thread.currentThread().getName()));
                store.purchasedProductList.add(orderedProduct);

                System.out.println(String.format("Actual purchased product list:createOrder "));
                store.printListProducts(store.purchasedProductList);

                System.out.println(String.format("Sleeping for " + threadTime));
                Thread.sleep(threadTime * 1000);

                System.out.println(String.format("Finishing order thread %s", Thread.currentThread().getName()));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        System.out.println(String.format("createOrder() is finished " + Thread.currentThread().getName()));
    }

    public void shutdownThreads() {
        executorService.shutdown();
    }

    private Product getOrderedProduct(String productName) {
        return Optional.of(productName)
                .map(name -> store.getAllProducts().stream()
                        .filter(product -> name.equals(product.name))
                        .findFirst().orElseThrow())
                .orElseThrow();
    }

}












