package com.issoft.store.helpers;

import com.issoft.domain.Product;

import java.util.List;

public class CreatedOrder implements Runnable{

    private final List<Product> cart;
    private List<Product> totalOrder;

    public void setTotalOrder(List<Product> totalOrder) {
        this.totalOrder = totalOrder;
    }

    public List<Product> getTotalOrder() {
        return totalOrder;
    }

    public CreatedOrder(List<Product> cart) {
        this.cart = cart;
        }

    @Override
    public void run() {
        sleep();
        System.out.println("Starting order");
        for (Product product :
                cart) {
            System.out.println("Product " + product);
            totalOrder.add(product);
        }
        System.out.println("Finish order");
    }

    private void sleep() {
        try {
            Thread.sleep(30_000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}






