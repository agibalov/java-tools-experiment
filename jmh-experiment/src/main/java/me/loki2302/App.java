package me.loki2302;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.util.Statistics;

import java.util.Collection;

public class App {
    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(App.class.getSimpleName() + ".dummy")
                .mode(Mode.AverageTime)
                .warmupIterations(3)
                .measurementIterations(3)
                .forks(0)
                .build();

        Collection<RunResult> runResults = new Runner(options).run();

        System.out.printf("\n\n\n");

        for(RunResult runResult : runResults) {
            String benchmarkName = runResult.getParams().getBenchmark();
            long sampleCount = runResult.getPrimaryResult().getSampleCount();

            Statistics statistics = runResult.getPrimaryResult().getStatistics();
            double min = statistics.getMin();
            double max = statistics.getMax();
            double mean = statistics.getMean();

            System.out.printf("%s (%d) - %f/%f/%f\n", benchmarkName, sampleCount, min, mean, max);
        }
    }

    @Benchmark
    public void dummy() throws InterruptedException {
        Thread.sleep(900);
    }

    @Benchmark
    public void omg() throws InterruptedException {
        Thread.sleep(300);
    }
}
