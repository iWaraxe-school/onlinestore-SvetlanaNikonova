package com.issoft.store.helpers;


import com.github.javafaker.Faker;

public class RandomStorePopulator {

    private Faker faker = new Faker();

    public RandomStorePopulator() {
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







