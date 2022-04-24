package com.issoft.domain.categories;

import com.issoft.domain.Category;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CategoryFactory {


    public Category getCategory(CategoryType category) {
        return getCategoryMap().get(category).get();
    }

    public Map<CategoryType, Supplier<Category>> getCategoryMap() {
        Map<CategoryType, Supplier<Category>> categoryTypeMap = new HashMap<>();
        categoryTypeMap.put(CategoryType.BIKE, BikeCategory::new);
        categoryTypeMap.put(CategoryType.MILK, MilkCategory::new);
        categoryTypeMap.put(CategoryType.PHONE, PhoneCategory::new);
        return categoryTypeMap;
    }


}
