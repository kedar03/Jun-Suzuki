package edu.umb.cs680.hw14;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class MileageComparatorTest {

	static LinkedList<Car> cars = new LinkedList<Car>();
	
	@BeforeAll
	public static void initialize() {
		Car c1 = new Car("Audi", "Q7", 2015, 50000, 90000);
		Car c2 = new Car("Jaguar", "FJX", 2012, 35000, 30000);
		Car c3 = new Car("BMW", "M-Series", 2018, 30000, 55000);
		Car c4 = new Car("Mercedes", "S-Class", 2019, 10000, 100000);
		cars.add(c1);
		cars.add(c2);
		cars.add(c3);
		cars.add(c4);
		Collections.sort(cars,(Car arg0, Car arg1) -> arg1.getMileage()-arg0.getMileage());
	}
	
	
	@Test
	void testforcar1() {
		Car c1 = new Car("Audi", "Q7", 2015, 50000, 90000);
		assertEquals(c1, cars.get(0));
	}
	
	@Test
	void testforcar2() {
		Car c2 = new Car("Jaguar", "FJX", 2012, 35000, 30000);
		assertEquals(c2, cars.get(1));
	}
	
	@Test
	void testforcar3() {
		Car c3 = new Car("BMW", "M-Series", 2018, 30000, 55000);
		assertEquals(c3, cars.get(2));
	}
	
	
	@Test
	void testforcar4() {
		Car c4 = new Car("Mercedes", "S-Class", 2019, 10000, 100000);
		assertEquals(c4, cars.get(3));
	}
	
	

}
