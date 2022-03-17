package assignments;

import java.util.Scanner;
public class PRString
{
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        System.out.println(isPRString(inputString) ? "perfect" : "imperfect");

        System.out.println(isPRStringUsingPattern(inputString) ? "perfect" : "imperfect");
        
	}

    public static boolean isPRString(String inputString){
        if(inputString.length() == 0)
            return true;
        
        if(inputString.equals("P") || inputString.equals("R") || inputString.equals("PR") || inputString.equals("RP"))
            return true;
        
        char curr = inputString.charAt(0) == 'P' ? 'P' : 'R';
        char next = curr == 'P' ? 'R' : 'P';

        for(int i = 0; i < inputString.length() - 1; i++){
            if(inputString.charAt(i) == curr && inputString.charAt(i+1) == next){
                char temp = curr;
                curr = next;
                next = temp;
            }else
                return false;
        }
        return true;
    }

    public static boolean isPRStringUsingPattern(String inputString){
        if(inputString.length() == 0)
            return true;
        
        if(inputString.equals("P") || inputString.equals("R") || inputString.equals("PR") || inputString.equals("RP"))
            return true;

        int len  = inputString.length();
        if(len % 2 == 0)
            return inputString.matches("[PR]*");
        else
            return inputString.substring(0, len - 2).matches("[PR]*") && inputString.charAt(0) == inputString.charAt(len-1);
        
    }
}