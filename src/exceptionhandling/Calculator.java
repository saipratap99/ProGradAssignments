package exceptionhandling;


import java.util.InputMismatchException;
import java.util.Scanner;

/**
*
*	Given input in the form of [operand operator operand ] give the out put
*	Sample test case 3 + 1 output:4
*	Sample test case 4 4 4 output:invalid operator
*	Sample test case 3 * * output:invalid operand
*	However in the 2 last cases there is a handled exception expected not just the raw string output
*
*	Addition, Subtraction, Multiplication, Division
*/

public class Calculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String eqn = sc.nextLine();
        try{
            System.out.println(eval(eqn));
        }catch(NumberFormatException e){
            System.out.println(e + ". Invalid Operand or operand must be within the limit of int");
        }catch(ArithmeticException e){
            System.out.println(e);
        }catch(InputMismatchException e){
            System.out.println(e);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    // Divide by 0
    // Number must be within the range of int
    // invalid operator
    // Invalid eqn
    private static int eval(String eqn) throws NumberFormatException, ArithmeticException, InputMismatchException,Exception {
        String[] splitedEqn = eqn.trim().split("[ ]+");
        if(splitedEqn.length < 3)
            throw new InputMismatchException("Invalid eqn. Eqn must be in the format of [operand operator operand]");
            
        int a = Integer.parseInt(splitedEqn[0]);
        int b = Integer.parseInt(splitedEqn[2]);
        
        switch(splitedEqn[1]){
            case "+":
                return a + b;
            case "-": 
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            case "%":
                return a % b;
        }
        throw new ArithmeticException("Invalid operator");
    }
    
}
