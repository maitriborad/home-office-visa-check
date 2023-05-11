package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class WorkTypePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement continueButton;
    @CacheLookup
    @FindBy(name = "response")
    List<WebElement> jobType;
    public void clickOnContinue(){
        clickOnElement(continueButton);
        CustomListeners.test.log(Status.PASS, "Click on " + continueButton);
        Reporter.log("Click on " + continueButton.toString());
    }
    public void selectJobType(String job){
        CustomListeners.test.log(Status.PASS, "Select " + jobType);
        Reporter.log("Select " + jobType.toString());
        List<WebElement> jobOption = getListOfElements(jobType);
        for (int i = 0; i <= jobOption.size(); i++) {
            String val = jobOption.get(i).getAttribute("value");
            if (job.contains(val)) {
                jobOption.get(i).click();
                break;
            }
        }
    }
}
