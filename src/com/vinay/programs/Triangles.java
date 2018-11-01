package com.vinay.programs;

import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Program Challenge Description: 
 * Write a program that will determine the type of a triangle. 
 *	It should take the lengths of the triangle's three sides as input, and return whether the triangle is equilateral, isosceles or scalene. 
 *	We are looking for solutions that showcase problem solving skills and structural considerations that can be applied to larger and potentially more complex problem domains. Pay special attention to tests, readability of code and error cases.
 *  The way you reflect upon your decisions is important to us, why we ask you to include a brief discussion of your design decisions and implementation choices.
 * 	The resulting code and discussion is vital for us and will be used as a way for us to validate your engineering skills. After having reviewed your code, we’ll decide on next step.
 *	Please put the solution up on GitHub and send the link to me. If you have some other code that you are proud of then please send that too.

 * @author mandala
 *
 */


 
/**
 *  Triangle Class
 *
 */
public class Triangles {
	
	/**
	 * main method
	 */
	public static void main(String[] args) {
		
		Triangles trianglesTest = new Triangles();
		System.out.println(" Enter the Sides of Triangle ");
		System.out.println("TRIANGLE TYPE: "+trianglesTest.getTriangleTypeBySides(System.in));
	}
	
	
	/**
	 * Method to retrieve and return Triangle Type for the given Sides.
	 */
	public String getTriangleTypeBySides(InputStream is){
		float[] userInput = new float[3];

		try(Scanner sc = new Scanner(is)) {
			//populate user Input Array
			for(int i=0; i < 3 && sc.hasNext() ; i++){
				userInput[i] = sc.nextFloat();
			}
			
			// validate the input received
			TriangleConstants.Errors errors = validateInputs(userInput);
			
			if(errors == TriangleConstants.Errors.NO_ERRORS_FOUND){
				// Find the Triangle Type
				return getTriangleType(userInput);
			} else {
				//return the error from ValidateInputs
				return errors.getErrorValue();
			}

		} catch(NoSuchElementException e){
			//If exception occurs then it could be a case that the input entered by the User is not a number. Print the message and program will exit.
			return TriangleConstants.Errors.NOT_A_NUMBER.getErrorValue();
		}
		
	}
	
	
	/**
	 * Method to validate the sides
	 * @param Sorted float Array
	 * @return enum Errors
	 */
	public TriangleConstants.Errors validateInputs(float[] userInputArr){
		
		
		//Calculate Triangles for only positive numbers
		if(userInputArr[0] <= 0 || userInputArr[1] <= 0 || userInputArr[2] <= 0){
			return TriangleConstants.Errors.NOT_A_POSITIVE_NUMBER;
		}
		
		//Sum of two lower sides must be less than side with longer length.
		if(userInputArr[0] + userInputArr[1] < userInputArr[2]){
			return TriangleConstants.Errors.NOT_A_TRIANGLE;
		}
		
		return TriangleConstants.Errors.NO_ERRORS_FOUND;
	}
	
	/**
	 * Method to determine the Triangle Type
	 * @param sorted float Array
	 * @return String - Triangle Type Name or Validation Error String is returned
	 */
	public String getTriangleType(float[] triangleSidesArr){
		String triangleType = null;
		
		 if(triangleSidesArr[0] == triangleSidesArr[1] && triangleSidesArr[1] == triangleSidesArr[2]){
			 triangleType =  TriangleConstants.TriangleType.EQUILATERAL.toString();
		 } else if (triangleSidesArr[0] == triangleSidesArr[1] || triangleSidesArr[1] == triangleSidesArr[2] || triangleSidesArr[2] == triangleSidesArr[0]) { // a != b and b !=c and c != a
			 triangleType =  TriangleConstants.TriangleType.ISOSCELES.toString();
		 } else {
			 triangleType =  TriangleConstants.TriangleType.SCALENE.toString();
		 } 
				 
		
		return triangleType;
	}	
}
