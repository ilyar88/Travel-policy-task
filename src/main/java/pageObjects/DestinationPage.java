package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DestinationPage {
	
	private  WebDriver _driver;
	
	public DestinationPage(WebDriver driver) {
		_driver = driver;
    }	
    //Choose land like: USA, Canada, Africa
	public WebElement land(String value) {
        return _driver.findElement(By.cssSelector("div[data-hrl-bo='" + value + "']"));
    }
    //Button with text: Continue to select travel dates
	public WebElement updateSelect() {
        return _driver.findElement(By.cssSelector("button[data-hrl-bo='wizard-next-button']"));
    }
}