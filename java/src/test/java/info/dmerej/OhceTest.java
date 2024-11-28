package info.dmerej;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

public class OhceTest {
  @Test
  void testMainLoop() {
    /*
     TODO: check that given the following inputs:
      - hello
      - oto
      - quit

    The following messages are shown to the user:
     - olleh
     - oto
     - That was a palindrome!

    */
    // GIVEN
    ConsoleInteractor interactor = mock(ConsoleInteractor.class);
    Ohce ohce = new Ohce(interactor);

    // WHEN
    when(interactor.readInput()).thenReturn("hello", "oto", "quit");

    // WHEN
    ohce.mainLoop();

    // THEN
    verify(interactor).printMessage("olleh"); // "hello" reversed
    verify(interactor).printMessage("oto");  // "oto" reversed
    verify(interactor).printMessage("That was a palindrome!"); // Palindrome message for "quit"
    verify(interactor, never()).printMessage("quit");
  }
}
