package base;

import java.io.*;
import java.nio.file.*;
import java.time.Duration;
import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.ManagePages;
 

public class BasePage {
    //Base test class include: loads config, initializes WebDriver and teardown.
	protected static WebDriver driver;
    protected Properties prop;

    public BasePage() throws IOException {
        prop = new Properties();
        Path cfg = Paths.get(System.getProperty("user.dir"),
                "src", "main", "java", "configuration", "config.properties");
        try (InputStream input = Files.newInputStream(cfg)) {
            prop.load(input);
        }
    }

    //Prepare browser before tests: create driver, set waits and open URL
    @BeforeClass(alwaysRun = true)
    public void setup() {
    	
        int waitSeconds = Integer.parseInt(prop.getProperty("waitTime"));
        
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitSeconds));
        driver.get(prop.getProperty("URL"));
        driver.manage().window().fullscreen();
        
        ManagePages.init(driver);
    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    public WebDriver getDriver() {
    	
    	String browser = prop.getProperty("browser");
    	
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            case "chrome":
            	WebDriverManager.chromedriver().setup();
            	driver = new ChromeDriver();
            	break;              
        }
        return driver;
    }
}
