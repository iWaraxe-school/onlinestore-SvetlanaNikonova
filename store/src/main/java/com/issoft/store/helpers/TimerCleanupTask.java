package com.issoft.store.helpers;

import com.issoft.domain.Product;
import com.issoft.store.Store;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.TimerTask;

public class TimerCleanupTask extends TimerTask {


    List<Product> ordersCompleted;

    public TimerCleanupTask(List<Product> ordersCompleted) {
        this.ordersCompleted = ordersCompleted;
    }



    public void run() {

        ordersCompleted.clear();

        DateTimeFormatter dft = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Clean up purchased list + " + dft.format(now));



    }
}
