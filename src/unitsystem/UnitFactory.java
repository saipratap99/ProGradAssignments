package unitsystem;

import unitsystem.length.CentiMeter;
import unitsystem.length.KilloMeter;
import unitsystem.length.Meter;
import unitsystem.temperature.Celcius;
import unitsystem.temperature.Fahrenheit;
import unitsystem.temperature.Kelvin;
import unitsystem.weight.Gram;
import unitsystem.weight.KilloGram;

public class UnitFactory {
	public Unit getUnitInstance(double value, String measurementType) {
		// length 
		if(measurementType.equalsIgnoreCase("cm"))
		 	return new CentiMeter(value);
		 else if(measurementType.equalsIgnoreCase("m"))
			 return new Meter(value);
		 else if(measurementType.equalsIgnoreCase("km"))
			 return new KilloMeter(value);
		 // weight
		 else if(measurementType.equalsIgnoreCase("g"))
			 return new Gram(value);
		 else if(measurementType.equalsIgnoreCase("kg"))
			 return new KilloGram(value);
		// temperature
		 else if(measurementType.equalsIgnoreCase("C"))
			 return new Celcius(value);
		 else if(measurementType.equalsIgnoreCase("F"))
			 return new Fahrenheit(value);
		 else if(measurementType.equalsIgnoreCase("K"))
			 return new Kelvin(value);
		 else
			 return null;
	}
}
