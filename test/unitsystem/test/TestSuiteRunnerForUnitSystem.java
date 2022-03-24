package unitsystem.test;


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestSuiteRunnerForUnitSystem {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TestSuiteForUnitSystem.class);
		if(result.getFailureCount() == 0)
			System.out.println("All test cases passed");
		else 
			for(Failure failure : result.getFailures())
				System.out.println(failure);
		System.out.println("Passed: " + (result.getRunCount() - result.getFailureCount()) + " / " + result.getRunCount());
	}
}
