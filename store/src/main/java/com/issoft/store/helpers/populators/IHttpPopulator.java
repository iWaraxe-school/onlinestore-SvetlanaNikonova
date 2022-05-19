package com.issoft.store.helpers.populators;

import com.issoft.domain.Category;
import com.issoft.domain.Product;

import java.util.List;

public interface IHttpPopulator {

    List<Category> getAllCategories();

    void addToCart(String product);
}

