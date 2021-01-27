import java.util.Arrays;


/**
 * Class used to solve the Two variable System Equation using X = A-1 B 
 * @author Yuvaraj
 *
 */
public class EquationUtility {

	

	public static double[] getSolution(int a1, int b1, int c1, int a2, int b2, int c2) throws Exception {
		// Step1 find out the inverse
		int divider = (a1 * b2) - (b1 * a2);

		if (divider == 0) {
			throw new Exception("Invalid value present");
		}

		int xValueNum = (b2 * c1) + ((-1 * b1) * c2);
		int yValueNum = ((-1 * a2) * c1) + (a1 * c2);

		int xValue = xValueNum / divider;
		int yValue = yValueNum / divider;

		double[] doubleArr = new double[2];

		doubleArr[0] = Double.valueOf(xValue);
		doubleArr[1] = Double.valueOf(yValue);

		return doubleArr;

	}

}
