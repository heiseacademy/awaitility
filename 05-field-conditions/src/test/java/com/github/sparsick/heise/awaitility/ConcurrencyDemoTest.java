package com.github.sparsick.heise.awaitility;


import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.awaitility.Awaitility.fieldIn;


class ConcurrencyDemoTest {

    @Test
    void concurrencyTest() {
        var demo = new ConcurrencyDemo();
        demo.addItem("Hello World");

        await().atMost(20, TimeUnit.SECONDS).until(fieldIn(demo).ofType(boolean.class).andWithName("newItem"), Matchers.is(true));


        assertThat(demo.allItems()).contains("Hello World");
    }
}