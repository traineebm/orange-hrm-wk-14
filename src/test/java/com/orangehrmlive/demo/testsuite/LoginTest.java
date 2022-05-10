package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.AddUserPage;
import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.pages.ViewSystemUsersPage;
import com.orangehrmlive.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    ViewSystemUsersPage viewSystemUsersPage;
    AddUserPage addUserPage;

    @BeforeMethod(groups = {"sanity","smoke","regression"})
    public void initialize(){
        homePage = new HomePage();
        loginPage = new LoginPage();
        viewSystemUsersPage = new ViewSystemUsersPage();
        addUserPage = new AddUserPage();
    }

    @Test(groups = {"smoke","regression"})
    public void verifyUserShouldLoginSuccessFully(){
        loginPage.loginToApplication("Admin","admin123");
        String actualMessage = homePage.verifyWelcomeText();
        Assert.assertEquals(actualMessage,"Welcome", "Login page not displayed");
    }

    @Test (priority = 1, groups = {"sanity", "regression"})
    public void VerifyThatTheLogoDisplayOnHomePage(){
        loginPage.loginToApplication("Admin", "admin123");
        homePage.verifyOrangeHrmLogoIsVisible();
    }

    @Test (priority = 2, groups = {"regression"})
    public void VerifyUserShouldLogOutSuccessFully(){
        loginPage.loginToApplication("Admin", "admin123");
        homePage.clickOnProfileLogo();
        homePage.clickOnLogout();
    }
}
