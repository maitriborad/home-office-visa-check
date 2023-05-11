package gov.uk.check.visa.testsuite;

import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.pages.*;
import gov.uk.check.visa.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class VisaConfirmationTest extends BaseTest {
    DurationOfStayPage durationOfStayPage;
    FamilyImmigrationStatusPage familyImmigrationStatusPage;
    ReasonForTravelPage reasonForTravelPage;
    ResultPage resultPage;
    SelectNationalityPage selectNationalityPage;
    StartPage startPage;
    WorkTypePage workTypePage;
    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        durationOfStayPage=new DurationOfStayPage();
        familyImmigrationStatusPage=new FamilyImmigrationStatusPage();
        reasonForTravelPage=new ReasonForTravelPage();
        resultPage=new ResultPage();
        selectNationalityPage=new SelectNationalityPage();
        startPage=new StartPage();
        workTypePage=new WorkTypePage();
    }
    @Test(groups = {"sanity","regression"})
    public void anAustralianComingToUKForTourism() {
        startPage.acceptCookies();
        startPage.clickStartNow();
        selectNationalityPage.selectNationality("Australia");
        selectNationalityPage.clickOnContinue();
        reasonForTravelPage.selectReasonForTravel("tourism or visiting family and friends");
        reasonForTravelPage.clickOnContinue();
        resultPage.confirmResultMessage("You will not need a visa to come to the UK");
    }
    @Test(groups = {"smoke","regression"})
    public void aChileanComingToTheUKForWorkAndPlansOnStayingForLongerThanSixMonths(){
        startPage.acceptCookies();
        startPage.clickStartNow();
        selectNationalityPage.selectNationality("Chile");
        selectNationalityPage.clickOnContinue();
        reasonForTravelPage.selectReasonForTravel("work, academic visit or business");
        reasonForTravelPage.clickOnContinue();
        durationOfStayPage.selectLengthOfStay("longer than 6 months");
        durationOfStayPage.clickOnContinue();
        workTypePage.selectJobType("health and care professional");
        workTypePage.clickOnContinue();
        resultPage.confirmResultMessage("You need a visa to work in health and care");
    }
    @Test(groups = {"regression"})
    public void aColumbianNationalComingToTheUKToJoinAPartnerForALongStayTheyDoHaveAnArticle10Or20Card(){
         startPage.acceptCookies();
         startPage.clickStartNow();
         selectNationalityPage.selectNationality("Colombia");
         selectNationalityPage.clickOnContinue();
         reasonForTravelPage.selectReasonForTravel("Join partner or family for a long stay");
         reasonForTravelPage.clickOnContinue();
         //familyImmigrationStatusPage.selectImmigrationStatus("yes");
         //familyImmigrationStatusPage.clickOnContinue();
         resultPage.confirmResultMessage("You may need a visa");
    }
}
