package triangle;

/**
 * Class determines if three integers can be the sides of a triangle. Based on
 * the inputs provided the program shall decide whether or not the triangle that
 * is formed is isosceles, scalene, or equilateral.
 *
 * @author Tomislav S. Mitic
 * @since 01/12/2012
 */
public class Triangle {

  /**
   * Integer array holding the three sides of a potential triangle.
   */
  private Integer[] sides = new Integer[3];

  /**
   * Constructor takes in an string array of length three representing the
   * length of the three sides of a triangle.
   *
   * @param triSides an string array of length three representing the sides of a
   * triangle.
   */
  public Triangle(String[] triSides) throws IllegalArgumentException,
          NumberFormatException {
    if (triSides.length != 3) {
      throw new IllegalArgumentException("Array passed in must"
              + " be of length 3.");
    }

    // Parse the ints
    sides[0] = Integer.parseInt(triSides[0], 10);
    sides[1] = Integer.parseInt(triSides[1], 10);
    sides[2] = Integer.parseInt(triSides[2], 10);

    if (sides[0] <= 0 || sides[1] <= 0 || sides[2] <= 0) {
      throw new IllegalArgumentException(String.format(
              "Sides: %s + %s + %s -- each must be greater than zero.",
              sides[0], sides[1], sides[2]));
    }

    if ((sides[0] >= sides[1] + sides[2]) || (sides[1] >= sides[0] + sides[2])
            || (sides[2] >= sides[0] + sides[1])) {
      throw new IllegalArgumentException(String.format(
              "Sides: %s + %s + %s -- is not a triangle.",
              sides[0], sides[1], sides[2]));
    }
  }

  public String classify() {
    if ((sides[0] == sides[1]) && (sides[1] == sides[2])) {
      return "equilateral";
    } else if ((sides[0] != sides[1]) && (sides[0] != sides[2]) &&
            (sides[1] != sides[2])) {
      return "scalene";
    }
    return "isosceles";
  }
}
