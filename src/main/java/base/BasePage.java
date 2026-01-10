package base;

import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.*;

public class BasePage {
    // Base test class includes: loads config, initializes WebDriver, and teardown
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

    // Prepare browser before tests: create driver, set waits, and open URL
    @BeforeClass(alwaysRun = true)
    public void setup() {
        int waitSeconds = Integer.parseInt(prop.getProperty("waitTime"));
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitSeconds));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get(prop.getProperty("URL"));

        ManagePages.init(driver);
    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Use temp browser profile for GitHub Actions
    private Path tempProfileDir;

    public WebDriver getDriver() {
        if (driver != null) return driver;
        //Use headless browser for the GitHub Actions
        boolean headless = true;

        if (tempProfileDir == null) {
            try {
                tempProfileDir = Files.createTempDirectory("browser-profile-");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        switch (prop.getProperty("browser")) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions fOpts = new FirefoxOptions();
                fOpts.addArguments("-profile", tempProfileDir.toAbsolutePath().toString());
                fOpts.addArguments("-width=1920", "-height=1080");
                if (headless) fOpts.addArguments("-headless");
                driver = new FirefoxDriver(fOpts);
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions eOpts = new EdgeOptions();
                eOpts.addArguments("--user-data-dir=" + tempProfileDir.toAbsolutePath());
                eOpts.addArguments("--window-size=1920,1080");
                if (headless) eOpts.addArguments("--headless=new"); // fixed for Edge
                driver = new EdgeDriver(eOpts);
                break;

            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions cOpts = new ChromeOptions();
                cOpts.addArguments("--user-data-dir=" + tempProfileDir.toAbsolutePath());
                cOpts.addArguments("--window-size=1920,1080");
                if (headless) cOpts.addArguments("--headless=new"); // fixed for Chrome
                driver = new ChromeDriver(cOpts);
        }
        return driver;
    }
}
