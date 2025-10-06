import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.URL;
import java.time.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class appiumTest {
    private static final Logger logger = LoggerFactory.getLogger(appiumTest.class);
    private AndroidDriver driver;

    @BeforeTest
    public void setup() {
        logger.info("Checking connected devices...");
        try {
            Process process = Runtime.getRuntime().exec("adb devices");
            java.io.BufferedReader reader = new java.io.BufferedReader(
                    new java.io.InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                logger.info("Device: {}", line);
            }
        } catch (Exception e) {
            logger.error("Setup failed: {}", e.getMessage(), e);
        }
    }

    @Test
    public void openMulkiApp() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Mi A3");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("noReset", true);
        caps.setCapability("newCommandTimeout", 60);
        caps.setCapability("udid", "ae1d8f1b84fa");
        caps.setCapability("appPackage", "com.mulkiapp");
        caps.setCapability("appActivity", "com.mulkiapp.main.presentation.MainActivity");
        caps.setCapability("systemPort", 8200);
        caps.setCapability("uiautomator2ServerLaunchTimeout", 60000);
        caps.setCapability("uiautomator2ServerInstallTimeout", 60000);
        caps.setCapability("forceAppLaunch", true);

        try {
            driver = new AndroidDriver(new URL("http://localhost:4724/"), caps);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            logger.info("Mulki app launched successfully");
            Thread.sleep(2000); // Wait for activity to load
            String currentActivity = driver.currentActivity();
            logger.info("Current activity: {}", currentActivity);
            if (!currentActivity.endsWith("MainActivity")) {
                throw new RuntimeException("Mulki app not launched correctly. Current activity: " + currentActivity);
            }
            logger.info("Test completed successfully");
        } catch (Exception e) {
            logger.error("Error occurred: {}", e.getMessage(), e);
            throw new RuntimeException("Test failed", e);
        }
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            try {
                logger.info("Closing driver...");
                driver.quit();
            } catch (Exception e) {
                logger.error("Error while closing driver: {}", e.getMessage());
            }
        }
    }
}
