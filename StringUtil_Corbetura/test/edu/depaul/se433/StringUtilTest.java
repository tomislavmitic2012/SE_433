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
 * Unit Test for the StringUtil.pluralize static method.
 *
 * @author Tomislav S. Mitic
 */
@RunWith(value=Parameterized.class)
public class StringUtilTest {

  private StringUtilTest self = this;
  private String expected;
  private String input;

  public StringUtilTest(String expected, String input) {
    self.expected = expected;
    self.input = input;
  }

  @Parameters
  public static Collection data() {
    return Arrays.asList(new String[][]{
      {"apes", "ape"},
      {"cats", "cats"},
      {"from", "from"},
      {"good", "good"},
      {"literally", "literally"},
      {"me", "me"},
      {"and", "and"},
      {"Tom", "Tom"},
      {"Mitic", "Mitic"},
      {"equipment", "equipment"},
      {"children", "child"},
      {"bays", "bay"},
      {"abbies", "abby"},
      {null, null}
    });
  }

  @Test
  public void pluralizeTest() {
    assertEquals(self.expected, pluralize(self.input));
  }
}