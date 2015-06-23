package driver;

import java.util.logging.Level;
import java.util.logging.Logger;
import triangle.Triangle;

/**
 * A driver program which takes three inputs from the command line and
 * calculates whether they form a triangle what is either isosceles, scalene,
 * or equilateral.
 *
 * @author Tomislav S. Mitic
 * @since 01/12/2013
 */
public class Driver {
  private static final Logger log = Logger.getLogger("Triangle");

  public static void main(String[] args) {
    try {
      Triangle tri = new Triangle(args);
      System.out.println(String.format("The triangle is: %s", tri.classify()));
    } catch(Exception e) {
      log.log(Level.INFO, String.format(
              "An exception has occurred: %s", e.toString()));
    }
  }
}
