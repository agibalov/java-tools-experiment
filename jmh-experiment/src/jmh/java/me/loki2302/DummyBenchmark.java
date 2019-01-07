package me.loki2302;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class DummyBenchmark {
    @State(Scope.Thread)
    public static class SortState {
        public List<Integer> data;

        @Setup(Level.Trial)
        public void doSetup() {
            Random random = new Random();

            data = new ArrayList<>();
            for(int i = 0; i < 1000; ++i) {
                data.add(random.nextInt());
            }
        }
    }

    @Benchmark
    public void helloWorld(SortState sortState) {
        sortState.data.sort(Comparator.naturalOrder());
    }
}
