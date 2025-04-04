package com.greater.wms.automation.testing.tests;

import com.greater.wms.automation.testing.components.RegisterComponent;
import com.greater.wms.automation.testing.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.UUID;

public class RegisterTests {
    private static WebDriver driver;
    private RegisterComponent registerComponent;

    @BeforeClass
    public void setUp() {
        driver = DriverManager.getDriver();
        driver.get("http://0.0.0.0:8080/#/warehouse/binsize");
    }

    @Test
    public void testRegister() {
        String username = "test.user." + UUID.randomUUID();
        registerComponent = new RegisterComponent(driver, username, "P@ssw0rd7!", "P@ssw0rd7!");

        registerComponent.fillRegistrationForm();
        registerComponent.clickRegisterFormButton();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}