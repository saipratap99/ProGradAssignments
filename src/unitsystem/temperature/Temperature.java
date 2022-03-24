package unitsystem.temperature;

import unitsystem.Unit;
import unitsystem.exceptions.InvalidUnitException;

public class Temperature extends Unit {
	public Temperature(double value, String unitType) {
		super(value, unitType);
	}

	@Override
	public double convert(Unit anotherUnit) throws InvalidUnitException {
		// Base -> Celcius
		
		if(anotherUnit instanceof Temperature) {
			if (anotherUnit.getUnitType().equalsIgnoreCase("C"))
				return anotherUnit.getValue();
			else if (anotherUnit.getUnitType().equalsIgnoreCase("F"))
				return (anotherUnit.getValue() - 32) * (5.0 / 9.0);
			else if (anotherUnit.getUnitType().equalsIgnoreCase("K"))
				return anotherUnit.getValue() - 273.15;
		}
		
		throw new InvalidUnitException("Invalid unit for temperature");
	}

	@Override
	public Unit add(Unit anotherUnit) throws InvalidUnitException {
		double result = convert(anotherUnit) + convert(this);
			
		return new Temperature(convertToSpecificUnitFromBase(result, this.getUnitType()), this.getUnitType());
	}

	@Override
	public Unit subtract(Unit anotherUnit) throws InvalidUnitException {
		double result = convert(this) - convert(anotherUnit);
		return new Temperature(convertToSpecificUnitFromBase(result, this.getUnitType()), this.getUnitType());
	}	
	
	public double convertToSpecificUnitFromBase(double value, String unitType) {
		if (this.getUnitType().equalsIgnoreCase("F"))
			return value * (9.0/5.0) + 32;
		else if (this.getUnitType().equalsIgnoreCase("K"))
			return value + 273.15;
		return value;
	}
}
