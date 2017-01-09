package com.wuxy13.prime.unitTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.wuxy13.prime.utils.PrimeGenerator;

public class TestFunction {
	PrimeGenerator primeGenerator;

	@Before
	public void setUp() throws Exception {
		primeGenerator=new PrimeGenerator();
	}

	@Test
	public void testGeneratePrimes() {
		primeGenerator.generatePrimes(5);
		int[] expectedResult=new int[]{2,3,5};
		assertArrayEquals(expectedResult, primeGenerator.getResult());
		
		primeGenerator.generatePrimes(1);
		assertArrayEquals(null, primeGenerator.getResult());
		
		primeGenerator.generatePrimes(2);
		expectedResult=new int[]{2};
		assertArrayEquals(expectedResult, primeGenerator.getResult());
		
		primeGenerator.generatePrimes(100);
		assertEquals(97, primeGenerator.getResult()[24]);
	}

	@Test
	public void testUncrossIntergerUpTo() {
		primeGenerator.uncrossIntergerUpTo(2);
		assertEquals(3, primeGenerator.getCrossedOut().length);
	}

	@Test
	public void testCrossOutMultiples() {
		primeGenerator.uncrossIntergerUpTo(5);
		primeGenerator.crossOutMultiples();
		assertEquals(true, primeGenerator.getCrossedOut()[0]);
		assertEquals(true, primeGenerator.getCrossedOut()[1]);
		assertEquals(false, primeGenerator.getCrossedOut()[2]);
		assertEquals(false, primeGenerator.getCrossedOut()[3]);
		assertEquals(true, primeGenerator.getCrossedOut()[4]);
		assertEquals(false, primeGenerator.getCrossedOut()[5]);
	}

	@Test
	public void testDetermineIteratorLimit() {
		primeGenerator.uncrossIntergerUpTo(3);
		assertEquals(3, primeGenerator.determineIteratorLimit());
		primeGenerator.uncrossIntergerUpTo(4);
		assertEquals(3, primeGenerator.determineIteratorLimit());
	}

	@Test
	public void testNotCrossed() {
		primeGenerator.uncrossIntergerUpTo(5);
		primeGenerator.crossOutMultiples();
		assertEquals(false, primeGenerator.notCrossed(0));
		assertEquals(false, primeGenerator.notCrossed(1));
		assertEquals(true, primeGenerator.notCrossed(2));
		assertEquals(true, primeGenerator.notCrossed(3));
		assertEquals(false, primeGenerator.notCrossed(4));
		assertEquals(true, primeGenerator.notCrossed(5));
	}

	@Test
	public void testPutUncrossedIntergerIntoResult() {
		primeGenerator.uncrossIntergerUpTo(5);
		primeGenerator.crossOutMultiples();
		primeGenerator.putUncrossedIntergerIntoResult();
		assertEquals(3, primeGenerator.getResult().length);
	}

	@Test
	public void testNumberOfUncrossedIntergers() {
		primeGenerator.uncrossIntergerUpTo(5);
		primeGenerator.crossOutMultiples();
		assertEquals(3, primeGenerator.NumberOfUncrossedIntergers());
	}

}
