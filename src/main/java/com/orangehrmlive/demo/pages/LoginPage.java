package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Utility {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "txtUsername")
    WebElement usernameField;

    @FindBy(id = "txtPassword")
    WebElement passwordField;

    @FindBy(xpath = "//input[@id='btnLogin']")
    WebElement loginButton;

    @FindBy(xpath = "//div[@id='logInPanelHeading']")
    WebElement loginPanelText;


    public void loginToApplication(String name, String password) {
        sendTextToElement(usernameField, name);
        sendTextToElement(passwordField, password);
        clickOnElement(loginButton);
    }

    public String verifyLoginPanelText(){
        return getTextFromElement(loginPanelText);
    }




    // By forgotPasswordLink = By.linkText("Forgot your password");
    // By forgotPasswordText = By.xpath("//a[contains(text(),'Forgot your password?')]");
    /**
    public void clickOnForgotPasswordLink(){
        clickOnElement(forgotPasswordLink);
    }

    public String getForgotPasswordText(){
        return getTextFromElement(forgotPasswordText);
    }
    */

}
