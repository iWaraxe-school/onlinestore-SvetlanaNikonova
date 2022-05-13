package com.issoft.store.helpers.populators;

import com.issoft.domain.Category;
import com.issoft.domain.Product;
import com.issoft.store.helpers.DBManager;
import com.issoft.store.helpers.IDBManager;

import java.sql.SQLException;
import java.util.List;

public class DBPopulator implements IPopulator{

    public IDBManager dbManager;

    public  DBPopulator(){

        this.dbManager = new DBManager();
    }

    public DBPopulator(IDBManager dbManager) {

        this.dbManager = dbManager;
    }
    @Override
    public List<Category> getCategories() {

        try {
            if (dbManager.createTableIfDoesNotExist()) {
                fillDbByFaker();
            }

            return  dbManager.getAllCategories();

        } catch (Exception ex) {
            System.out.println("Exception was thrown in getCategories(). Message: " + ex.getLocalizedMessage());
            dbManager.dispose();

            return  (new RandomStorePopulator()).getCategories();
        }


    }

    @Override
    public List<Product> getProductsForCategory(ProductCategoryEnum categoryName){

        try {
            return dbManager.getProductsForCategory(categoryName.name());

        }catch (Exception e) {
            System.out.println("Exception was thrown in getProductsForCategory(). Message: " + e.getLocalizedMessage());
            dbManager.dispose();

            return ( new RandomStorePopulator()).getProductsForCategory((categoryName));
        }
    }

    private void fillDbByFaker() {

        try {
            RandomStorePopulator randomStorePopulator = new RandomStorePopulator();
            List<Category> categories = randomStorePopulator.getCategories();

            for (Category category: categories) {
                dbManager.insertCategoryIntoDB(category.getName());

                List<Product> products = randomStorePopulator.getProductsForCategory(ProductCategoryEnum.valueOf(category.getName()));

                for (Product p :products) {
                    dbManager.insertProductIntoDB(p.name, p.category, p.price, p.rate);
                }
            }

        }catch (SQLException e) {
            System.out.println("SQL Exception Message in fillDBByFaker(): " + e.getLocalizedMessage());
            dbManager.dispose();
        }
    }

}
