package driver;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static lengthconverter.LengthConverter.*;

/**
 * A driver program to test the LengthConverter class.
 *
 * @author Tomislav S. Mitic
 */
public class Driver {

  private static final Logger log = Logger.getLogger(Driver.class.getName());
  private static Scanner in = new Scanner(System.in);

  private static Double parseInput(String input) throws NumberFormatException {
    return Double.parseDouble(input);
  }

  public static void main(String[] args) {
    log.setLevel(Level.INFO);

    String cont = "y";
    Double input;

    if (args.length == 2) {
      try {
        input = parseInput(args[0]);
        System.out.println(String.format("Kilometers input: %s; "
          + "Converted to miles: %s\n\n", args[0],
          kmToMile(input).toString()));
        input = parseInput(args[1]);
        System.out.println(String.format("Miles input: %s; "
          + "Converted to Kilometers: %s\n\n", args[1],
          mileToKm(input).toString()));
      } catch(NumberFormatException e) {
        log.log(Level.WARNING, "NumberFormatException encountered ---- {0} ",
          e.toString());
      } catch(IllegalArgumentException e) {
        log.log(Level.WARNING, "Illegal argument encountered ---- {0} ",
          e.toString());
      }
    } else {
      while (cont.equals("y") || cont.equals("Y")) {
        try {
          System.out.println("Enter kilometers to convert to miles: ");
          input = parseInput(in.nextLine());
          System.out.println(String.format("Kilometers input: %s; "
            + "Converted to miles: %s\n\n", input.toString(),
            kmToMile(input).toString()));
          System.out.println("Enter miles to convert to kilometers: ");
          input = parseInput(in.nextLine());
          System.out.println(String.format("Miles input: %s; "
            + "Converted to Kilometers: %s\n\n", input.toString(),
            mileToKm(input).toString()));
        } catch(NumberFormatException e) {
          log.log(Level.WARNING, "NumberFormatException encountered ---- {0} ",
            e.toString());
        } catch(IllegalArgumentException e) {
          log.log(Level.WARNING, "Illegal argument encountered ---- {0} ",
            e.toString());
        }
        System.out.println("\n\nContinue (y/n): ");
        cont = in.nextLine();
      }
    }
  }
}