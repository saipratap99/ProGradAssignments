package unitsystem.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import unitsystem.InvalidUnitException;
import unitsystem.Unit;
import unitsystem.UnitFactory;

public class LengthTest {
   
	static UnitFactory unitFactory;
	
	static Unit oneCentiMeter;
	static Unit fityCentiMeters;
	static Unit oneHundredCentiMeters;
	static Unit twoHundredCentiMeters;
	static Unit twoThousandCentiMeters;
	static Unit oneMeter;
	
	static Unit milliKilloMeter;
	static Unit oneKilloMeter;
	
	@BeforeClass
	public static void initializeObjects() {
		
		unitFactory = new UnitFactory();
		
		oneCentiMeter =  unitFactory.getUnitInstance(1, "cm");
		fityCentiMeters = unitFactory.getUnitInstance(50, "cm");
		oneHundredCentiMeters = unitFactory.getUnitInstance(100, "cm");
		twoHundredCentiMeters = unitFactory.getUnitInstance(200, "cm");
		twoThousandCentiMeters = unitFactory.getUnitInstance(2000,"cm");
		
		oneMeter = unitFactory.getUnitInstance(1, "m");
		
		milliKilloMeter = unitFactory.getUnitInstance(0.001, "km");
		oneKilloMeter = unitFactory.getUnitInstance(1, "km");
	}
	
	@Test
	public void testOneCmIsEqualsToOneCm() throws InvalidUnitException {
		assertTrue(oneCentiMeter.equals(oneCentiMeter));
	}
	
	@Test
	public void testOneMeterIsEqualsOneHundredCentiMeters() throws InvalidUnitException {
		assertTrue(oneMeter.equals(oneHundredCentiMeters));
	}
	
	@Test
	public void testOneHundredCentiMetersIsEqualsToMilliKilloMeters() throws InvalidUnitException {
		assertTrue(oneHundredCentiMeters.equals(milliKilloMeter));
	}
	
	@Test
	public void testAdditionOfOneMeterAndOneHundredCentiMeters() throws InvalidUnitException {
		Unit expected = unitFactory.getUnitInstance(2, "m");
		Unit actual = oneMeter.add(oneHundredCentiMeters);
		
		assertTrue(expected.equals(actual));
	}
	
	@Test
	public void testSubtractionOfOneMeterAndFiftyCentiMeters() throws InvalidUnitException {
		Unit expected = unitFactory.getUnitInstance(0.5, "m");
		Unit actual = oneMeter.subtract(fityCentiMeters);
		
		assertTrue(expected.equals(actual));
	}
	
	@Test(expected = InvalidUnitException.class)
	public void testInvalidUnitExceptionForLength() throws InvalidUnitException {
		Unit milliKilloMeter = unitFactory.getUnitInstance(0.001, "km");
		Unit oneHundredGrams = unitFactory.getUnitInstance(100, "g");
		
		assertTrue(milliKilloMeter.equals(oneHundredGrams));
	}
}
/*

As an architect, I want to be able to check if 1 cm is equal to 1 cm.
As an architect, I want to be able to check if 1 m is equal to 100 cm, and 100 cm is equal to 0.001 km.
As an architect, I want to be able to know that 1 m + 100 cm = 2 m, or 200 cm + 1 km = 100200 cm.
As an architect, I want to be able to know that 1 m - 50 cm = 0.5 m, 2000 cm – 1 m = 1900 cm.
As an architect I want to be able to check if 1 g is equal to 1 g, and 0.1 kg = 100 g, and to know that 10 g + 1 kg = 1010 g,
 and 1.5 kg - 500 g = 1 kg.
As an architect, I want to be able to check if 0 Celsius is equal to 32 Fahrenheit, and 0 Kelvin is equal to -273 Celsius

*/