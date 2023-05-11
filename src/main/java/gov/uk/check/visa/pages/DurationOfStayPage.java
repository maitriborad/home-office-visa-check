package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class DurationOfStayPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement continueButton;
    @CacheLookup
    @FindBy(xpath = "//input[@id='response-0']")
    WebElement lessThanSixMonth;
    @CacheLookup
    @FindBy(xpath = "//input[@id='response-1']")
    WebElement moreThanSixMonth;
    public void clickOnContinue(){
        clickOnElement(continueButton);
        CustomListeners.test.log(Status.PASS, "Click on " + continueButton);
        Reporter.log("Click on " + continueButton.toString());
    }
    public void selectLengthOfStay(String duration){
        switch (duration){
            case "6 months or less":
                lessThanSixMonth.click();
                break;
            case "longer than 6 months":
                moreThanSixMonth.click();
                break;
        }
    }
}
