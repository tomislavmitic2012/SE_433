package lengthconverter;

/**
 * A class which converts kilometers to miles and vice versa.
 *
 * @author Tomislav S. Mitic
 */
public class LengthConverter {
  public static final Double KM_IN_MILES = 0.621371192;

  /**
   * Converts kilometers to miles.
   *
   * @param km
   * @return input converted into miles
   */
  public static Double kmToMile(Double km) throws IllegalArgumentException {
    if (km < 0.0) {
      throw new IllegalArgumentException(
              String.format("Value: %s; is negative.", km.toString()));
    }
    return (km * KM_IN_MILES);
  }

  /**
   * Converts miles to kilometers.
   *
   * @param mile
   * @return input converted into kilometers
   */
  public static Double mileToKm(Double miles) throws IllegalArgumentException {
    if (miles < 0.0) {
      throw new IllegalArgumentException(
              String.format("Value: %s; is negative.", miles.toString()));
    }
    return (miles / KM_IN_MILES);
  }
}