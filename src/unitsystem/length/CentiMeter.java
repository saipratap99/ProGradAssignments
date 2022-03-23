package unitsystem.length;

import unitsystem.InvalidUnitException;
import unitsystem.Unit;

public class CentiMeter extends Unit {
	
	public CentiMeter(double value) {
		super(value);
	}


	@Override
	public double convert(Unit anotherUnit) throws InvalidUnitException {
		if (anotherUnit instanceof CentiMeter)
			return anotherUnit.getValue();
		else if (anotherUnit instanceof Meter)
			return anotherUnit.getValue()*100;
		else if (anotherUnit instanceof KilloMeter)
			return anotherUnit.getValue() * 100000;
		else
			throw new InvalidUnitException("Invalid unit for length");
	}

	@Override
	public Unit add(Unit anotherUnit) throws InvalidUnitException {
		return new CentiMeter(this.getValue() + convert(anotherUnit));
	}

	@Override
	public Unit subtract(Unit anotherUnit) throws InvalidUnitException {
		return new CentiMeter(this.getValue() - convert(anotherUnit));
	}
	

}
