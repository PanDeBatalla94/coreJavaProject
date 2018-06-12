package driver.util;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

/**
 * PropertiesManager.java.
 * Class that applies Singleton pattern to instance Properties only once.
 */
public final class PropertiesManager {
    private static PropertiesManager propertiesManager;
    private Properties prop;
    private static final Logger LOGGER = Logger.getLogger(PropertiesManager.class.getName());


    /**
     * Constructor, private to apply singleton pattern.
     */
    private PropertiesManager() {
        init();
    }

    /**
     * Static method to get an class instance.
     *
     * @return instance.
     */
    public static PropertiesManager getInstance() {
        if (propertiesManager == null) {
            propertiesManager = new PropertiesManager();
        }
        return propertiesManager;
    }

    /**
     * Initialize Properties object.
     */
    private void init() {
        prop = new Properties();
        try (InputStream input = new FileInputStream("gradle.properties")) {
            prop.load(input);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    /**
     * Gets Url Login.
     *
     * @param var variable obtained of gradle.properties.
     * @return the enviroment value.
     */
    private String getEnvValue(final String var) {
        String property = System.getProperty(var);
        return !Objects.isNull(property) ? property : prop.getProperty(var);
    }

    /**
     * Gets Url Login.
     *
     * @return String url login.
     */
    public String getUrlLogin() {
        return getEnvValue("urlLogin");
    }

    /**
     * Getter of username.
     *
     * @return String username.
     */
    public String getUsername() {
        return getEnvValue("user");
    }

    /**
     * Getter of password.
     *
     * @return String password.
     */
    public String getPassword() {
        return getEnvValue("password");
    }

    /**
     * Getter of theme.
     *
     * @return String theme.
     */
    public String getTheme() {
        return getEnvValue("theme");
    }

    /**
     * Gets browser.
     *
     * @return string browser.
     */
    public String getBrowser() {
        return getEnvValue("browser");
    }

    /**
     * Getter of docker.
     *
     * @return string docker URL.
     */
    public String getDockerUrl() {
        return getEnvValue("dockerURL");
    }

    /**
     * Gets remote user name.
     *
     * @return string remote user name.
     */
    public String getRemoteUserName() {
        return getEnvValue("remoteUserName");
    }

    /**
     * Gets remote access key.
     *
     * @return string remote access key.
     */
    public String getRemoteAccessKey() {
        return getEnvValue("remoteAccessKey");
    }

    /**
     * Gets remote Browser Name .
     *
     * @return string remote Browser Name.
     */
    public String getRemoteBrowserName() {
        return getEnvValue("remoteBrowserName");
    }

    /**
     * Gets remote Version.
     *
     * @return string remote Version.
     */
    public String getRemoteBrowserVersion() {
        return getEnvValue("remoteBrowserVersion");
    }

    /**
     * Gets remote platform.
     *
     * @return string remote platform.
     */
    public String getRemotePlatform() {
        return getEnvValue("remotePlatform");
    }

    /**
     * Gets remote Resolution.
     *
     * @return string remote Resolution.
     */
    public String getRemoteResolution() {
        return getEnvValue("remoteResolution");
    }

    /**
     * Gets remote operative system.
     *
     * @return string remote operative system.
     */
    public String getRemoteOS() {
        return getEnvValue("remoteOS");
    }

    /**
     * Gets remote operative system.
     *
     * @return string remote operative system.
     */
    public String getRemoteOSVersion() {
        return getEnvValue("remoteOSVersion");
    }
}
