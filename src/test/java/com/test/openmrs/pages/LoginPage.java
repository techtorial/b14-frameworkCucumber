package com.test.openmrs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "username")
    WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;
    //PLEASE DO NOT USE ANY INDEX FOR ANY LOCATOR EXCEPT TABLES
    @FindBy(xpath = "//ul[@id='sessionLocation']//li")//6
    List<WebElement> locations;

    @FindBy(css = "#loginButton")
    WebElement loginButton;

    @FindBy(css = "#error-message")
    WebElement errorMessage;

    public void login(String username, String password,String location) throws InterruptedException {
        this.username.sendKeys(username);
        Thread.sleep(2000);
        this.password.sendKeys(password);
        Thread.sleep(2000);

        for(WebElement lction:locations){
            if(BrowserUtils.getText(lction).equals(location)){
                lction.click();
                break;
            }
        }
        Thread.sleep(2000);
        loginButton.click();
        Thread.sleep(2000);
    }

    public String validateMessage(){
        return BrowserUtils.getText(errorMessage);
    }


}
