package extensions;

import org.testng.Assert;
import org.testng.Reporter;

public class Verifications {
	//Verify that all the expected text matches the actual text
	public static void verifyEquals(String actual, String expected) {
	    try {
	        Assert.assertEquals(actual, expected);
	        Reporter.log("Verify equals PASSED: " + actual + " == " + expected + "'<br/>", true);
	    } catch (AssertionError e) {
	        Reporter.log("Verify equals FAILED: " + actual + " != " + expected + "'<br/>", true);
	        throw e;
	    }
	}
    //Verify that the actual text is contained within the expected text
	public static void verifyText(String actual, String expected) {
	    try {
	        Assert.assertTrue(
	        actual.contains(expected), expected);
	        Reporter.log("Verify text PASSED: '" + actual + "' contains '" + expected + "'<br/>", true);
	    } catch (AssertionError e) {
	        Reporter.log("Verify text FAILED: '" + actual + "' does not contain '" + expected + "'<br/>", true);
	        throw e;
	    }
	}

}
