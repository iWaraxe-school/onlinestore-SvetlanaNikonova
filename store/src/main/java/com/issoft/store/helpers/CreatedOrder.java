package com.issoft.store.helpers;

import com.issoft.domain.Product;

import java.util.List;

public class CreatedOrder {

    private List<Product> purchasedCollection;
    private List<Product> ordersCompleted;

    public void setOrdersCompleted(List<Product> ordersCompleted) {
        this.ordersCompleted = ordersCompleted;
    }

    public List<Product> getOrdersCompleted() {
        return ordersCompleted;
    }

    public CreatedOrder(List<Product> purchasedCollection) {
        super();
        this.purchasedCollection = purchasedCollection;

        for (Product product : purchasedCollection) {
            Thread thread = new Thread();
        }
    }
}





