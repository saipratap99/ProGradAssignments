package unitsystem.weight;

import unitsystem.InvalidUnitException;
import unitsystem.Unit;

public class KilloGram extends Unit{

	public KilloGram(double value) {
		super(value);
	}

	@Override
	public double convert(Unit anotherUnit) throws InvalidUnitException {
		
		if (anotherUnit instanceof Gram)
			return anotherUnit.getValue() / 1000;
		else if (anotherUnit instanceof KilloGram)
			return anotherUnit.getValue();
		else
			throw new InvalidUnitException("Invalid unit for weight");
	}

	@Override
	public Unit add(Unit anotherUnit) throws InvalidUnitException {		
		return new KilloGram(this.getValue() + convert(anotherUnit));
	}

	@Override
	public Unit subtract(Unit anotherUnit) throws InvalidUnitException {
		return new KilloGram(this.getValue() - convert(anotherUnit));
	}

}
