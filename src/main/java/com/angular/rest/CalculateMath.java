package com.angular.rest;

import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.Function;
import org.mariuszgromada.math.mxparser.mXparser;

public class CalculateMath {

	public static void main(String[] args) {
		Function ft = new Function("ft(x) = 9*x^2-9");
		Expression e1 = new Expression("ft(5)", ft);
		mXparser.consolePrintln(e1.getExpressionString() + " " + e1.calculate());
	}

}
