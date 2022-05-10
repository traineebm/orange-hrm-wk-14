package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewSystemUsersPage extends Utility {

    public ViewSystemUsersPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'>')]")
    WebElement systemUsersText;

    @FindBy (id = "searchSystemUser_userName")
    WebElement userNameField;

   @FindBy (id = "searchSystemUser_userType")
   WebElement userRoleDropDown;

    @FindBy (id = "searchSystemUser_employeeName_empId")
    WebElement employeeNameField;

    @FindBy (id = "searchSystemUser_status")
    WebElement statusDropDown;

    @FindBy (id = "searchBtn")
    WebElement searchButton;

    @FindBy (id = "resetBtn")
    WebElement resetButton;

    @FindBy (id = "btnAdd")
    WebElement addButton;

    @FindBy(xpath = "//input[@id='ohrmList_chkSelectAll']")
    WebElement checkBox;

    @FindBy (id = "btnDelete")
    WebElement deleteButton;

    @FindBy (xpath = "//h1[@id='UserHeading']")
    WebElement addUserText;

    @FindBy(xpath = "//div[contains(text(),'Successfully Saved')]")
    WebElement successfullySavedText;

    @FindBy(xpath = "//a[contains(text(),'Ananya1702')]")
    WebElement verifyResultList;

    @FindBy(xpath = "//div[contains(text(),'Successfully Deleted')]")
    WebElement successFullyDeletedText;

    @FindBy(id = "dialogDeleteBtn")
    WebElement deleteRecordPopUp;

    @FindBy(xpath = "//td[contains(text(),'No Records Found')]")
    WebElement noRecordFoundText;


    public String verifySystemUsersText(){
        return getTextFromElement(systemUsersText);
    }

    public void enterUserNameField(String username){
        sendTextToElement(userNameField,username);
    }

    public void selectUserRoleDropDown(String text){
        selectByVisibleTextFromDropDown(userRoleDropDown,text);
    }

    public void enterEmployeeNameField(String employeeName){
        sendTextToElement(employeeNameField,employeeName);
    }

    public void selectStatusDropDown(String value){
        selectByValueFromDropDown(statusDropDown,value);
    }

    public void clickOnSearchButton(){
        clickOnElement(searchButton);
    }

    public void clickOnResetButton(){
        clickOnElement(resetButton);
    }

    public void clickOnAddButton(){
        clickOnElement(addButton);
    }

    public void clickOnCheckBox() {
        clickOnElement(checkBox);
    }

    public void clickOnDeleteButton(){
        clickOnElement(deleteButton);
    }

    public String verifyAddUserText(){
        return getTextFromElement(addUserText);
    }

    public String verifyTextMessageSuccessfullySaved(){
        return getTextFromElement(successfullySavedText);
    }

    public String verifyUserShouldBeInResultList(){
        return getTextFromElement(verifyResultList);
    }

    public String verifyRecordSuccessfullyDeletedMessage() {
       return getTextFromElement(successFullyDeletedText);
    }

    public void acceptPopUpMessage() {
        clickOnElement(deleteRecordPopUp);
    }

    public String verifyNoRecordsFoundText(){
        return getTextFromElement(noRecordFoundText);
    }
}
