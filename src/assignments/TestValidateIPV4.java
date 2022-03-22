package assignments;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestValidateIPV4 {
	@Test
	public void testIsValidIPV4Test1() {
		assertTrue(ValidateIPV4.isValidIPV4("1.1.1.1"));
	}
	
	@Test
	public void testIsValidIPV4Test2() {
		assertTrue(ValidateIPV4.isValidIPV4("192.168.1.1"));
	}
	
	@Test
	public void testIsValidIPV4Test3() {
		assertTrue(ValidateIPV4.isValidIPV4("10.0.0.1"));
	}
	
	@Test
	public void testIsValidIPV4Test4() {
		assertTrue(ValidateIPV4.isValidIPV4("127.0.0.1"));
	}
	
	@Test
	public void testIsValidIPV4Test5() {
		assertFalse(ValidateIPV4.isValidIPV4("0.0.0.0"));
	}
	
	@Test
	public void testIsValidIPV4Test6() {
		assertFalse(ValidateIPV4.isValidIPV4("255.255.255.255"));
	}
	
	@Test
	public void testIsValidIPV4Test7() {
		assertFalse(ValidateIPV4.isValidIPV4("1.1.1.0"));
	}
	
	@Test
	public void testIsValidIPV4Test8() {
		assertFalse(ValidateIPV4.isValidIPV4("10.0.1"));
	}
	
}
