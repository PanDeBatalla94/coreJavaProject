package driver.driver;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * This class allows to establish the connection in the remote browser through SauceLabs.
 */
public class SauceLabs extends RemoteBrowserConnection implements Browser {

    private static final String URL =
            String.format("http://%s:%s@ondemand.saucelabs.com:80/wd/hub", USERNAME, ACCESS_KEY);
    private static final String BROWSER_NAME = "browserName";
    private static final String PLATFORM = "platform";
    private static final String BROWSER_VERSION = "version";

    /**
     * This is the constructor.
     */
    public SauceLabs() {
        super(URL);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DesiredCapabilities setCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(BROWSER_NAME, PROPERTIES_MANAGER.getRemoteBrowserName());
        capabilities.setCapability(PLATFORM, PROPERTIES_MANAGER.getRemotePlatform());
        capabilities.setCapability(BROWSER_VERSION, PROPERTIES_MANAGER.getRemoteBrowserVersion());
        capabilities.setCapability(RESOLUTION, PROPERTIES_MANAGER.getRemoteResolution());
        return capabilities;
    }
}
