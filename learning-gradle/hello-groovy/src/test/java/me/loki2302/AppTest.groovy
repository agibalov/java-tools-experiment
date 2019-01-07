package me.loki2302;

import org.junit.Test
import static org.junit.Assert.*

public class AppTest {
  @Test
  public void dummyTest() {
    def message = App.makeMessage()
    assertEquals "hello world", message
  }
}
