package lengthconvertertest2;

import java.util.Arrays;
import java.util.Collection;
import static lengthconverter.LengthConverter.*;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * jUnits for the LenConverter static methods kmToMile and milToKm
 *
 * @author Tomislav S. Mitic
 */
@RunWith(value=Parameterized.class)
public class LengthConverterTest2 {

  private LengthConverterTest2 self = this;
  private Double kilometers;
  private Double miles;

  public LengthConverterTest2(Double kilometers, Double miles) {
    self.kilometers = kilometers;
    self.miles = miles;
  }

  @Parameters
  public static Collection data() {
    return Arrays.asList(new Double[][] {
      {25.5, 15.84497},   // kilometers, miles
      {100.98, 62.746063},
      {345.678, 214.794351},
      {1100.9856, 684.120734908},
      {4830.365549, 3001.45}
    });
  }

  @Test
  public void LengthConverterTest() {
    assertEquals(kmToMile(self.kilometers), self.miles, 0.0001);
    assertEquals(mileToKm(self.miles), self.kilometers, 0.0001);
  }
}