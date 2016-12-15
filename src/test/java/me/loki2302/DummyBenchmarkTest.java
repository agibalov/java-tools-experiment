package me.loki2302;

import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.VerboseMode;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DummyBenchmarkTest {
    @Test
    public void myBenchmarkShouldBeFastEnough() {
        RunResult runResult = run(DummyBenchmarkTest.class, "myBenchmark");
        assertEquals(3, runResult.getPrimaryResult().getSampleCount());

        double mean = runResult.getPrimaryResult().getStatistics().getMean();
        assertTrue(mean >= 0.25 && mean <= 0.35);
    }

    @Benchmark
    public void myBenchmark() throws InterruptedException {
        Thread.sleep(300);
    }

    private static RunResult run(Class<?> clazz, String methodName) {
        String jmhIncludeRegexp = String.format("%s.%s", clazz.getSimpleName(), methodName);
        Options options = new OptionsBuilder()
                .include(jmhIncludeRegexp)
                .mode(Mode.AverageTime)
                .warmupIterations(3)
                .measurementIterations(3)
                .forks(0)
                .verbosity(VerboseMode.EXTRA)
                .build();

        try {
            Collection<RunResult> runResults = new Runner(options).run();
            if (runResults.size() != 1) {
                throw new RuntimeException();
            }

            return runResults.stream().findAny().get();
        } catch (RunnerException e) {
            throw new RuntimeException(e);
        }
    }

}
