package unitsystem;

import unitsystem.exceptions.InvalidUnitException;

public abstract class Unit {
	
	double value;
	String unitType;
	
	public Unit(double value, String unitType) {
		this.value = value;
		this.unitType = unitType;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	
	public String getUnitType() {
		return unitType;
	}

	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}

	public abstract double convert(Unit anotherUnit) throws InvalidUnitException;
	
	public abstract Unit add(Unit anotherUnit) throws InvalidUnitException;
	public abstract Unit subtract(Unit anotherUnit) throws InvalidUnitException;
	
	public boolean equals(Unit anotherUnit) throws InvalidUnitException {
		return convert(anotherUnit) == convert(this);
	}
}


/*

As an architect, I want to be able to check if 1 cm is equal to 1 cm.
As an architect, I want to be able to check if 1 m is equal to 100 cm, and 100 cm is equal to 0.001 km.
As an architect, I want to be able to know that 1 m + 100 cm = 2 m, or 200 cm + 1 km = 100200 cm.
As an architect, I want to be able to know that 1 m - 50 cm = 0.5 m, 2000 cm – 1 m = 1900 cm.
As an architect I want to be able to check if 1 g is equal to 1 g, and 0.1 kg = 100 g, and to know that 10 g + 1 kg = 1010 g, and 1.5 kg - 500 g = 1 kg.
As an architect, I want to be able to check if 0 Celsius is equal to 32 Fahrenheit, and 0 Kelvin is equal to -273 Celsius

*/