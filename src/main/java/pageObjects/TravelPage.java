package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TravelPage {
	
	private  WebDriver _driver;
	
	public TravelPage(WebDriver driver) {
		_driver = driver;
    }
	
	public WebElement oneTimePurchase() {
        return _driver.findElement(By.cssSelector("button[data-hrl-bo='purchase-for-new-customer']"));
    }
	
	public WebElement purchaseAgain() {
        return _driver.findElement(By.cssSelector("button[data-hrl-bo='purchase-for-returning-customer']"));
    }
}