package com.automation.steps;

import com.automation.pages.HomePage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeSteps {

    HomePage homePage = new HomePage();

    @Given("user opens application")
    public void user_opens_application() {
        homePage.openApplication();
    }

    @Then("verify user is on home screen")
    public void verify_user_is_on_home_screen() {
        Assert.assertTrue(homePage.isHomeScreenDisplayed());
    }


    @When("user search for element1 {string}")
    public void userSearchForElement(String element1) {
        homePage.searchElement(ConfigReader.getConfigValue(element1));
    }

    @Then("verify the user is on element1 searched page")
    public void verifyTheUserIsOnElementSearchedPage() {
//        homePage.
    }

    @And("Click the first element of element1")
    public void clickTheFirstElementOfElement() {
        homePage.clickElement();
    }

    @And("click on the image of element1")
    public void clickOnTheImageOfElement() {
        homePage.clickImage();
    }

    @And("verify zoom functionality")
    public void verifyZoomFunctionality() throws InterruptedException {
        homePage.zoom();
    }
}
