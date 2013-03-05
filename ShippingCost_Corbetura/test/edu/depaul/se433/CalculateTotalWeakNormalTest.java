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
 * Parameterized Weak Normal Tests for the {@link Orders.calculateTotal} method.
 *
 * @author Tomislav S. Mitic
 */
@RunWith(value=Parameterized.class)
public class CalculateTotalWeakNormalTest {

  CalculateTotalWeakNormalTest self = this;
  private float itemTotal;
  private ShippingMethod method;
  private String state;
  private float expected;

  public CalculateTotalWeakNormalTest(float expected, Object[] inputs) {
    self.itemTotal = Float.parseFloat(inputs[0].toString());;
    self.method = (ShippingMethod) inputs[1];
    self.state = (String) inputs[2];
    self.expected = (float) expected;
  }

  @Parameters
  public static Collection data() {
    return Arrays.asList(new Object[][]{
      {36.50f, new Object[]{25.00f, ShippingMethod.Standard, "IL"}},
      {75f, new Object[]{75f, ShippingMethod.NextDay, "IN"}}
    });
  }

  @Test
  public void calculateTotalWeakNormalTest() {
    assertEquals(self.expected, calculateTotal(self.itemTotal, self.method,
            self.state), 0.0001);
  }
}
