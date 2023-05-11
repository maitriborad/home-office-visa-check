package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class StartPage extends Utility {
    @FindBy(xpath = "//button[@data-accept-cookies='true']")
    WebElement acceptCookies;
    @FindBy(xpath = "//a[normalize-space()='Start now']")
    WebElement startNowButton;
    public void clickStartNow(){
        clickOnElement(startNowButton);
        CustomListeners.test.log(Status.PASS, "Click on " + startNowButton);
        Reporter.log("Click on " + startNowButton.toString());
    }
    public void acceptCookies(){
        clickOnElement(acceptCookies);
        Reporter.log("Click on" + acceptCookies.toString());
        CustomListeners.test.log(Status.PASS, "Click on" + acceptCookies);
    }
}
