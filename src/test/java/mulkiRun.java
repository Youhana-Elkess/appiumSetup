import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.net.MalformedURLException;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import pages.LoginPage;

public class mulkiRun {

    @Test
    public void openMulkiAPp() throws MalformedInputException, MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Mi A3");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability("appPackage", "com.mulkiapp");
        caps.setCapability("appActivity", "com.mulkiapp.main.presentation.MainActivity");
        
        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4724/"), caps);
        
        // Create login page object
        LoginPage loginPage = new LoginPage(driver);
        
        // Perform login actions
        loginPage.clickGetStarted();
        loginPage.login("test@example.com", "password123");
    }
}