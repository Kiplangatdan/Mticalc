package com.app.mticalc.helper;

import java.text.DecimalFormat;

public class FormulaHelper {
	
	private static final double PI = 3.142;
	private static final double div=40000;
	private static double result1;
	private static double result2;
	private static double[] results = new double[2];

	public static class InvalidInputException extends Exception {
		private static final long serialVersionUID = 1L;
	}
	
	public static double plus(double a, double b) {
		return a + b;
	}
	
	public static double minus(double a, double b) {
		return a - b;
	}
	
	public static double multiply(double a, double b) {
		return a * b;
	}
	
	public static double divide(double a, double b) {
		return a / b;
	}
	
		
	public static double avg_area(double dbh1, double height1, double dbh2, double height2) throws InvalidInputException {
		if (dbh1 >= 0 && height1 >= 0) {
			double avg_dbh=(dbh1+dbh2)/2;
			//double avg_height=(height1+height2);
			result1 = ( PI * avg_dbh*avg_dbh)/div;
			return result1;
		} else {
			throw new InvalidInputException();
		}
	}
	
	public static double avg_volume(double dbh1, double height1, double dbh2, double height2) throws InvalidInputException {
		if (dbh2 >= 0 && height2 >= 0) {
			double avg_dbh=(dbh1+dbh2)/2;
			double avg_height=(height1+height2)/2;
			result2 = result1 *avg_height;
			return result2;
		} else {
			throw new InvalidInputException();
		}
	}
	
	
	
	public static String formatResult(double result1, double result2) {
		DecimalFormat fourDForm = new DecimalFormat("#0.0000");
    	String resultFormated = fourDForm.format(result1);
    	return resultFormated;
	}
}
