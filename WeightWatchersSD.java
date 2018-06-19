package stepdefinition;

import com.google.common.base.Verify;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.WeightWatchersPage;
import org.testng.Assert;

/**
 * Created by Leonela on 6/11/2018.
 */
public class WeightWatchersSD {

    private WeightWatchersPage weigthWatchersPage = new WeightWatchersPage();


    @Given("^I am on weigthWatchers home page$")
    public void iAmOnHomePage() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Weight Loss Program, Recipes & Help | Weight Watchers", "Invalid Home Page");
    }

    @When("^I click on findMeeting a findMeetingwindow will appear$")
    public void iClickOnFindMeeting() {

        weigthWatchersPage.findMeetingLocation();
    }


    @And("^I verify the page title contains Get Schedules & Times Near You$")

    public void verifyGetMeetingPage() throws Throwable {
        Assert.assertTrue(SharedSD.getDriver().getTitle().contains("Find A Meeting: Get Schedules & Times Near You"));
    }

    @And("^I enter Zipcode on meeting search textbox$")

    public void findMeetingLocation() throws Throwable {
        weigthWatchersPage.enterzipcode();
        Thread.sleep(2000);
    }


    @And("^I click on searchBox to get the location nearby$")
    public void searchLocationMeeting () throws Throwable {
        weigthWatchersPage.searchLocation();
           }

    @And("^I click on the firstLocationOption and print first location$")
    public void getFirstLocationOption () throws Throwable{
        weigthWatchersPage.clickOnFirstOption();
        Thread.sleep(2000);

    }
    @And("^I get hours of operation$")
    public void getHoursOfOperation() throws Throwable{

        weigthWatchersPage.todaysDay();


    }
    @And("^I verify the first selection$")
    public void verifylocation() throws Throwable {
        Assert.assertEquals(weigthWatchersPage.confirmMeetingLocation(), weigthWatchersPage.getFirstOption());
        System.out.println("Location Confirmed");

        Thread.sleep(2000);
    }







}
