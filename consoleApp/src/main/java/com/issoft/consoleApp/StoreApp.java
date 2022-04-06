package com.issoft.consoleApp;


import com.issoft.store.Store;
import com.issoft.store.helpers.StoreHelper;

public class StoreApp {

public static void main(String[] args){
    Store onlineStore = new Store();
    StoreHelper storeHelper = new StoreHelper(onlineStore);
    storeHelper.fillStoreRandomly();
    onlineStore.printAllCategoriesAndProducts();


}



}