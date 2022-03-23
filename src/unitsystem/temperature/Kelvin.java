package unitsystem.temperature;

import unitsystem.InvalidUnitException;
import unitsystem.Unit;

public class Kelvin extends Unit{

	public Kelvin(double value) {
		super(value);
	}

	@Override
	public double convert(Unit anotherUnit) throws InvalidUnitException {
		if (anotherUnit instanceof Celcius)
			return anotherUnit.getValue() + 273.15;
		else if (anotherUnit instanceof Kelvin)
			return anotherUnit.getValue();
		else if (anotherUnit instanceof Fahrenheit)
			return (anotherUnit.getValue() - 32) * (5.0/ 9.0) + 273.15;
		else
			throw new InvalidUnitException("Invalid unit for temperature");
	}

	@Override
	public Unit add(Unit anotherUnit) throws InvalidUnitException {
		return new Kelvin(this.getValue() + convert(anotherUnit));
	}

	@Override
	public Unit subtract(Unit anotherUnit) throws InvalidUnitException {
		return new Kelvin(this.getValue() + convert(anotherUnit));
	}

}