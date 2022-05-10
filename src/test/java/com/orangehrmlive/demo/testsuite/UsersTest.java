package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.AddUserPage;
import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.pages.ViewSystemUsersPage;
import com.orangehrmlive.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UsersTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    ViewSystemUsersPage viewSystemUsersPage;
    AddUserPage addUserPage;

    @Test (priority = 0, groups = {"smoke", "regression"})
    public void adminShouldAddUserSuccessFully(){
        loginPage.loginToApplication("Admin", "admin123");
        homePage.clickOnAdminTab();
        String actualMessage = viewSystemUsersPage.verifySystemUsersText();
        Assert.assertEquals(actualMessage,"System Users", "Text not displayed");

        viewSystemUsersPage.clickOnAddButton();
        String actualTextMessage = viewSystemUsersPage.verifyAddUserText();
        Assert.assertEquals(actualTextMessage,"Add User", "Text not displayed");
        addUserPage.selectUserRoleDropDown("Admin");
        addUserPage.enterEmployeeNameField("Ananya Dash");
        addUserPage.enterUserNameField("Ananya1702");
        addUserPage.selectStatusDropDown("Disable");
        addUserPage.enterPasswordField("Asdfg909");
        addUserPage.enterConfirmPasswordField("Asdfg909");
        addUserPage.clickOnSaveButton();
        String actualTextMessage2 = viewSystemUsersPage.verifyTextMessageSuccessfullySaved();
        Assert.assertEquals(actualTextMessage2,"Successfully saved", "Text not displayed");
    }

    @Test (priority = 1, groups = {"sanity", "regression"})
    public void searchTheUserCreatedAndVerifyIt(){
        loginPage.loginToApplication("Admin", "admin123");
        homePage.clickOnAdminTab();
        String actualMessage = viewSystemUsersPage.verifySystemUsersText();
        Assert.assertEquals(actualMessage,"System Users", "Text not displayed");

        viewSystemUsersPage.enterUserNameField("Ananya1702");
        viewSystemUsersPage.selectUserRoleDropDown("Admin");
        viewSystemUsersPage.selectStatusDropDown("Disabled");
        viewSystemUsersPage.clickOnSearchButton();
      //  String actualMessage2 = viewSystemUsersPage.verifyUserShouldBeInResultList();
       // Assert.assertEquals(actualMessage2,"User should be in result list", "Text not displayed");
    }

    @Test (priority = 2, groups = {"sanity", "regression"})
    public void verifyThatAdminShouldDeleteTheUserSuccessFully(){
        searchTheUserCreatedAndVerifyIt();
        viewSystemUsersPage.clickOnCheckBox();
        viewSystemUsersPage.clickOnDeleteButton();
        viewSystemUsersPage.acceptPopUpMessage();
        String actualTextMessage3 = viewSystemUsersPage.verifyRecordSuccessfullyDeletedMessage();
        Assert.assertEquals(actualTextMessage3,"Successfully Deleted", "Text not displayed");
    }

    @Test (priority = 3, groups = {"regression"})
    public void searchTheDeletedUserAndVerifyTheMessageNoRecordFound(){
        loginPage.loginToApplication("Admin", "admin123");
        homePage.clickOnAdminTab();
        String actualMessage = viewSystemUsersPage.verifySystemUsersText();
        Assert.assertEquals(actualMessage,"System Users", "Text not displayed");

        viewSystemUsersPage.enterUserNameField("Ananya1702");
        viewSystemUsersPage.selectUserRoleDropDown("Admin");
        viewSystemUsersPage.selectStatusDropDown("Disabled");
        viewSystemUsersPage.clickOnSearchButton();
        String actualNoRecordsFoundText = viewSystemUsersPage.verifyNoRecordsFoundText();
        Assert.assertEquals(actualNoRecordsFoundText,"No Records Found", "Text not displayed");

    }
}
