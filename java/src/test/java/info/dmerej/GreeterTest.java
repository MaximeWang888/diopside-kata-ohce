package info.dmerej;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GreeterTest {
  @Test
  void nightlyGreeting() {
    // Assert that greeter says "Good night" when current hour is 0 (midnight)

    // GIVING
    SystemClock customClock = mock(SystemClock.class);
    Greeter greeter = new Greeter(customClock);

    // WHEN
    when(customClock.getCurrentHour()).thenReturn(0);
    String greeterMsg = greeter.greet();

    // THEN
    assertEquals(greeterMsg, "Good night");
  }

  @Test
  void neverAsserts() {
    // Assert that the assertion in greet() is never thrown, by checking all hours from 0 to 23;

    // GIVING
    SystemClock customClock = mock(SystemClock.class);
    Greeter greeter = new Greeter(customClock);

    for (int i = 0; i <= 23; i++) {
      // WHEN
      when(customClock.getCurrentHour()).thenReturn(i);

      // THEN
      assertDoesNotThrow(greeter::greet);
    }
  }
}
