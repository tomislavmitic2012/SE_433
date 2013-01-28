package lengthconvertertest;

import static lengthconverter.LengthConverter.*;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * jUnits for the LenConverter static methods kmToMile and milToKm
 *
 * @author Tomislav S. Mitic
 */
public class LengthConverterTest {

  @Test
  public void LengthConverterTest() {
    Double exp, act;

    try {
      kmToMile(-300.45);
      fail("IllegalArgumentException should have been thrown.");
    } catch (IllegalArgumentException e) {
      String expected = "Value: -300.45; is negative.";
      String actual = e.getMessage();
      Assert.assertEquals(expected, actual);
    }

    exp = 300.45 * KM_IN_MILES;
    act = kmToMile(300.45);
    assertEquals(exp, act, 0.0001);

    try {
      mileToKm(-186.96);
      fail("IllegalArgumentException should have been thrown.");
    } catch (IllegalArgumentException e) {
      String expected = "Value: -186.96; is negative.";
      String actual = e.getMessage();
      Assert.assertEquals(expected, actual);
    }

    exp = 186.69 / KM_IN_MILES;
    act = mileToKm(186.69);
    assertEquals(exp, act, 0.0001);
  }
}