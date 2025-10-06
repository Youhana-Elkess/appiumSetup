package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SettingsPage extends BasePage {
    

        private final By settingsIcon = By.id("com.mulkiapp:id/settings");
        private final By logoutButton = By.id("com.mulkiapp:id/btn_logout");
        private final By logoutConfirmButton = By.xpath("//android.widget.Button[@text='Yes']");
        
        public SettingsPage(AppiumDriver driver) {
            super(driver);
        }

        public void clickSettingsIcon() {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.elementToBeClickable(settingsIcon));
                click(settingsIcon);
                Thread.sleep(2000); // Wait for settings page to load
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void clickLogoutButton() {
            try {
                scrollToBottom();
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
                click(logoutButton);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void clickLogoutConfirmButton() {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.elementToBeClickable(logoutConfirmButton));
                click(logoutConfirmButton);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void scrollToBottom() {
            try {
                // Wait a bit for the page to be fully loaded
                Thread.sleep(1000);
                
                // Use Appium's built-in scroll functionality with text content
                driver.executeScript("mobile: scroll", 
                    new HashMap<String, Object>() {{
                        put("direction", "down");
                        put("strategy", "-android uiautomator");
                        put("selector", "new UiSelector().text(\"Logout\")");
                    }}
                );
                
                // Wait for the scroll to complete
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    

    
}
