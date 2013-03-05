package edu.depaul.se433;

import edu.depaul.se433.Orders.ShippingMethod;
import static edu.depaul.se433.Orders.calculateTotal;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Parameterized Special Value Tests for the {@link Orders.calculateTotal} method.
 *
 * @author Tomislav S. Mitic
 */
@RunWith(value=Parameterized.class)
public class CalculateTotalSpecialValuesTest {

  CalculateTotalSpecialValuesTest self = this;
  private float itemTotal;
  private ShippingMethod method;
  private String state;
  private float expected;

  public CalculateTotalSpecialValuesTest(float expected, Object[] inputs) {
    self.itemTotal = Float.parseFloat(inputs[0].toString());
    self.method = (ShippingMethod) inputs[1];
    self.state = (String) inputs[2];
    self.expected = (float) expected;
  }

  @Parameters
  public static Collection data() {
    return Arrays.asList(new Object[][]{
      {35.00f, new Object[]{25.00f, ShippingMethod.Standard, "D.C."}},
      {75.00f, new Object[]{75.00f, ShippingMethod.Standard, "D.C."}},
      {50.00f, new Object[]{25.00f, ShippingMethod.NextDay, "D.C."}},
      {75.00f, new Object[]{75.00f, ShippingMethod.NextDay, "D.C."}},
      {79.50f, new Object[]{75.00f, ShippingMethod.Standard, "CA"}},
      {79.50f, new Object[]{75.00f, ShippingMethod.NextDay, "California"}},
      {79.50f, new Object[]{75.00f, ShippingMethod.Standard, "NY"}},
      {79.50f, new Object[]{75.00f, ShippingMethod.NextDay, "New York"}},
      {79.50f, new Object[]{75.00f, ShippingMethod.Standard, "IL"}},
      {75.00f, new Object[]{75.00f, ShippingMethod.NextDay, "Illinois"}},
      {36.50f, new Object[]{25.00f, ShippingMethod.Standard, "CA"}},
      {36.50f, new Object[]{25.00f, ShippingMethod.NextDay, "California"}},
      {36.50f, new Object[]{25.00f, ShippingMethod.Standard, "NY"}},
      {36.50f, new Object[]{25.00f, ShippingMethod.NextDay, "New York"}},
      {36.50f, new Object[]{25.00f, ShippingMethod.Standard, "IL"}},
      {36.50f, new Object[]{25.00f, ShippingMethod.NextDay, "Illinois"}}
    });
  }

  @Test
  public void calculateTotalSpecialValueTest() {
    assertEquals(self.expected, calculateTotal(self.itemTotal, self.method,
            self.state), 0.0001);
  }
}
