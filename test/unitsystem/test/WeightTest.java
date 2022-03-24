package unitsystem.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import unitsystem.InvalidUnitException;
import unitsystem.Unit;
import unitsystem.UnitFactory;

public class WeightTest {
	static UnitFactory unitFactory;
	
	@BeforeClass
	public static void initializeObjects() {
		unitFactory = new UnitFactory();
	}
	
	@Test
	public void testOneDeciKilloGramIsEqualsToOneHundredGrams() throws InvalidUnitException {
		Unit oneDeciKilloGram = unitFactory.getUnitInstance(0.1, "kg"); // 0.1 kg
		Unit oneHundredGrams = unitFactory.getUnitInstance(100, "g"); // 100 g
		
		assertTrue(oneDeciKilloGram.equals(oneHundredGrams));
	}
	
	@Test
	public void testAdditionOfTenGramsAndOneKilloGram() throws InvalidUnitException {
		Unit tenGrams = unitFactory.getUnitInstance(10, "g"); // 10 g
		Unit oneKilloGram = unitFactory.getUnitInstance(1, "kg"); // 1 kg
		
		Unit expected = unitFactory.getUnitInstance(1010, "g"); // 1010 g
		Unit actual = tenGrams.add(oneKilloGram);
		
		assertTrue(expected.equals(actual));
	}
	
	@Test
	public void testSubtractionOfTwoKilloGramsAndFiveHundredGrams() throws InvalidUnitException {
		Unit twoKilloGrams = unitFactory.getUnitInstance(2, "kg");
		Unit fiveHundredGrams = unitFactory.getUnitInstance(500, "g");
		
		Unit expected = unitFactory.getUnitInstance(1.5, "kg");
		Unit actual = twoKilloGrams.subtract(fiveHundredGrams);
		
		assertTrue(expected.equals(actual));
	}
	
	@Test(expected = InvalidUnitException.class)
	public void testInvalidUnitExceptionForWeight() throws InvalidUnitException {
		Unit fityCentiMeters = unitFactory.getUnitInstance(50, "cm");
		Unit tenGrams = unitFactory.getUnitInstance(10, "g"); // 10 g
		
		assertTrue(tenGrams.equals(fityCentiMeters));
	}
	
}
/* 

0.1 kg = 100g
10g + 1 kg = 1010g
1.5kg - 500g = 1kg

*/