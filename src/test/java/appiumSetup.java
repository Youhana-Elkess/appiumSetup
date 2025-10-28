import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.net.MalformedURLException;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import pages.LoginPage;

public class appiumSetup {

    @Test
    public void openMulkiAPp() throws MalformedInputException, MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Mi A3");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.UDID, "R58R91ZLQWT");
		caps.setCapability("appPackage", "com.bluev.users.dev");
		caps.setCapability("appActivity", "com.bluev.users.MainActivity");
        
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), caps);
        
        // Create login page object
        LoginPage loginPage = new LoginPage(driver);
        
		// Perform login actions
		loginPage.completeLogin("test@example.com", "password123");
    }
}