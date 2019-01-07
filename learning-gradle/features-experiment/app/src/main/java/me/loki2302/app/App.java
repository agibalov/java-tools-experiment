package me.loki2302.app;

import me.loki2302.featurea.FeatureAService;
import me.loki2302.featureb.FeatureBService;

public class App {
    public static void main(String[] args) {
        try {
            Class.forName("me.loki2302.featurea.FeatureAService");
            System.out.println("Detected FeatureAService");

            new FeatureAService().doSomething();
        } catch (ClassNotFoundException e) {
            System.out.println("Didn't find FeatureAService");
        }

        try {
            Class.forName("me.loki2302.featureb.FeatureBService");
            System.out.println("Detected FeatureBService");

            new FeatureBService().doSomething();
        } catch (ClassNotFoundException e) {
            System.out.println("Didn't find FeatureBService");
        }
    }
}
