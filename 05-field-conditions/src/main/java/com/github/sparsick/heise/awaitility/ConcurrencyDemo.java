package com.github.sparsick.heise.awaitility;

import java.util.ArrayList;
import java.util.List;

public class ConcurrencyDemo {
    // Pseudo Concurrency

    private boolean newItem = false;
    private List<String> items = new ArrayList<>();


    void addItem (String item) {
        newItem = false;
        Runnable runnable = () -> {
            try {
                Thread.sleep(10000);
                items.add(item);
                newItem = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(runnable).start();

    }

    boolean hasNewItem(){
        return newItem;
    }

    List<String> allItems() {
        return items;
    }
}