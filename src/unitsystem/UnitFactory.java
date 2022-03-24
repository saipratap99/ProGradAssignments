package unitsystem;

import unitsystem.length.Length;
import unitsystem.temperature.Temperature;
import unitsystem.weight.Weight;

public class UnitFactory {
	public Unit getUnitInstance(double value, String measurementType) {
		// length 
		if(measurementType.equalsIgnoreCase("cm"))
		 	return new Length(value, "cm");
		 else if(measurementType.equalsIgnoreCase("m"))
			 return new Length(value, "m");
		 else if(measurementType.equalsIgnoreCase("km"))
			 return new Length(value, "km");
		 // weight
		 else if(measurementType.equalsIgnoreCase("g"))
			 return new Weight(value, "g");
		 else if(measurementType.equalsIgnoreCase("kg"))
			 return new Weight(value, "kg");
		// temperature
		 else if(measurementType.equalsIgnoreCase("C"))
			 return new Temperature(value, "C");
		 else if(measurementType.equalsIgnoreCase("F"))
			 return new Temperature(value, "F");
		 else if(measurementType.equalsIgnoreCase("K"))
			 return new Temperature(value, "K");
		 else
			 return null;
	}
}
