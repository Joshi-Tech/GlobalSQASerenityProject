package runner.stepDef;

import actions.HomePageActions;
import com.github.javafaker.Faker;
import hook.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import pages.DatePickerPage;
import pages.DialogBoxPage;
import pages.SamplePage;

import static enums.MenuItemsID.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.ExtractString.getString;

public class StepDefinition extends Hook {

    @Steps
    HomePageActions homePageActions;

    @Steps
    DatePickerPage datePickerPage;

    @Steps
    DialogBoxPage dialogBoxPage;

    @Steps
    SamplePage samplePage;

    @Steps
    Faker faker;

    @Given("I go the home page")
    public void i_go_the_home_page() {
        homePageActions.openPage();
    }

    @Given("User is on {string} page")
    public void user_is_on_page(String page) {
        homePageActions.openPage();
        switch (page) {
            case "DatePicker":
                homePageActions.hoverOver(TESTERS_HUB.getId(), DEMO_TESTING_SITE.getId(), DATE_PICK.getId());
                break;
            case "Dialog Box":
                homePageActions.hoverOver(TESTERS_HUB.getId(), DEMO_TESTING_SITE.getId(), DIALOG_BOX.getId());
                break;
            case "Sample Page":
                homePageActions.hoverOver(TESTERS_HUB.getId(), SAMPLE_PAGE_LINK.getId());
                break;
            default:
                throw new RuntimeException("Page not found");
        }
    }

    @When("they click create user button")
    public void they_click_create_user_button() {
        dialogBoxPage.clickCreateUserButton();
    }

    @When("they provide name {string}, email {string} and password {string}")
    public void they_provide_name_email_and_password(String userName, String email, String password) {
        dialogBoxPage.userDetails(userName, email, password);
    }

    @When("they select month {string} year {string}")
    public void they_select_month_year(String month, String year) {
        datePickerPage.simpleDatePicker(month + " " + year);
    }

    @When("they select date {string}")
    public void they_select_date(String date) {
        datePickerPage.selectDate(date);
    }

    @When("I click {string} link within Tester's Hub")
    public void i_click_link_within_tester_s_hub(String link) {
        switch (link) {
            case "Date Picker":
                homePageActions.hoverOver(TESTERS_HUB.getId(), DEMO_TESTING_SITE.getId(), DATE_PICK.getId());
                break;
            case "Alert":
                homePageActions.hoverOver(TESTERS_HUB.getId(), DEMO_TESTING_SITE.getId(), ALERT_BOX.getId());
                break;
            case "Sample Page":
                homePageActions.hoverOver(TESTERS_HUB.getId(), SAMPLE_PAGE_LINK.getId());
                break;
            default:
                throw new RuntimeException("Page not found");
        }
    }

    @When("I complete the Sample Page")
    public void i_complete_the_sample_page() {
        samplePage.submitUserDetails(faker.name().name(), faker.internet().emailAddress(), "https://" + faker.internet().domainName(),
                "7-10", "Automation Testing", "Graduate", "Example Text");
    }

    @Then("I can see text {string}")
    public void i_can_see_text(String message) {
        assertEquals(message, samplePage.getMessageText());
    }

    @Then("I'll be able to see heading {string}")
    public void i_ll_be_able_to_see_heading(String text) {
        switch (text) {
            case "DatePicker":
                Serenity.reportThat("Date picker page is open",
                        () -> assertEquals(text, datePickerPage.getH1()));
                break;
            case "Sample Page Test":
                Serenity.reportThat("Sample page is open",
                        () -> assertEquals(text, samplePage.getH1Text()));
                break;
            case "AlertBox":
                Serenity.reportThat("AlertBox page is open",
                        () -> assertEquals(text, samplePage.getH1Text()));
                break;
            default:
                throw new RuntimeException("Page not found");
        }
    }

    @Then("they will have date as {string}")
    public void they_will_have_date_as(String expectedDate) {
        assertEquals(expectedDate, datePickerPage.getDate());
    }

    @Then("they can see user name {string}")
    public void they_can_see_user_name(String userName) {
        assertEquals(getString("pageText", "person.name"), dialogBoxPage.getUserDetails(userName));
    }

    @Then("they can see user name {string} in the existing users list")
    public void they_can_see_user_name_in_the_existing_users_list(String userName) {
        assertEquals(userName, dialogBoxPage.getUserDetails("Ram Singh"));
    }


    @When("they click on {string} tab")
    public void they_click_on_tab(String tab) {
        dialogBoxPage.clickOnTab(tab);
    }

    @Then("they can see for {string} message {string}")
    public void they_can_see_for_message(String tab, String message) {
        assertEquals(message, dialogBoxPage.getEmptyRecycleBinBoxText(tab));
    }
}
