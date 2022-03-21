package assignments;

import java.util.Scanner;
import java.util.Stack;

public class BalancingBrackets {

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inputString = sc.nextLine();
		
		System.out.println(getBalancedBrackets(inputString));
	}

	private static String getBalancedBrackets(String inputString) {
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder(inputString);
		
		for(int i=0; i < sb.length(); i++){
            char ch = sb.charAt(i);
            if(ch == '}' || ch == ')' || ch == ']'){
            	
                if(stack.isEmpty()) {
                	sb.insert(i, getOpeningBracket(ch));
                	stack.push(sb.charAt(i++));
                }
                else if(ch == '}'){
                    if(stack.peek() != '{') {
                    	sb.insert(i++, String.valueOf('{'));
                    	stack.push('{');
                    }
                }else if(ch == ')'){
                    if(stack.peek() != '(' ) {
                    	sb.insert(i++, String.valueOf('('));
                    	stack.push('(');
                    }
                }else if(ch == ']'){
                    if(stack.peek() != '[' ) {
                    	sb.insert(i++, String.valueOf('['));
                    	stack.push('[');
                    }
                }
                
                stack.pop();
                
            }else
                stack.push(ch);
        }
		
		while(!stack.isEmpty()) 
			sb.append(getClosingBracket(stack.pop()));
		
        return sb.toString();
	}
	
	public static String getOpeningBracket(char closingBracket) {
		if(closingBracket == '}')
			return "{";
		else if(closingBracket == ')')
			return "(";
		else
			return "[";
	}
	
	public static String getClosingBracket(char openingBracket) {
		if(openingBracket == '{')
			return "}";
		else if(openingBracket == '(')
			return ")";
		else
			return "]";
	}
}

/**
*
*
*
*
* You are given a string containing different types of brackets ( [ { } ] ). 
* Your task is to generate a string with balanced brackets.
* Balanced brackets are when all the brackets are closed properly for example 
* { }, ([]), ()(), these are balanced brackets as all brackets are closed by same type of brackets.
* (], [() are not balanced brackets. 
* If the input string is already balanced then print the string without any change.
*
* Input 1:
* {()()}
* Output 1:
* {()()}
*
* Input 2:
* [() 
* Output 2:
* [()]
*
*
* i/p: [({)}
* o/p: [({()})]
*
* input: })]}}
* out: {}()[]{}{} or {{[({})}}
*
*
*
*
*/
