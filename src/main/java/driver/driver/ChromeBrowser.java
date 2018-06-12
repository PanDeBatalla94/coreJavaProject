package driver.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Class to return the ChromeDriver for Chrome browser.
 */
public class ChromeBrowser implements Browser {
    /**
     * Get the Chrome org.fundacionjala.core.driver.
     *
     * @return the ChromeDriver.
     */
    @Override
    public WebDriver getBrowser() {
        return new ChromeDriver();
    }
}
