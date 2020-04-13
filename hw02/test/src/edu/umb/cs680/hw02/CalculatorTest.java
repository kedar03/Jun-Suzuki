package edu.umb.cs680.hw02;


import static org.junit.jupiter.api. Assertions.*;
import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw02.Calculator;

public class CalculatorTest{

	@Test
	public void multiply3By4(){
		Calculator cut = new Calculator();
		float actual = cut.multiply(3,4);
		float expected = 12;
		assertEquals(expected, actual);
	}

	@Test
	public void multiply5By0(){
		Calculator cut = new Calculator();
		float actual = cut.multiply(5,0);
		float expected = 0;
		assertEquals(expected, actual);
	}

	@Test
	public void multiply0By0(){
		Calculator cut = new Calculator();
		float actual = cut.multiply(0,0);
		float expected = 0;
		assertEquals(expected, actual);
	}

	@Test
	public void multiplyMINByMAX(){
		Calculator cut = new Calculator();
		float actual = cut.multiply(Float.MIN_VALUE,Float.MAX_VALUE);
		float expected = Float.MIN_VALUE * Float.MAX_VALUE;
		assertEquals(expected, actual);
	}



	@Test
	public void multiply10point8By21point5(){
		Calculator cut = new Calculator();
		float actual = cut.multiply(10.8f,21.5f);
		float expected = 232.2f;
		assertEquals(expected, actual);
	}

	@Test
	public void multiply3By4String(){
		Calculator cut = new Calculator();
		try {
			float actual = cut.multiply('3','4');
			float expected = 12;
			assertEquals(expected, actual);
			fail("Multiplication not applied on Strings");
		}
		catch(IllegalArgumentException ex) {
			ex.getMessage();
		}

	}

	// Divide test cases
	@Test
	public void divide3By2(){
		Calculator cut = new Calculator();
		float actual = cut.divide(3,2);
		float expected = 1.5f;
		assertEquals(expected, actual);
	}



	@Test
	public void divide2By5(){
		Calculator cut = new Calculator();
		float actual = cut.divide(2,5);
		float expected = 0.4f;
		assertEquals(expected, actual);
	}

	@Test
	public void divide0By5(){
		Calculator cut = new Calculator();
		float actual = cut.divide(0,5);
		float expected = 0f;
		assertEquals(expected, actual);
	}

	@Test
	public void divide10By5(){
		Calculator cut = new Calculator();
		float actual = cut.divide(10,5);
		float expected = 2;
		assertEquals(expected, actual);
	}

	@Test
	public void divideMINByMAX() {
		Calculator cut = new Calculator();
		float actual = cut.divide(Float.MIN_VALUE, Float.MAX_VALUE);
		float expected = Float.MIN_VALUE / Float.MAX_VALUE;
		assertEquals(expected, actual);
	}

	@Test
	public void divideMAXByMIN() {
		Calculator cut = new Calculator();
		float actual = cut.divide(Float.MAX_VALUE, Float.MIN_VALUE);
		float expected = Float.MAX_VALUE / Float.MIN_VALUE;
		assertEquals(expected, actual);
	}



	@Test
	public void divide7point5By3point3(){
		Calculator cut = new Calculator();
		float actual = cut.divide(7.5f,3.3f);
		float expected = 2.2727f;
		assertEquals(expected, actual);
	}

	@Test
	public void divide5By0(){
		Calculator cut = new Calculator();
		try{
			cut.divide(5, 0);
			fail("Division by zero");
		} catch(IllegalArgumentException ex){
			assertEquals("division by zero", ex.getMessage() );
		}
	}

	@Test
	public void divide0By0(){
		Calculator cut = new Calculator();
		try{
			cut.divide(0, 0);
			fail("Division by zero");
		} catch(IllegalArgumentException ex){
			assertEquals("division by zero", ex.getMessage() );
		}
	}

}
