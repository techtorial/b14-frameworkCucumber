package com.test.openmrs.stepdefinitions;

import com.test.openmrs.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class LoginStepDef {
    WebDriver driver= DriverHelper.getDriver();
    LoginPage loginPage=new LoginPage(driver);
    @Given("User navigates to the OpenMrs website and provides credentials and location {string}")
    public void user_navigates_to_the_open_mrs_website_and_provides_credentials(String location) throws InterruptedException {
        loginPage.login(ConfigReader.readProperty("QA_username"),ConfigReader.readProperty("QA_password"),location);
    }
    @Then("User validates the title {string} and url {string}")
    public void user_validates_the_title_and_url(String expectedTitle, String expectedUrl) {
        Assert.assertEquals(expectedTitle,driver.getTitle().trim());
        Assert.assertEquals(expectedUrl,driver.getCurrentUrl().trim());
    }

    @Given("User navigates to the OpenMrs website and provides credentials {string},{string} and location {string}")
    public void user_navigates_to_the_open_mrs_website_and_provides_credentials_and(String username, String password,String location) throws InterruptedException {
        loginPage.login(username,password,location);
    }
    @Then("User validates the error message {string}")
    public void user_validates_the_error_message(String expectedMessage) {
        Assert.assertEquals(expectedMessage,loginPage.validateMessage());
    }
}
