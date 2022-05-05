package com.issoft.store.helpers;

import com.issoft.domain.Product;
import com.issoft.store.Store;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.TimerTask;

public class TimerCleanupTask extends TimerTask {

    Store store;


    public void run() {

        store.purchasedProductList.clear();

        DateTimeFormatter dft = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Clean up purchased list + " + dft.format(now));



    }
}
