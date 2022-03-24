package unitsystem.weight;

import unitsystem.Unit;
import unitsystem.exceptions.InvalidUnitException;

public class Weight extends Unit{
	public Weight(double value, String unitType) {
		super(value, unitType);
	}

	@Override
	public double convert(Unit anotherUnit) throws InvalidUnitException {
		// Base -> Gram
		
		if(anotherUnit instanceof Weight) {
			if (anotherUnit.getUnitType().equalsIgnoreCase("g"))
				return anotherUnit.getValue();
			else if (anotherUnit.getUnitType().equalsIgnoreCase("kg"))
				return anotherUnit.getValue() * 1000;
		}
		
		throw new InvalidUnitException("Invalid unit for weight");
	}

	@Override
	public Unit add(Unit anotherUnit) throws InvalidUnitException {
		double result = convert(anotherUnit) + convert(this);
			
		return new Weight(convertToSpecificUnitFromBase(result, this.getUnitType()), this.getUnitType());
	}

	@Override
	public Unit subtract(Unit anotherUnit) throws InvalidUnitException {
		double result = convert(this) - convert(anotherUnit);
		return new Weight(convertToSpecificUnitFromBase(result, this.getUnitType()), this.getUnitType());
	}	
	
	public double convertToSpecificUnitFromBase(double value, String unitType) {
		if (this.getUnitType().equalsIgnoreCase("kg"))
			return value / 1000;
		return value;
	}
}
