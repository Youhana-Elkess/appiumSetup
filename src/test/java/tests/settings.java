package tests;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SettingsPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class settings {
    private AndroidDriver driver;
    private LoginPage loginPage;
    private SettingsPage settingsPage;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "Mi A3");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.mulkiapp");
        caps.setCapability("appActivity", "com.mulkiapp.main.presentation.MainActivity");
        caps.setCapability("noReset", false);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
        settingsPage = new SettingsPage(driver);
    }

    @Test
    public void testLogout() {
        // Login first
        loginPage.completeLogin("youhana706@gmail.com", "youhana123");
        // Wait for login to complete
        try {
            Thread.sleep(5000); // Wait for 5 seconds after login
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Perform logout
        settingsPage.clickSettingsIcon();
        settingsPage.scrollToBottom();
        settingsPage.clickLogoutButton();
        settingsPage.clickLogoutConfirmButton();
    }

    @AfterMethod (enabled = false)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
