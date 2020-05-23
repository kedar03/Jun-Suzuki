package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MileageComparatorTest {

	static LinkedList<Car> carList = new LinkedList<Car>();
	
	@BeforeAll
	public static void initialize() {
		Car c1 = new Car("Audi", "Q7", 2015, 50000, 90000);
		Car c2 = new Car("Jaguar", "FJX", 2012, 35000, 30000);
		Car c3 = new Car("BMW", "M-Series", 2018, 30000, 55000);
		Car c4 = new Car("Mercedes", "S-Class", 2019, 10000, 100000);
		carList.add(c1);
		carList.add(c2);
		carList.add(c3);
		carList.add(c4);
	}
	
	
	@Test
	void testforcar1() {
		Car c1 = new Car("Audi", "Q7", 2015, 50000, 90000);
		carList.sort(new MileageComparator());
		assertEquals(c1, carList.get(0));
	}
	
	@Test
	void testforcar2() {
		Car c2 = new Car("Jaquar", "FJX", 2012, 35000, 30000);
		carList.sort(new MileageComparator());
		assertEquals(c2, carList.get(1));
	}
	
	
	
	@Test
	void testforcar3() {
		Car c3 = new Car("BMW", "M-Series", 2018, 30000, 55000);
		carList.sort(new MileageComparator());
		assertEquals(c3, carList.get(2));
	}
	
	
	
	@Test
	void testforcar4() {
		Car c4 = new Car("Mercedes", "S-Class", 2019, 10000, 100000);
		carList.sort(new MileageComparator());
		assertEquals(c4, carList.get(3));
	}
	
	

}
