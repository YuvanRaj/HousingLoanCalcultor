package com.angular.util;
import com.angular.cfc.EquationReqParam;
import com.angular.cfc.EquationResponse;


/**
 * Class used to solve the Two variable System Equation using X = A-1 B 
 * @author Yuvaraj
 *
 */
public class EquationUtility {

	

	public static EquationResponse getSolution(EquationReqParam equationReqParam) throws Exception {
		
		EquationResponse equationResponse = new EquationResponse();
		int a1=equationReqParam.getA1();
		int b1= equationReqParam.getB1();
		int c1= equationReqParam.getC1();
		int a2= equationReqParam.getA2();
		int b2= equationReqParam.getB2();
		int c2=equationReqParam.getC2();
		
		// Step1 find out the inverse
		int divider = (a1 * b2) - (b1 * a2);

		if (divider == 0) {
			equationResponse.setIndeterminate("indeterminate");
			return equationResponse;
		}

		int xValueNum = (b2 * c1) + ((-1 * b1) * c2);
		int yValueNum = ((-1 * a2) * c1) + (a1 * c2);

		int xValue = xValueNum / divider;
		int yValue = yValueNum / divider;

		Double[] doubleArr = new Double[2];

		doubleArr[0] = Double.valueOf(xValue);
		doubleArr[1] = Double.valueOf(yValue);

		equationResponse.setxValue(doubleArr[0]);
		equationResponse.setyValue(doubleArr[1]);
		
		return equationResponse;

	}

}
