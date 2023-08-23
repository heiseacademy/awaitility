package com.github.sparsick.heise.awaitility;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class ConcurrencyDemoTest {

    @Test
    void naivConcurrencyTest() {
        var demo = new ConcurrencyDemo();
        demo.addItem("Hello World");

        while(!demo.hasNewItem()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        assertThat(demo.allItems()).contains("Hello World");
    }






}