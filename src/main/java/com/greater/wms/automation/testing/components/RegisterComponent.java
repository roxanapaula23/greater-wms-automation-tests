package com.greater.wms.automation.testing.components;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterComponent {

    private final By USER_NAME_INPUT_XPATH = By.xpath("//input[@aria-label='User Name']");
    private final By PASSWORD_INPUT_XPATH = By.xpath("//input[@aria-label='Password']");
    private final By CONFIRM_PASSWORD_INPUT_XPATH = By.xpath("//input[@aria-label='Confirm Password']");
    private final By REGISTER_BUTTON_FORM_CSS_SELECTOR = By.cssSelector("body > div.q-dialog.fullscreen.no-pointer-events.q-dialog--modal > div.q-dialog__inner.flex.no-pointer-events.q-dialog__inner--minimized.q-dialog__inner--standard.fixed-full.flex-center > div > div.q-card__actions.text-primary.q-mx-sm.q-card__actions--horiz.row.justify-end > button");

    private final WebDriver driver;

    private String username;
    private String password;
    private String confirmPassword;

    public RegisterComponent(WebDriver driver, String username, String password, String confirmPassword) {
        this.driver = driver;
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public void fillRegistrationForm() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(USER_NAME_INPUT_XPATH));

        WebElement usernameField = driver.findElement(USER_NAME_INPUT_XPATH);
        usernameField.sendKeys(username);

        WebElement passwordField = driver.findElement(PASSWORD_INPUT_XPATH);
        passwordField.sendKeys(password);

        WebElement confirmPasswordField = driver.findElement(CONFIRM_PASSWORD_INPUT_XPATH);
        confirmPasswordField.sendKeys(confirmPassword);
    }

    public void clickRegisterFormButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(REGISTER_BUTTON_FORM_CSS_SELECTOR));
            registerButton.click();
        } catch (StaleElementReferenceException e) {
            WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(REGISTER_BUTTON_FORM_CSS_SELECTOR));
            registerButton.click();
        }
    }
}


