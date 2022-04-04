package com.issoft.consoleApp;

import com.issoft.domain.Category;
import com.issoft.domain.Product;
import com.issoft.domain.categories.BikeCategory;
import com.issoft.domain.categories.MilkCategory;
import com.issoft.domain.categories.PhoneCategory;
import com.issoft.store.Store;

public class StoreApp {

public static void main(String[] args){

Store store = new Store();
Category bikes = new BikeCategory();
Category milk = new MilkCategory();
Category phone = new PhoneCategory();
store.addCategory(bikes);
store.addCategory(milk);
store.addCategory(phone);

Product superBike = new Product("Panda", 1000.0, 15.0);
Product milkMu = new Product("Muu", 1.99, 0.5);
Product phoneApple = new Product("SE", 800.5, 2.5);

bikes.addProduct(superBike);
milk.addProduct(milkMu);
phone.addProduct(phoneApple);

store.printAllCategoriesAndProducts();

}



}