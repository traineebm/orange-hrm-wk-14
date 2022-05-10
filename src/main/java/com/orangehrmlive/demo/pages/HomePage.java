package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Utility {


    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//body/div[@id='wrapper']/div[@id='branding']/a[1]/img[1]")
    WebElement orangeHrmLogoText;

    @FindBy(id = "menu_admin_viewAdminModule")
    WebElement adminTab;

    @FindBy(xpath = "//b[contains(text(),'PIM')]")
    WebElement pimTab;

    @FindBy(xpath = "//b[contains(text(),'Leave')]")
    WebElement leaveTab;

    @FindBy(xpath = "//b[contains(text(),'Dashboard')]")
    WebElement dashboardTab;

    @FindBy(xpath = "//a[@id='welcome']")
    WebElement welcomeText;

    @FindBy(id = "welcome")
    WebElement profileLogo;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    WebElement logout;


    public String verifyOrangeHrmLogoIsVisible(){
        return getTextFromElement(orangeHrmLogoText);
    }

    public void clickOnAdminTab(){
        clickOnElement(adminTab);
    }

    public void clickOnPimTab(){
        clickOnElement(pimTab);
    }


    public void clickOnLeaveTab(){
        clickOnElement(leaveTab);
    }

    public void clickOnDashboardTab(){
        clickOnElement(dashboardTab);
    }

    public String verifyWelcomeText(){
        return getTextFromElement(welcomeText);
    }

    public void clickOnProfileLogo(){
        clickOnElement(profileLogo);
    }

    public void clickOnLogout() {
        mouseHoverToElementAndClick(logout);
    }
}
