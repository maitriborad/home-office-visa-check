package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class SelectNationalityPage extends Utility {

    @FindBy(id = "response")
    WebElement nationalityDropDownList;

    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement continueButton;
    public void selectNationality(String nationality){
        selectByVisibleTextFromDropDown(nationalityDropDownList,nationality);
        CustomListeners.test.log(Status.PASS, "Select " + nationality + "From" + nationalityDropDownList);
        Reporter.log("Select " + nationality + "From" + nationalityDropDownList.toString());
    }
    public void clickOnContinue(){
        clickOnElement(continueButton);
        CustomListeners.test.log(Status.PASS, "Click on " + continueButton);
        Reporter.log("Click on " + continueButton.toString());
    }
}
