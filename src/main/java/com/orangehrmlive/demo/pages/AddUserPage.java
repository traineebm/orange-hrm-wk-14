package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUserPage extends Utility {

    public AddUserPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select[@id='systemUser_userType']")
    WebElement userRoleDropDown;

    @FindBy (xpath = "//input[@id='systemUser_employeeName_empName']")
    WebElement employeeNameField;

    @FindBy (xpath = "//input[@id='systemUser_userName']")
    WebElement userNameField;

    @FindBy (xpath = "//select[@id='systemUser_status']")
    WebElement statusDropDown;

    @FindBy (id = "systemUser_password")
    WebElement passwordField;

    @FindBy (id = "systemUser_confirmPassword")
    WebElement confirmPasswordField;

    @FindBy (id = "btnSave")
    WebElement saveButton;

    @FindBy (id = "btnCancel")
    WebElement cancelButton;


    public void selectUserRoleDropDown(String text){
        selectByVisibleTextFromDropDown(userRoleDropDown,text);
    }

    public void enterEmployeeNameField(String employeeName){
        sendTextToElement(employeeNameField,employeeName);
    }

    public void enterUserNameField(String username){
        sendTextToElement(userNameField,username);
    }

    public void selectStatusDropDown(String value){
        selectByValueFromDropDown(statusDropDown,value);
    }

    public void enterPasswordField(String password){
        sendTextToElement(passwordField,password);
    }

    public void enterConfirmPasswordField(String confirmPassword){
        sendTextToElement(confirmPasswordField,confirmPassword);
    }

    public void clickOnSaveButton(){
        clickOnElement(saveButton);
    }

    public void clickOnCancelButton(){
        clickOnElement(cancelButton);
    }
}
