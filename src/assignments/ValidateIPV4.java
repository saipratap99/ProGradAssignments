package assignments;

import java.util.Arrays;
import java.util.Scanner;

public class ValidateIPV4 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String ivp4 = sc.nextLine();
		System.out.println(isValidIPV4(ivp4));
	}
	
	public static boolean isValidIPV4(String ip) {
		String[] bytes = ip.split("[.]{1}");
		
		if(bytes.length != 4)
			return false;
		
		for(int i = 0; i < bytes.length; i++) {
			
			if(bytes[i].matches("[0-9]+")) {
				int eachByte = Integer.parseInt(bytes[i]);
				if(eachByte < 0 || eachByte > 255)
					return false;
				 if(i == bytes.length - 1 && (eachByte == 0 || eachByte == 255))
					 return false;
			}else
				return false;
				
		}
		return true;
	}
}


/*
Create a class with one method called ValidateIpv4Address. T
he method takes a string and return true if it is valid host assignable IP address and false if not. 
IPv4 addresses are 32 bits long and grouped into 4 one byte blocks separated by dotted-decimal 
notation. E.g. 192.168.1.1. 
Most IP addresses ending in 0 represent the entire network segment and cannot be used as host 
addresses. And most IP addresses ending in 255 represent a broadcast address and cannot be used as 
a host address. There are exceptions, when using subnets, for the sake of this problem any 
address ending in 0 or 255 is not a valid host address (edited) 
3:45
IP Address     Result (edited) 
3:47
1.1.1.1   true
3:47
192.168.1.1 true
3:47
10.0.0.1 true
3:47
127.0.0.1 true
3:48
0.0.0.0 false
3:48
255.255.255.255 false
3:48
1.1.1.0 false
3:48
10.0.1 false

*/