package io.agibalov;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@State(Scope.Thread)
public class DummyBenchmark {
    public List<Integer> data;

    @Setup(Level.Trial)
    public void doSetup() {
        Random random = new Random();

        data = new ArrayList<>();
        for(int i = 0; i < 1000; ++i) {
            data.add(random.nextInt());
        }
    }

    @Benchmark
    @Threads(1)
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
    public Object helloWorld() {
        return data.stream().sorted().collect(Collectors.toList());
    }
}
