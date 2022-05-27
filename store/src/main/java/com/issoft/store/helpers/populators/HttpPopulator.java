package com.issoft.store.helpers.populators;

import com.issoft.domain.Category;
import com.issoft.domain.Product;
import com.issoft.store.httpServer.HttpClient;

import java.util.List;

public class HttpPopulator implements IHttpPopulator, IPopulator{

    private final HttpClient httpClient = new HttpClient();

    @Override
    public List<Category> getAllCategories() {
        return httpClient.getAllCategories();
    }

    @Override
    public void addToCart(String productName) {

        Product product = new Product(productName, "Milk", 2.00, 1.5);

        httpClient.addProductToCart(product);
    }

    @Override
    public List<Category> getCategories() {
        return null;
    }

    public List<Product> getProducts() {
        return httpClient.getAllProducts();
    }

    @Override
    public List<Product> getProductsForCategory(ProductCategoryEnum category) {
        return List.of(new Product("Test milk", "Milk", 1.0, 1.5));
    }
}


