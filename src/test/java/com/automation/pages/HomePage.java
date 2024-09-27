package com.automation.pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.Collections;

public class HomePage extends BasePage {

    @FindBy(id = "com.ebay.mobile:id/identity_app_onboarding_screen_close")
    WebElement closeSignIn;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='eBay']")
    WebElement isHomePage;

    @FindBy(xpath = "//android.widget.TextView[@text='Search on eBay']")
    WebElement ebaySearch;

    @FindBy(className = "android.widget.AutoCompleteTextView")
    WebElement inputSearch;

    @FindBy(xpath = "//android.widget.AutoCompleteTextView[@text='laptop']")
    WebElement submit;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.ebay.mobile:id/textview_header_0']")
    WebElement firstElement;

    @FindBy(xpath = "//android.widget.RelativeLayout/android.widget.ImageView")
    WebElement clickImage;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"When you save a search, we'll let you know when a new item is listed double tap to dismiss\"]\n")
    WebElement save;

    @FindBy(className = "android.widget.ImageView")
    WebElement imageclick;

    public void openApplication() {
        clickOnElementIfPresent(closeSignIn);
//        clickOnElementIfPresent(allowButton);
//        clickOnElementIfPresent(closeLocation);
    }


    public boolean isHomeScreenDisplayed() {

        return ebaySearch.isDisplayed();
    }

    public void searchElement(String element1){
        waitForElementToBeVisible(ebaySearch);
        ebaySearch.click();
        waitForElementToBeVisible(inputSearch);
        inputSearch.sendKeys(element1);
//        waitForElementToBeVisible(submit);
//        submit.submit();
        Actions actions=new Actions(driver);
        actions.keyDown(Keys.ENTER).build().perform();
    }

    public void clickElement() {
        save.click();
        firstElement.click();
    }

    public void clickImage() {
        clickImage.click();
    }

    public void zoom() throws InterruptedException {
        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();
        zooming(width / 2, height / 2);
        Thread.sleep(3000);
        zooming(width / 2, height / 2);
        Thread.sleep(3000);

    }
}
