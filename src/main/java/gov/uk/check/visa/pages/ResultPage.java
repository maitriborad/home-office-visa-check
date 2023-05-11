package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

public class ResultPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h2[@class='gem-c-heading gem-c-heading--font-size-27 govuk-!-margin-bottom-6']")
    WebElement resultMessage;
    public String getResultMessage(){
        CustomListeners.test.log(Status.PASS, "Get message " + resultMessage);
        Reporter.log("Get message " + resultMessage.toString());
       return getTextFromElement(resultMessage);
    }
    public void confirmResultMessage(String expectedMessage){
        Assert.assertEquals(getResultMessage(),expectedMessage,"Something wrong in message");
        CustomListeners.test.log(Status.PASS, "compare message " + expectedMessage);
        Reporter.log("Compare message " + expectedMessage.toString());
    }
}
