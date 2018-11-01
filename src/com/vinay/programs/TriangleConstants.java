package com.vinay.programs;

public final class TriangleConstants {
	
	public static final String lineSeparator = System.getProperty("line.separator");
	 /**
	  * ENUM for defining Error Constants
	  */
	public enum Errors {
		   NOT_A_TRIANGLE("The Sides provided does NOT make up a Triangle!"), 
		   NOT_A_POSITIVE_NUMBER("Could not determine Triangle Type. Please enter only Positive Numbers"), 
		   NOT_A_NUMBER("Could not determine Triangle Type. Invalid input provided. Program will exit."), 
		   NO_ERRORS_FOUND("No Errors Found. Continue");
		   
		   private String errorValue;
		   
		   Errors(String value) {
		      errorValue = value;
		   }
		   
		   public String getErrorValue() {
		      return errorValue;
		   } 
		}

	 /**
	  * ENUM for defining Triangle Type Constants
	  *
	  */
	public enum TriangleType {EQUILATERAL, ISOSCELES, SCALENE};
}
