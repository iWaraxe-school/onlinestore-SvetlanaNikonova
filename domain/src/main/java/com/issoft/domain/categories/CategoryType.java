package com.issoft.domain.categories;

import com.issoft.domain.Category;

import java.util.function.Supplier;

public enum CategoryType {
    BIKE(BikeCategory::new),
    PHONE(PhoneCategory::new),
    MILK(MilkCategory::new);

    private Supplier<Category> categorySupplier;

    CategoryType(Supplier<Category> categorySupplier) {
        this.categorySupplier = categorySupplier;
    }

    public Supplier<Category> getCategorySupplier() {
        return categorySupplier;
    }
}
