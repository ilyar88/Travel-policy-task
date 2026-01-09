package pageObjects;

import org.openqa.selenium.WebDriver;

public class ManagePages {
    private static WebDriver _driver;

    public static void init(WebDriver driver) {
    	_driver = driver;
    }
    // Creates and returns a page object instance of the given class using WebDriver.
    public static <T> T page(Class<T> type) {
        try {
            return type.getConstructor(WebDriver.class).newInstance(_driver);
        } catch (Exception e) {
            throw new RuntimeException("Can't create " + type.getSimpleName(), e);
        }
    }
    
	public static String getUrl() {
	    return _driver.getCurrentUrl();
	}
	
	public static String getTile() {
	    return _driver.getTitle();
	}
}
