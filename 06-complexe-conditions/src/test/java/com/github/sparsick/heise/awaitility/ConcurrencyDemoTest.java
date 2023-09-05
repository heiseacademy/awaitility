package com.github.sparsick.heise.awaitility;


import org.awaitility.Durations;
import org.awaitility.pollinterval.FibonacciPollInterval;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.Socket;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.awaitility.Awaitility.given;
import static org.awaitility.pollinterval.IterativePollInterval.iterative;
import static org.hamcrest.Matchers.instanceOf;


class ConcurrencyDemoTest {

    @Test
    void exceptionHandlingDemo() {

//        given().ignoreExceptions().await().until(()-> new Socket("localhost", 4000) != null);

    }




    @Test
    void concurrencyTest() {
        var demo = new ConcurrencyDemo();
        demo.addItem("Hello World");

        await().pollInterval(iterative(duration -> duration.multipliedBy(4), Duration.ofSeconds(1))).atMost(20, TimeUnit.SECONDS).until(() -> demo.hasNewItem());


        assertThat(demo.allItems()).contains("Hello World");
    }


}