

The Program is designed with Three classes:
- **com.vinay.programs.TriangleConstants**
- **com.vinay.programs.Triangles**
- **com.vinay.test.TriangleTest**

# Triangles.java

## main method
- Used To trigger program execution
- New instance of **Triangle** class is created here and the method  `getTriangleTypeBySides(...)` triggered with standard input stream.

## getTriangleTypeBySides(InputStream is)

**Scope:** _Public_
**Return Type:** _String - Informs the user about Triangle type based on input received or a validation error message is shown_

- The program input is read from keyboard input using Scanner class in this method.
- A float[] array to read the tokens from Scanner. It is instantiated to accomodate three elements for three sides of the triangle
- The Scanner instance is defined using try-with-resources feature from Java7 version. This way we need not duplicate catch block related code with exceptions and this will automatically take care of closing the resources.
- If the try-with-resources catches any exception then we will print the error and the Program will exit.
- the float Array is populated using for loop to read first three numbers entered by the user.
- We will validate the Inputs recieved using `validateInputs(...)` method which takes the populated float Array.
- The `validateInputs(...)` returns an enum constant of type `Errors` and is saved in a variable of the same type.
- If the value `Error` enum is  **NO_ERRORS_FOUND** then `getTriangleType(...)` method is called with argument float Array `userInput` else all other `Error` enum values received returned are validation related errors and will be returned back to the user for information and program will exit.
- The `getTriangleType(...)` method will read the float Array elements and determines the type of Triange based on the user input.

## validateInputs(float[] userInputArr)
**Scope:** _Public_
**Return Type:** Errors enum

- Validates the elements from `userInputArr` float Array to see if the elements are non-negative numbers and if it makes a triangle.
- If no validation errors are found then an `Error1 enum of type NO_ERRORS_FOUND is returned

## getTriangleType(float[] triangleSidesArr)
**Scope:** _Public Called from `getTriangleTypeBySides(...)`_
**Return Type:** _String 

We will determine the conditions and return the corresponding enum contant String value back to the Consile/Terminal window informing the user :

**2.1.Equilateral:** If the element at index 0 is equal to element at index 1 AND If the element at index 1 is equal to the element at index 2 then it is of type Equilateral.

**2.2.Isosceles:** If the element at index 0 is equal to element at index 1 OR If the element at index 1 is equal to the element at index 2 OR If the element at index 2 is equal to the element at index 0 then it is of type Isosceles.

**2.3.Scalene:** If the element at index 0 is NOT Equal to element at index 1 AND If the element at index 1 is NOT Equal to the element at index 2 AND If the element at index 2 is NOT Equal to the element at index 0 then it is of type Scalene. This condition need not be checked in the If loop as this could go in the last else block.


#TriangleConstants.java

Constants class

- Constants and enums from this class are used in the main program `Triangles.java` and  JUNIT test cases file `TrianglesTests.java`

Two Enums defined in this class:
- TriangleType
- Error

#TriangleTests.java
- JUnit test cases file containing set of test cases to test the methods from `Triangles.java` main program.


A constant is defined which store the line separator retrieved from System class properties as a String.

