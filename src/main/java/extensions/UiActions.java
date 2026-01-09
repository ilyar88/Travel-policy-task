package extensions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class UiActions {
	
	// Returns a short, readable name for a WebElement's locator.
	public static String elementName(WebElement elem) {
    	final Pattern LOCATOR_PAT =
                Pattern.compile(".*->\\s*[^:]+:\\s*(.*?)]");
    	
        if (elem == null) return "<null>";
        String s = elem.toString();
        Matcher m = LOCATOR_PAT.matcher(s);
        return m.matches() ? m.group(1).trim() : s.trim();
	}
	
	public static void click(WebElement elem) { 
		elem.click();
		Reporter.log("Click on element (" + elementName(elem) + ")'<br/>");
	}

    public static void enterText(WebElement elem, String text) {
    	elem.sendKeys(text);
    	Reporter.log("Enter text (" + elementName(elem) + "): " + text + "'<br/>");
    }

    public static String getText(WebElement elem) {
    	// Search for the first number in the text, if no number return all the text.
        String text = elem.getText();
        Matcher num = Pattern.compile("-?\\d+").matcher(text);
        String r = num.find() ? num.group() : text;
        return r;
    }
}