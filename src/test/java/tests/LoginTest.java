package tests;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginTest {
    private AndroidDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Mi A3");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.mulkiapp");
        caps.setCapability("appActivity", "com.mulkiapp.main.presentation.MainActivity");
        
        driver = new AndroidDriver(new URL("http://localhost:4723/"), caps);
        loginPage = new LoginPage(driver);
    }

    @Test(description = "Verify successful login with valid credentials")
    public void testSuccessfulLogin() {
        // Click get started button
        loginPage.completeLogin("youhana706@gmail.com", "youhana123");
    }


    @AfterMethod (enabled = false)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
} 