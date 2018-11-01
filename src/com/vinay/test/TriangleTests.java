package com.vinay.test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;

import com.vinay.programs.TriangleConstants;
import com.vinay.programs.Triangles;

public class TriangleTests {

	Triangles triangle = new Triangles();
	@Test
	public void equilateralTest(){
		String simulatedUserInput = "4" + TriangleConstants.lineSeparator
				+ "4" + TriangleConstants.lineSeparator
			    + "4" + TriangleConstants.lineSeparator;

		InputStream is = new ByteArrayInputStream(simulatedUserInput.getBytes());
       	assertEquals(TriangleConstants.TriangleType.EQUILATERAL.toString(), triangle.getTriangleTypeBySides(is));

	}
	
	@Test
	public void isocelesTest(){
		String simulatedUserInput = "3" + TriangleConstants.lineSeparator
			    + "4" + TriangleConstants.lineSeparator
			    + "4" + TriangleConstants.lineSeparator;

		InputStream is = new ByteArrayInputStream(simulatedUserInput.getBytes());
       	assertEquals(TriangleConstants.TriangleType.ISOSCELES.toString(), triangle.getTriangleTypeBySides(is));

	}
	
	@Test
	public void scaleneTest(){
		String simulatedUserInput = "2" + TriangleConstants.lineSeparator
			    + "3" + TriangleConstants.lineSeparator
			    + "4" + TriangleConstants.lineSeparator;

		InputStream is = new ByteArrayInputStream(simulatedUserInput.getBytes());
       	assertEquals(TriangleConstants.TriangleType.SCALENE.toString(), triangle.getTriangleTypeBySides(is));

	}
	
	@Test
	public void validationTests(){
		//Not a Triangle
		String simulatedUserInput = "2" + TriangleConstants.lineSeparator
			    + "1" + TriangleConstants.lineSeparator
			    + "4" + TriangleConstants.lineSeparator;

		InputStream is1 = new ByteArrayInputStream(simulatedUserInput.getBytes());

       	assertEquals(TriangleConstants.Errors.NOT_A_TRIANGLE.getErrorValue(), triangle.getTriangleTypeBySides(is1));
       	
       	// Not a Positive Number
       	String simulatedUserInputNegativeNumber = "-2" + TriangleConstants.lineSeparator
			    + "1" + TriangleConstants.lineSeparator
			    + "4" + TriangleConstants.lineSeparator;

		InputStream is2 = new ByteArrayInputStream(simulatedUserInputNegativeNumber.getBytes());
       	assertEquals(TriangleConstants.Errors.NOT_A_POSITIVE_NUMBER.getErrorValue(), triangle.getTriangleTypeBySides(is2));

	}
	
	@Test
	public void exceptionErrorsTest(){
       	assertEquals(TriangleConstants.Errors.NOT_A_NUMBER.getErrorValue(), triangle.getTriangleTypeBySides(null));
	}
	
	
	@Test
	public void validateInputsTest(){
		float[] userInput = {2, 3, 4};
       	assertEquals(TriangleConstants.Errors.NO_ERRORS_FOUND,  triangle.validateInputs(userInput));
	}
	
}
