package unitsystem.length;

import unitsystem.InvalidUnitException;
import unitsystem.Unit;

public class Length extends Unit {

	public Length(double value, String unitType) {
		super(value, unitType);
	}

	@Override
	public double convert(Unit anotherUnit) throws InvalidUnitException {
		// Base -> cm
		
		if(anotherUnit instanceof Length) {
			if (anotherUnit.getUnitType().equalsIgnoreCase("cm"))
				return anotherUnit.getValue();
			else if (anotherUnit.getUnitType().equalsIgnoreCase("m"))
				return anotherUnit.getValue() * 100;
			else if (anotherUnit.getUnitType().equalsIgnoreCase("km"))
				return anotherUnit.getValue()*100000;
		}
		
		throw new InvalidUnitException("Invalid unit for length");
	}

	@Override
	public Unit add(Unit anotherUnit) throws InvalidUnitException {
		double result = convert(anotherUnit) + convert(this);
			
		return new Length(convertToSpecificUnitFromBase(result, this.getUnitType()), this.getUnitType());
	}

	@Override
	public Unit subtract(Unit anotherUnit) throws InvalidUnitException {
		double result = convert(this) - convert(anotherUnit);
		return new Length(convertToSpecificUnitFromBase(result, this.getUnitType()), this.getUnitType());
	}	
	
	public double convertToSpecificUnitFromBase(double value, String unitType) {
		if (this.getUnitType().equalsIgnoreCase("m"))
			return value /= 100;
		else if (this.getUnitType().equalsIgnoreCase("km"))
			return value /= 100000;
		return value;
	}
}
