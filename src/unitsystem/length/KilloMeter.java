package unitsystem.length;

import unitsystem.InvalidUnitException;
import unitsystem.Unit;

public class KilloMeter extends Unit {
	
	public KilloMeter(double value) {
		super(value);
	}

	@Override
	public double convert(Unit anotherUnit) throws InvalidUnitException {
		
		if (anotherUnit instanceof CentiMeter)
			return anotherUnit.getValue() / 100000;
		else if (anotherUnit instanceof Meter)
			return anotherUnit.getValue() / 1000;
		else if (anotherUnit instanceof KilloMeter)
			return anotherUnit.getValue();	
		else
			throw new InvalidUnitException("Invalid unit for length");
	}

	@Override
	public Unit add(Unit anotherUnit) throws InvalidUnitException {		
		return new KilloMeter(this.getValue() + convert(anotherUnit));
	}

	@Override
	public Unit subtract(Unit anotherUnit) throws InvalidUnitException {
		return new KilloMeter(this.getValue() - convert(anotherUnit));
	}
	
}
