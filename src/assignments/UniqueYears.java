package assignments;

import java.util.*;
import java.text.*;
import java.io.*;
public class UniqueYears
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> lines = new ArrayList<>();

        String line;
        while((line = br.readLine()) != null)
            lines.add(line);
        
        for(String eachLine: lines)
            System.out.print(eachLine + "\n");

        System.out.println("\nCount: " + countUniqueYears(lines));
	}

    public static int countUniqueYears(List<String> lines){
        Set<Integer> uniqueYears = new HashSet<>();

        for(String eachLine: lines)
            uniqueYears.addAll(getYearsInALine(eachLine));
        
        return uniqueYears.size();
    }

    public static List<Integer> getYearsInALine(String line){
        List<Integer> years = new LinkedList<>();

        String[] words = line.split("[ ,.]+|[a-zA-Z]+");
        
        for(String eachWord: words){

            if(!eachWord.isEmpty() && eachWord.matches("[0-3][0-9]-[0-1][0-9]-[0-9]{4}") && isValidDate(eachWord)){
                String yearInString = eachWord.substring(eachWord.length() - 4);
                int year = Integer.parseInt(yearInString);
                years.add(year);
            }
        }

        return years;
    }

    public static boolean isValidDate(String date){
        
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            sdf.setLenient(false);
            Date d = sdf.parse(date);
            return true;
        }
        catch(ParseException e){
            System.out.println(e);
        }
        catch(Exception e){
            System.out.println(e);
        }

        return false;
    }
    
}

/*

Suppose you have a string in the form of a paragraph as input. 
And important dates in the para are provided in the format 
"dd-mm-yyyy", calculate number of unique years present in the paragraph
Sample input : 
Hello Earthlings , Today is 16-03-2022, you will be destroyed by 01-01-2025
Sample output: 2
Sample input: You have meetings on 22-12-2022, 25-12-2022 and 03-01-2023
Sample outpt:2



Hello Earthlings , Today is 16-03-2022, you will be destroyed by 01-01-2025
You have meetings on 22-12-2022, 25-12-2022 and 03-01-2023


My mother-in-law was born on 10-12-1967.
*/




        // System.out.println(Arrays.toString(words));
        
        // if(!eachWord.isEmpty() && eachWord.matches("[0-3][0-9]-[0-1][0-9]-[0-9]{4}")){

        // System.out.println(years);