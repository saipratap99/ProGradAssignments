package unitsystem.temperature;

import unitsystem.InvalidUnitException;
import unitsystem.Unit;

public class Fahrenheit extends Unit{

	public Fahrenheit(double value) {
		super(value);
	}

	@Override
	public double convert(Unit anotherUnit) throws InvalidUnitException {
		if (anotherUnit instanceof Celcius)
			return anotherUnit.getValue() * (9.0/5.0) + 32;
		else if (anotherUnit instanceof Kelvin)
			return (anotherUnit.getValue() - 273.15) * (9.0 / 5.0) + 32;
		else if (anotherUnit instanceof Fahrenheit)
			return anotherUnit.getValue();
		else
			throw new InvalidUnitException("Invalid unit for temperature");
	}

	@Override
	public Unit add(Unit anotherUnit) throws InvalidUnitException {
		return new Fahrenheit(this.getValue() + convert(anotherUnit));
	}

	@Override
	public Unit subtract(Unit anotherUnit) throws InvalidUnitException {
		return new Fahrenheit(this.getValue() + convert(anotherUnit));
	}

}
