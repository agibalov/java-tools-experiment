package me.loki2302;

public class App {
  public static void main(String[] args) {
    String message = makeMessage();
    System.out.println(message);
  }

  public static String makeMessage() {
    Calculator calculator = new Calculator();
    return String.format("1 + 2 is %d", calculator.add(1, 2));
  }
}
