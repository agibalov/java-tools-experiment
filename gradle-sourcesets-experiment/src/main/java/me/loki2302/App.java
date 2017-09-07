package me.loki2302;

public class App {
    public static void main(String[] args) {
        System.out.printf(
                "Hello world! I have FeatureA: %b\n",
                hasFeature("me.loki2302.FeatureA"));
    }

    private static boolean hasFeature(String featureClassName) {
        try {
            App.class.getClassLoader().loadClass(featureClassName);
        } catch (ClassNotFoundException e) {
            return false;
        }

        return true;
    }
}
