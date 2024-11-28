package info.dmerej;

import java.time.LocalTime;

public class SystemClock  {
  public int getCurrentHour() {
    return LocalTime.now().getHour();
  }
}
