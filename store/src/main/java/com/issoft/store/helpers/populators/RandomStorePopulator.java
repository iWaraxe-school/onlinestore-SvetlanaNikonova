package com.issoft.store.helpers.populators;


import com.github.javafaker.Faker;
import com.issoft.domain.Category;
import com.issoft.domain.Product;
import org.reflections.Reflections;

import java.util.*;

public class RandomStorePopulator implements IPopulator {

    private Faker faker = new Faker();

    @Override
    public List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();
        Reflections reflections = new Reflections("com.issoft.domain.categories");

        Set<Class<? extends Category>> subTypes = reflections.getSubTypesOf(Category.class);

        for (Class<? extends Category> type : subTypes) {
            try{
                categories.add(type.getConstructor().newInstance());

            }catch (Exception e) {
                System.out.println("Exception was thrown with message: " + e.getLocalizedMessage());
            }
        }

        for (int i = 0; i < 10; i++){
            categories.add(new Category("Milk"));
        }
        return categories;

    }

    @Override
    public  List<Product> getProductsForCategory(ProductCategoryEnum category) {
        List<Product> resultList = new ArrayList<>();
        Random random = new Random();
        int productCount = random.nextInt(10);

        resultList.addAll(generateProductListForCategory(category, productCount));

        return  resultList;
    }

    private  List<Product> generateProductListForCategory(ProductCategoryEnum category, int count) {

        List<Product> products = new ArrayList<>();
        for (int i = 0; i <= count; i++){
            products.add(new Product(generateFakeProductName(category), getProductCategory(), getPrice(), getRate()));
        }

        return products;
    }

    private  String generateFakeProductName(ProductCategoryEnum category) {
        return getProductName(category.toString());
    }

    public String getProductCategory() {
        String[] categoryNames = new String[]{"Bike", "Phone", "Milk"};
        Random r = new Random();
        int randomNumber = r.nextInt(3);

        return categoryNames[randomNumber];
    }


    public String getProductName(String categoryName) {

        switch (categoryName) {
            case "Bike products":
                return faker.funnyName().name();
            case "Phone products":
                return faker.country().name();
            case "Milk products":
                return faker.food().ingredient();
            default:
                return faker.address().city();
        }

    }

    //JUST FOR TESTING ENUMS, MIGhT UPDATE THE REAL getProductName IF WORKING
    public String getProductName2(String categoryName) {

        switch (categoryName) {
            case "BIKE":
                return faker.funnyName().name();
            case "PHONE":
                return faker.country().name();
            case "MILK":
                return faker.food().ingredient();
            default:
                return faker.address().city();
        }

    }

    public double getPrice() {

        return faker.number().randomDouble(2, 1, 100);
    }

    public double getRate() {

        return faker.number().randomDouble(1, 0, 5);
    }


}







