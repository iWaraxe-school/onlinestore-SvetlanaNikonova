package com.issoft.store.helpers;


import com.github.javafaker.Faker;

public class RandomStorePopulator {

    private Faker faker = new Faker();

    public RandomStorePopulator() {
    }

    public String getProductName(String categoryName) {

        switch (categoryName) {
            case "Bike":
                return faker.funnyName().name();
            case "Phone":
                return faker.country().name();
            case "Milk":
                return faker.food().ingredient();
            default:
                return null;
        }

    }

    public double getPrice() {

        return faker.number().randomDouble(2, 1, 100);
    }

    public double getRate() {

        return faker.number().randomDouble(1, 0, 5);
    }

   // public String getName() {

   //     return faker.name().username();
   // }
}







