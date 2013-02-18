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
 * Parameterized Weak Robustness Tests for the
 * {@link Orders.calculateTotal} method.
 *
 * @author Tomislav S. Mitic
 */
@RunWith(value=Parameterized.class)
public class CalculateTotalStrongRobustnessTest {

  CalculateTotalStrongRobustnessTest self = this;
  private float itemTotal;
  private ShippingMethod method;
  private String state;
  private IllegalArgumentException expected;

  private static IllegalArgumentException exceptionTotal = new IllegalArgumentException(
          "Total must be positive.");
  private static IllegalArgumentException exceptionState = new IllegalArgumentException(
          "Incorrect state destination.");

  public CalculateTotalStrongRobustnessTest(IllegalArgumentException expected,
          Object[] inputs) {
    self.itemTotal = Float.parseFloat(inputs[0].toString());;
    self.method = (ShippingMethod) inputs[1];
    self.state = (String) inputs[2];
    self.expected = (IllegalArgumentException) expected;
  }

  @Parameters
  public static Collection data() {
    return Arrays.asList(new Object[][]{
      {exceptionTotal, new Object[]{-25.00f, ShippingMethod.Standard, "IL"}},
      {exceptionTotal, new Object[]{-25.00f, ShippingMethod.NextDay, "IL"}},
      {exceptionTotal, new Object[]{-75.00f, ShippingMethod.Standard, "IL"}},
      {exceptionTotal, new Object[]{-75.00f, ShippingMethod.NextDay, "IL"}},
      {exceptionTotal, new Object[]{-25.00f, ShippingMethod.Standard, "IN"}},
      {exceptionTotal, new Object[]{-25.00f, ShippingMethod.NextDay, "IN"}},
      {exceptionTotal, new Object[]{-75.00f, ShippingMethod.Standard, "IN"}},
      {exceptionTotal, new Object[]{-75.00f, ShippingMethod.NextDay, "IN"}},
      {exceptionState, new Object[]{25.00f, ShippingMethod.Standard, "PR"}},
      {exceptionState, new Object[]{25.00f, ShippingMethod.NextDay, "PR"}},
      {exceptionState, new Object[]{75.00f, ShippingMethod.Standard, "PR"}},
      {exceptionState, new Object[]{75.00f, ShippingMethod.NextDay, "PR"}},
      {exceptionState, new Object[]{25.00f, ShippingMethod.Standard, "GU"}},
      {exceptionState, new Object[]{25.00f, ShippingMethod.NextDay, "GU"}},
      {exceptionState, new Object[]{75.00f, ShippingMethod.Standard, "GU"}},
      {exceptionState, new Object[]{75.00f, ShippingMethod.NextDay, "GU"}}
    });
  }

  @Test
  public void calculateTotalStrongRobustnessTest() {
    try {
      calculateTotal(self.itemTotal, self.method, self.state);
      fail(String.format("Orders.calculateTotal Failure Detected:\n"+
              "Expected: %s", exceptionState.getMessage()));
    } catch(IllegalArgumentException e) {
      assertEquals(self.expected.getMessage(), e.getMessage());
    }
  }
}
