package unitsystem.weight;

import unitsystem.InvalidUnitException;
import unitsystem.Unit;

public class Gram extends Unit{

	public Gram(double value) {
		super(value);
	}

	@Override
	public double convert(Unit anotherUnit) throws InvalidUnitException {
		
		if (anotherUnit instanceof Gram)
			return anotherUnit.getValue();
		else if (anotherUnit instanceof KilloGram)
			return anotherUnit.getValue() * 1000;
		else
			throw new InvalidUnitException("Invalid unit for weight");
	}

	@Override
	public Unit add(Unit anotherUnit) throws InvalidUnitException {		
		return new Gram(this.getValue() + convert(anotherUnit));
	}

	@Override
	public Unit subtract(Unit anotherUnit) throws InvalidUnitException {
		return new Gram(this.getValue() - convert(anotherUnit));
	}

}
