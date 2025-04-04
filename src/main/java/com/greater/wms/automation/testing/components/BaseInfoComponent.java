package com.greater.wms.automation.testing.components;

import com.greater.wms.automation.testing.utils.PropertiesReader;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseInfoComponent {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private String baseAppURL;

    // TODO: I used css selectors because components have generated attributes and it fails to get the element based on xpath
    private final By NEW_BUTTON = By.cssSelector("#q-app > div > div.q-page-container.main-page > main > div.main-table > div > div.q-table__container.q-table--cell-separator.column.no-wrap.q-table__card.q-table--flat.q-table--bordered.q-table--no-wrap.my-sticky-header-column-table.shadow-24 > div.q-table__top.relative-position.row.items-center > div.q-btn-group.row.no-wrap.inline.q-btn-group--push > button:nth-child(1)");
    private final By SUPPLIER_NAME_LOCATOR = By.cssSelector("body > div.q-dialog.fullscreen.no-pointer-events.q-dialog--modal > div.q-dialog__inner.flex.no-pointer-events.q-dialog__inner--minimized.q-dialog__inner--standard.fixed-full.flex-center > div > div.scroll.q-card__section.q-card__section--vert > label.q-field.q-validation-component.row.no-wrap.items-start.q-input.q-field--outlined.q-field--square.q-field--highlighted.q-field--labeled.q-field--dense.q-field--with-bottom.q-field--error");
    private final By SUPPLIER_CITY_LOCATOR = By.cssSelector("body > div.q-dialog.fullscreen.no-pointer-events.q-dialog--modal > div.q-dialog__inner.flex.no-pointer-events.q-dialog__inner--minimized.q-dialog__inner--standard.fixed-full.flex-center > div > div.scroll.q-card__section.q-card__section--vert > label:nth-child(2)");
    private final By SUPPLIER_ADDRESS_LOCATOR = By.cssSelector("body > div.q-dialog.fullscreen.no-pointer-events.q-dialog--modal > div.q-dialog__inner.flex.no-pointer-events.q-dialog__inner--minimized.q-dialog__inner--standard.fixed-full.flex-center > div > div.scroll.q-card__section.q-card__section--vert > label:nth-child(3)");
    private final By SUPPLIER_CONTACT_LOCATOR = By.cssSelector("body > div.q-dialog.fullscreen.no-pointer-events.q-dialog--modal > div.q-dialog__inner.flex.no-pointer-events.q-dialog__inner--minimized.q-dialog__inner--standard.fixed-full.flex-center > div > div.scroll.q-card__section.q-card__section--vert > label:nth-child(4)");
    private final By SUPPLIER_MANAGER_LOCATOR = By.cssSelector("body > div.q-dialog.fullscreen.no-pointer-events.q-dialog--modal > div.q-dialog__inner.flex.no-pointer-events.q-dialog__inner--minimized.q-dialog__inner--standard.fixed-full.flex-center > div > div.scroll.q-card__section.q-card__section--vert > label:nth-child(5)");
    private final By SUPPLIER_LEVEL_LOCATOR = By.cssSelector("body > div.q-dialog.fullscreen.no-pointer-events.q-dialog--modal > div.q-dialog__inner.flex.no-pointer-events.q-dialog__inner--minimized.q-dialog__inner--standard.fixed-full.flex-center > div > div.scroll.q-card__section.q-card__section--vert > label:nth-child(6)");
    private final By SUBMIT_FORM_BUTTON = By.cssSelector("body > div.q-dialog.fullscreen.no-pointer-events.q-dialog--modal > div.q-dialog__inner.flex.no-pointer-events.q-dialog__inner--minimized.q-dialog__inner--standard.fixed-full.flex-center > div > div:nth-child(3) > button.q-btn.q-btn-item.non-selectable.no-outline.q-btn--standard.q-btn--rectangle.bg-primary.text-white.q-btn--actionable.q-focusable.q-hoverable.q-btn--wrap");

    public BaseInfoComponent(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PropertiesReader propertiesReader = new PropertiesReader("properties.yml");
        baseAppURL = propertiesReader.getProperty("baseURL").toString();
    }

    public void accessBinSizeLink() {
        driver.get(baseAppURL + "#/warehouse/binsize");
    }

    public void accessBaseInfoLink() {
        driver.get(baseAppURL + "#/baseinfo/company");
    }

    public void accessSupplierLink() {
        driver.get(baseAppURL + "#/baseinfo/supplier");
    }

    public void clickNewButton() {
        wait.until(ExpectedConditions.elementToBeClickable(NEW_BUTTON)).click();
    }

    public void enterSupplierName(String supplierName) {
        WebElement supplierNameField = wait.until(ExpectedConditions.presenceOfElementLocated(SUPPLIER_NAME_LOCATOR));
        supplierNameField.sendKeys(supplierName);
    }

    public void enterSupplierCity(String supplierCity) {
        WebElement supplierCityField = wait.until(ExpectedConditions.presenceOfElementLocated(SUPPLIER_CITY_LOCATOR));
        supplierCityField.sendKeys(supplierCity);
    }

    public void enterSupplierAddress(String supplierAddress) {
        WebElement supplierAddressField = wait.until(ExpectedConditions.presenceOfElementLocated(SUPPLIER_ADDRESS_LOCATOR));
        supplierAddressField.sendKeys(supplierAddress);
    }

    public void enterSupplierContact(String supplierContact) {
        WebElement supplierContactField = wait.until(ExpectedConditions.presenceOfElementLocated(SUPPLIER_CONTACT_LOCATOR));
        supplierContactField.sendKeys(supplierContact);
    }

    public void enterSupplierManager(String supplierManager) {
        WebElement supplierManagerField = wait.until(ExpectedConditions.presenceOfElementLocated(SUPPLIER_MANAGER_LOCATOR));
        supplierManagerField.sendKeys(supplierManager);
    }

    public void enterSupplierLevel(String supplierAddress) {
        WebElement supplierLevelField = wait.until(ExpectedConditions.presenceOfElementLocated(SUPPLIER_LEVEL_LOCATOR));
        supplierLevelField.sendKeys(supplierAddress);
    }

    public void clickSubmitFormButton() {
        WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(SUBMIT_FORM_BUTTON));
        submitButton.click();
    }
}

