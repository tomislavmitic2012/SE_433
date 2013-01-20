/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package triangle_collinyoung;

/* Triangle
 * For SE 333 Software Testing
 * --------
 * Colin Young Winter Quarter 2013, with minimal java experience
 *
 * Usage
 * -----
 *
 * $ javac Triangle.java
 * $ java Triangle 2 3 4
 *
 */

public class Triangle_CollinYoung {

	public static final int EQUILATERAL = 0;
	public static final int ISOCELES 	= 1;
	public static final int SCALENE 	= 2;

	public static void main(String[] args) {

		int[] sides = new int[1];
		try {
			for (int i = 0; i < args.length; i++) {
				sides[i] = Integer.parseInt(args[i]);
			}
		} catch (NumberFormatException e) {
			error(); return;
		}

		if (sides.length == 3) {

			switch (triangleType(sides[0], sides[1], sides[2])) {
			case EQUILATERAL:
				System.out.println("That's an equilateral triangle.");
				return;
			case ISOCELES:
				System.out.println("Two sides are equal - nice isoceles.");
				return;
			case SCALENE:
				System.out.println("Your sides are all different. Scalene it is.");
				return;
			}
		}

		error();
	}

	public static int triangleType(int leg1, int leg2, int hyp) {
		if (leg1 == leg2 && leg1 == hyp) 				// All sides are equal
			return EQUILATERAL;

		if (leg1 == leg2 || leg1 == hyp || leg2 == hyp)	// Two sides are equal
			return ISOCELES;

		return SCALENE;
	}

	private static void error() {
		System.out.println("That's not a valid triangle.\r\n" +
				   		   "Enter three integers - the length" +
				   		   "of each of the three sides.");
	}

}