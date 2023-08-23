package com.github.sparsick.heise.awaitility;


import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.hamcrest.Matchers.equalTo;


class ConcurrencyDemoTest {

    @Test
    void concurrencyTest() {
        var demo = new ConcurrencyDemo();
        demo.addItem("Hello World");
        demo.addItem("Hello Earth");

        await().atMost(25, TimeUnit.SECONDS).until(sizeOfItems(demo), equalTo(2));


        assertThat(demo.allItems()).contains("Hello World");
    }

    private Callable<Integer> sizeOfItems(ConcurrencyDemo demo) {
        return () -> demo.allItems().size();
    }


}