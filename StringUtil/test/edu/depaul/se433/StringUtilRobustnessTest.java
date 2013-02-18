/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.se433;

import static edu.depaul.se433.StringUtil.pluralize;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Robustness tests for the StringUtil.pluralize method.
 *
 * @author Tomislav S. Mitic
 */
@RunWith(value=Parameterized.class)
public class StringUtilRobustnessTest {

  private StringUtilRobustnessTest self = this;
  private IllegalArgumentException expected;
  private String input;

  public StringUtilRobustnessTest(IllegalArgumentException expected,
          String input) {
    self.expected = (IllegalArgumentException) expected;
    self.input = (String) input;
  }

  @Parameters
  public static Collection data() {
    return Arrays.asList(new Object[][]{
      {new IllegalArgumentException(), "O'Malley"},
      {new IllegalArgumentException(), "can't"},
      {new IllegalArgumentException(), "[ape]"},
      {new IllegalArgumentException(), "{wolly}"},
      {new IllegalArgumentException(), "great!"},
    });
  }

  @Test
  public void pluralizeStringRobustnessTest() {
    try {
      assertEquals(self.input, pluralize(self.input));
      fail("IllegalArgumentException should have been thrown.");
    } catch (IllegalArgumentException e) {
      assertEquals(expected.getMessage(), e.getMessage());
    }
  }
}