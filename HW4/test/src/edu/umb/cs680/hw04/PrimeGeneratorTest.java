package edu.umb.cs680.hw04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


//import java.util.LinkedList;

public class PrimeGeneratorTest{

	
	@Test
	public void primesFrom1To10(){
		PrimeGenerator primeGen = new PrimeGenerator(1,10);
		primeGen.generatePrimes();
		Long[] expected = {2L, 3L, 5L, 7L};
		assertArrayEquals(expected, primeGen.getPrimes().toArray());
	}

	@Test 
	public void primesFrom1To100(){
		PrimeGenerator primeGen = new PrimeGenerator(1,100);
		primeGen.generatePrimes();
		Long[] expected = {2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L, 31L, 37L, 41L, 43L, 47L, 53L, 59L, 61L, 67L, 71L, 73L, 79L, 83L, 89L, 97L};
		assertArrayEquals( expected, primeGen.getPrimes().toArray() );
	}

	@Test
	public void primesFrom1To5(){
		PrimeGenerator primeGen = new PrimeGenerator(1,5);
		primeGen.generatePrimes();
		Long[] expected = {2L, 3L, 5L};
		assertArrayEquals(expected, primeGen.getPrimes().toArray());
	}

	

	

	@Test
	public void primesFrom100To1000(){
		PrimeGenerator primeGen = new PrimeGenerator(100,1000);
		primeGen.generatePrimes();
		Long[] expected = {101L, 103L, 107L, 109L, 113L, 127L, 131L, 137L, 139L, 149L, 151L, 157L, 163L, 167L, 173L, 179L, 181L, 191L, 193L, 197L, 199L, 211L, 223L, 227L, 229L, 233L, 239L, 241L, 251L, 257L, 263L, 269L, 271L, 277L, 281L, 283L, 293L, 307L, 311L, 313L, 317L, 331L, 337L, 347L, 349L, 353L, 359L, 367L, 373L, 379L, 383L, 389L, 397L, 401L, 409L, 419L, 421L, 431L, 433L, 439L, 443L, 449L, 457L, 461L, 463L, 467L, 479L, 487L, 491L, 499L, 503L, 509L, 521L, 523L, 541L, 547L, 557L, 563L, 569L, 571L, 577L, 587L, 593L, 599L, 601L, 607L, 613L, 617L, 619L, 631L, 641L, 643L, 647L, 653L, 659L, 661L, 673L, 677L, 683L, 691L, 701L, 709L, 719L, 727L, 733L, 739L, 743L, 751L, 757L, 761L, 769L, 773L, 787L, 797L, 809L, 811L, 821L, 823L, 827L, 829L, 839L, 853L, 857L, 859L, 863L, 877L, 881L, 883L, 887L, 907L, 911L, 919L, 929L, 937L, 941L, 947L, 953L, 967L, 971L, 977L, 983L, 991L, 997L};
		assertArrayEquals(expected, primeGen.getPrimes().toArray());
	}

	@Test
	public void primesFrom1To1(){
		long from = 1;
		long to = 1;
		try{
			PrimeGenerator primeGen = new PrimeGenerator(1,1);
			primeGen.generatePrimes();
			Long[] expected = {};
			assertArrayEquals(expected, primeGen.getPrimes().toArray());
		}
		catch (RuntimeException ex){
			assertEquals("Wrong input values: from="+ from +" to="+to , ex.getMessage() );
		}
	}

	@Test
	public void primesFrom0To1(){
		long from = 0;
		long to = 1;
		try{
			PrimeGenerator primeGen = new PrimeGenerator(0,1);
			primeGen.generatePrimes();
			Long[] expected = {};
			assertArrayEquals(expected, primeGen.getPrimes().toArray());
		}
		catch (RuntimeException ex){
			assertEquals("Wrong input values: from="+ from +" to="+to , ex.getMessage() );
		}

	}

	// Negative Tests
	@Test
	public void primesFromNegative10To10(){
		long from = -10;
		long to = 10;
		try{
			PrimeGenerator primeGen = new PrimeGenerator(-10,10);
			primeGen.generatePrimes();

		}
		catch(RuntimeException ex){
			assertEquals("Wrong input values: from="+ from +" to="+to , ex.getMessage() );
		}
	}

	@Test
	public void primesFrom20000To20300(){
		PrimeGenerator primeGen = new PrimeGenerator(20000,20300);
		primeGen.generatePrimes();
		Long[] expected = {20011L,20021L,20023L,20029L,20047L,20051L,20063L,20071L,20089L,20101L,20107L,20113L,20117L,20123L,20129L,20143L,20147L,20149L,	20161L,	20173L,	20177L,	20183L,	20201L,	20219L,	20231L,	20233L,	20249L,	20261L,20269L,20287L,20297L};
		assertArrayEquals(expected, primeGen.getPrimes().toArray());
	}

	

	@Test
	public void primesFrom100To1(){
		long from = 100;
		long to = 1;
		try{
			PrimeGenerator primeGen = new PrimeGenerator(100,1);
			primeGen.generatePrimes();
			fail("Invalid range");
		}
		catch(RuntimeException ex){
			assertEquals("Wrong input values: from="+ from +" to="+to , ex.getMessage() );

		}
	}

	@Test
	public void primesFrom0ToNegative1(){
		long from = 0;
		long to = -1;
		try{
			PrimeGenerator primeGen = new PrimeGenerator(0,-1);
			primeGen.generatePrimes();

		}
		catch(RuntimeException ex){
			assertEquals("Wrong input values: from="+ from +" to="+to , ex.getMessage() );

		}
	}

	@Test
	public void primesFromNegative5ToNegative1(){
		long from = -5;
		long to = -1;
		try{
			PrimeGenerator primeGen = new PrimeGenerator(-5,-1);
			primeGen.generatePrimes();
		}
		catch(RuntimeException ex){
			assertEquals("Wrong input values: from="+ from +" to="+to , ex.getMessage() );
		}
	}
}
