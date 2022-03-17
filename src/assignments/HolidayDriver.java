package assignments;

public class HolidayDriver
{
    public static void main(String[] args) {
		
        Holiday holiday1 = new Holiday("Independence Day", 15, "August");
        Holiday holiday2 = new Holiday("New year", 1, "January");
        Holiday holiday3 = new Holiday("Republic Day", 26, "January");
        Holiday holiday4 = new Holiday("Christmas", 25, "December");

        System.out.println(holiday1.getName() 
                            + " and " 
                            + holiday2.getName() + " are same month: " 
                            + Holiday.inSameMonth(holiday1, holiday2));

        System.out.println(holiday2.getName() 
                            + " and " 
                            + holiday3.getName() + " are same month: " 
                            + Holiday.inSameMonth(holiday2, holiday3));

        Holiday[] holidays = {holiday1, holiday2, holiday3, holiday4};
        
        System.out.println("Avg: " + Holiday.avgDate(holidays));
	}
}

class Holiday {

    private String name;
    private int day;
    private String month;
    
    // your code goes here
    public Holiday(String name, int day, String month){
        this.name = name;
        this.day = day;
        this.month = month;
    }
    
    public String getName(){
        return this.name;
    }

    public String getMonth(){
        return this.month;
    }

    public int getDay(){
        return this.day;
    }

    public static boolean inSameMonth(Holiday holiday1, Holiday holiday2){
        return holiday1.getMonth().equalsIgnoreCase(holiday2.getMonth());
    }

    public static double avgDate(Holiday[] holidays){
        double avg = 0;
        for(Holiday holiday: holidays)
            avg += holiday.getDay();
        
        avg /= holidays.length;

        return avg;
    }

}

/*

Write a constructor for the class Holiday, which takes a String representing the name,
an int representing the day, and a String representing the month as its arguments, 
and sets the class variables to these values.

Write a method inSameMonth, which compares two instances of the class Holiday, 
and returns the Boolean value true if they have the same month, and false if they do not.
Write a method avgDate which takes an array of base type Holiday as its argument, and returns a 
double that is the average of the day variables in the Holiday instances in the array. 
You may assume that the array is full (i.e. does not have any null entries).

Write a piece of code that creates a Holiday instance with the name “Independence Day”, 
with the day “4”, and with the month “July”.

*/