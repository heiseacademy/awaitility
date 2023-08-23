package com.github.sparsick.heise.awaitility;


import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;


class ConcurrencyDemoTest {

    @Test
    void naivConcurrencyTest() {
        var demo = new ConcurrencyDemo();
        demo.addItem("Hello World");

        await().atMost(20, TimeUnit.SECONDS).until(() -> demo.hasNewItem());


        assertThat(demo.allItems()).contains("Hello World");
    }






}