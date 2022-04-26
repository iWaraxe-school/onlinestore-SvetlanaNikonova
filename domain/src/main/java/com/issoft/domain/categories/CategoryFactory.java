package com.issoft.domain.categories;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CategoryFactory {


    public IProduct getCategory(ProductType product) {
        return getProductMap().get(product).get();
    }

    public Map<ProductType, Supplier<IProduct>> getProductMap() {
        Map<ProductType, Supplier<IProduct>> categoryTypeMap = new HashMap<>();
        categoryTypeMap.put(ProductType.BIKE, BikeCategory::new);
        categoryTypeMap.put(ProductType.MILK, MilkCategory::new);
        categoryTypeMap.put(ProductType.PHONE, PhoneCategory::new);
        return categoryTypeMap;
    }


}
