package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DatePage {
	
	private  WebDriver _driver;
	
	public DatePage(WebDriver driver) {
		_driver = driver;
    }
    
	public WebElement datePicker(String date) {
        return _driver.findElement(By.cssSelector("div.MuiPickersSlideTransition-transitionContainer "
        		                                + "button[data-hrl-bo='" + date + "']"));
    }
    //Span for assert the total days
	public WebElement totalDays() {
        return _driver.findElement(By.cssSelector("span[data-hrl-bo='total-days']"));
    }
	//Button with text: Back
	public WebElement back() {
        return _driver.findElement(By.cssSelector("button[data-hrl-bo='wizard-back-button']"));
    }
	//Button with text: Go to passenger details
	public WebElement next() {
        return _driver.findElement(By.cssSelector("button[data-hrl-bo='wizard-next-button']"));
    }
}
