package me.loki2302;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
  @Test
  public void oneAndTwoIsThree() {
    Calculator calculator = new Calculator();
    assertEquals(3, calculator.add(1, 2));
  }
}
