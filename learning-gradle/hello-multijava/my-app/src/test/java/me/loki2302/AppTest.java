package me.loki2302;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
  @Test
  public void messageIsOk() {
    String message = App.makeMessage();
    assertEquals("1 + 2 is 3", message);
  }
}
