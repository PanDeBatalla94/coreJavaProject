package driver.driver;

import driver.util.PropertiesManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * DockerFirefoxBrowser class.
 */
public class DockerFirefoxBrowser implements Browser {
    private static final Logger LOGGER = Logger.getLogger(DockerFirefoxBrowser.class.getName());

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getBrowser() {
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(PropertiesManager.getInstance().getDockerUrl()), new FirefoxOptions());
        } catch (MalformedURLException e) {
            LOGGER.error("URL bad created:", e);
        }
        return driver;
    }
}
