package com.issoft.store.helpers;


import com.issoft.domain.Category;
import com.issoft.domain.Product;
import com.issoft.store.Store;
import com.issoft.store.helpers.comparators.ProductComparator;
import com.issoft.store.helpers.comparators.SortOrder;
import com.issoft.store.helpers.comparators.XMLParser;
import org.reflections.Reflections;

import javax.xml.parsers.ParserConfigurationException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class StoreHelper {

    public Store store;

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
     //  Map<String, String> sortBy = new HashMap<>();
     //   sortBy.put("price", SortOrder.DESC.toString());

     //   List<Product> sortedList = sortAllProducts(sortBy);
    //   List<Product> top5 = new ArrayList<>(sortedList.subList(0, 5));

    //   return sortedList;
    }

        public void printProducts(List<Product> products) {
            products.forEach(System.out::println);
        }

    public void createOrder(String productName) {

    }
}







