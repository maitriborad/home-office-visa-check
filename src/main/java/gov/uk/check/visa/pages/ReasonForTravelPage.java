package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class ReasonForTravelPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement continueButton;
    @FindBy(name = "response")
    List<WebElement> reasonForVisitList;
    public void clickOnContinue(){
        clickOnElement(continueButton);
        CustomListeners.test.log(Status.PASS, "Click on " + continueButton);
        Reporter.log("Click on " + continueButton.toString());
    }
    public void selectReasonForTravel(String reason) {
        CustomListeners.test.log(Status.PASS, "Select " + reasonForVisitList);
        Reporter.log("Select " + reasonForVisitList.toString());
        List<WebElement> reasonOption = getListOfElements(reasonForVisitList);
        for (int i = 0; i <= reasonOption.size(); i++) {
            String val = reasonOption.get(i).getAttribute("value");
            if (reason.contains(val)) {
                reasonOption.get(i).click();
                break;
            }
        }
    }
}
