package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage extends BasePage {
    // Locators
    private final By getStartedButton = By.id("com.mulkiapp:id/btn_get_start");
    private final By skipButton = By.id("com.mulkiapp:id/buttonSkip");
    private final By signinButton = By.id("com.mulkiapp:id/btn_sign_in");
    private final By emailField = By.id("com.mulkiapp:id/email_edit_text");
    private final By passwordField = By.id("com.mulkiapp:id/password_edit_text");
    private final By loginButton = By.id("com.mulkiapp:id/btn_sign_in");
    private final By errorMessage = By.id("com.mulkiapp:id/tv_error_message");
    private final By confirmSigninButton = By.id("com.mulkiapp:id/btn_sign_in");

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Complete login flow from start to finish
     * @param email User's email
     * @param password User's password
     * @return true if login was successful, false otherwise
     */
    public boolean completeLogin(String email, String password) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            
            // Initial app load and get started
            //Thread.sleep(3000); // Wait for app to load
            wait.until(ExpectedConditions.elementToBeClickable(getStartedButton));
            click(getStartedButton);
            Thread.sleep(2000);

            // Skip onboarding if present
            try {
                wait.until(ExpectedConditions.elementToBeClickable(skipButton));
                click(skipButton);
                Thread.sleep(2000);
            } catch (Exception e) {
                // Skip button might not be present, continue with login
            }

            // Click sign in and enter credentials
            wait.until(ExpectedConditions.elementToBeClickable(signinButton));
            click(signinButton);
            Thread.sleep(2000);

            // Enter credentials
            wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
            sendKeys(emailField, email);
            sendKeys(passwordField, password);

            // Click login and confirm
            wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            click(loginButton);
            Thread.sleep(5000);

            // Handle confirmation if needed
            try {
                wait.until(ExpectedConditions.elementToBeClickable(confirmSigninButton));
                click(confirmSigninButton);
                Thread.sleep(5000);
            } catch (Exception e) {
                // Confirmation might not be needed, continue
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Get error message if login fails
     * @return Error message text or empty string if no error
     */
    public String getErrorMessage() {
        try {
            return getText(errorMessage);
        } catch (Exception e) {
            return "";
        }
    }
} 