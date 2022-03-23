package unitsystem.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import unitsystem.InvalidUnitException;
import unitsystem.Unit;
import unitsystem.UnitFactory;

public class TemperatureTest {
	static UnitFactory unitFactory;

	@BeforeClass
	public static void initializeObjects() {
		unitFactory = new UnitFactory();
	}
	
	@Test
	public void testZeroCelciusIsEqualsToThirtyTwoFahrenheit() throws InvalidUnitException {
		Unit zeroCelcius = unitFactory.getUnitInstance(0, "C");
		Unit thirtyTwoFahrenheit = unitFactory.getUnitInstance(32, "F");
		
		assertTrue(zeroCelcius.equals(thirtyTwoFahrenheit));
	}
	
	@Test
	public void testZeroKelvinIsEqualsToTwoSeventyThreeCelcius() throws InvalidUnitException {
		Unit zeroKelvin = unitFactory.getUnitInstance(0, "K");
		Unit twoSeventyThreeCelcius = unitFactory.getUnitInstance(-273.15, "C");
		
		assertTrue(zeroKelvin.equals(twoSeventyThreeCelcius));
	}
	
	@Test(expected = InvalidUnitException.class)
	public void testInvalidUnitExceptionForTemperature() throws InvalidUnitException {
		Unit zeroKelvin = unitFactory.getUnitInstance(0, "K");
		Unit fiveHundredGrams = unitFactory.getUnitInstance(500, "g");
		
		assertTrue(zeroKelvin.equals(fiveHundredGrams));
	}
	
	@Test(expected = NullPointerException.class)
	public void testNullPointerExceptionForTemperature() throws InvalidUnitException, NullPointerException {
		Unit zeroKelvin = unitFactory.getUnitInstance(0, "Q");
		Unit fiveHundredGrams = unitFactory.getUnitInstance(500, "g");
		
		assertTrue(zeroKelvin.equals(fiveHundredGrams));
	}
}

/*
0C = 32F
0K = -273C

*/