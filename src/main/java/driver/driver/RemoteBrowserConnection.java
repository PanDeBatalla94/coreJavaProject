package driver.driver;

import driver.util.PropertiesManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * This abstract class implements methods to use in SauceLabs and Browser Stack connection.
 */
public abstract class RemoteBrowserConnection implements Browser {
    protected static final PropertiesManager PROPERTIES_MANAGER = PropertiesManager.getInstance();
    protected static final String USERNAME = PROPERTIES_MANAGER.getRemoteUserName();
    protected static final String ACCESS_KEY = PROPERTIES_MANAGER.getRemoteAccessKey();
    protected static final String RESOLUTION = "resolution";
    private final String url;
    private static final Logger LOGGER = Logger.getLogger(RemoteBrowserConnection.class.getName());

    /**
     * This method setCapabilities the remote browser.
     *
     * @return DesiredCapabilities instance.
     */
    abstract DesiredCapabilities setCapabilities();

    /**
     * This is the constructor.
     *
     * @param url url connection.
     */
    public RemoteBrowserConnection(final String url) {
        this.url = url;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getBrowser() {
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(url), setCapabilities());
        } catch (MalformedURLException e) {
            LOGGER.error("URL bad created:", e);
        }
        return driver;
    }
}
