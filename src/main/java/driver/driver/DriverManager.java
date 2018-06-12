package driver.driver;


import driver.util.PropertiesManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * DriverManager.java.
 * Class that applies Singleton pattern to instance WebDriver only once.
 */
public final class DriverManager {
    private static final int EXPLICIT_TIME = 60;
    private static DriverManager driverManager;
    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * Constructor, private to apply singleton pattern.
     */
    private DriverManager() {
        PropertyConfigurator.configure("log4j.properties");
        DriverType driverType = DriverType.valueOf(PropertiesManager.getInstance().getBrowser());
        driver = DriverFactory.getDriverManager(driverType);
        wait = new WebDriverWait(driver, EXPLICIT_TIME);
    }

    /**
     * Static method to get an class instance.
     *
     * @return instance.
     */
    public static DriverManager getInstance() {
        if (driverManager == null) {
            driverManager = new DriverManager();
        }
        return driverManager;
    }

    /**
     * Getter of WebDriver object.
     *
     * @return WebDriver instance.
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Getter of WebDriverWait object.
     *
     * @return WebDriverWait instance.
     */
    public WebDriverWait getWaiter() {
        return wait;
    }

    /**
     * Set time implicit wait.
     *
     * @param implicitTimeWait time for wait.
     */
    public void setImplicitTime(int implicitTimeWait) {
        driver.manage().timeouts().implicitlyWait(implicitTimeWait, TimeUnit.SECONDS);
    }

    /**
     * Set update waits.
     *
     * @param time time for implicit and explicit.
     */
    public void setUpdateWait(int time) {
        this.setImplicitTime(time);
    }

    /**
     * Back previous set default times.
     */
    public void backPreviousWait() {
        this.setImplicitTime(0);
    }


}
