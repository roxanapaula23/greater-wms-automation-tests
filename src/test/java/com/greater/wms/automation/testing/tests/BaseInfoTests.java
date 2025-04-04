package com.greater.wms.automation.testing.tests;

import com.greater.wms.automation.testing.components.BaseInfoComponent;
import com.greater.wms.automation.testing.components.RegisterComponent;
import com.greater.wms.automation.testing.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.UUID;

public class BaseInfoTests {
    private WebDriver driver;
    private BaseInfoComponent baseInfoComponent;
    private RegisterComponent registerComponent;
    private DriverManager driverManager;

    @BeforeClass
    public void setUp() {
        driver = DriverManager.getDriver();

    }

    @Test
    public void testSupplierCreation() throws InterruptedException {
        baseInfoComponent = new BaseInfoComponent(driver);
        baseInfoComponent.accessBaseInfoLink();

        String username = "test.user." + UUID.randomUUID();
        registerComponent = new RegisterComponent(driver, username, "P@ssw0rd7!", "P@ssw0rd7!");

        registerComponent.fillRegistrationForm();
        registerComponent.clickRegisterFormButton();

        baseInfoComponent.accessBaseInfoLink();
        baseInfoComponent.accessSupplierLink();
        baseInfoComponent.clickNewButton();
        baseInfoComponent.enterSupplierName("TechNova");
        baseInfoComponent.enterSupplierCity("Iasi");
        baseInfoComponent.enterSupplierAddress("Tehnicii Street");
        baseInfoComponent.enterSupplierManager("George Popescu");
        baseInfoComponent.enterSupplierContact("0700123456");
        baseInfoComponent.enterSupplierLevel("2");
        baseInfoComponent.clickSubmitFormButton();

        // TODO: select item created and assert
    }

    @AfterClass
    public void tearDown() {
        DriverManager.tearDown();
    }
}