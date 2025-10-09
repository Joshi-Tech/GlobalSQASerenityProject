package pages;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import java.util.stream.Collectors;

import static util.ExtractString.getString;

public class DialogBoxPage extends PageObject {

    @Step
    public String getUserDetails(String user) {
        WebElement frameElement = $(getString("locators", "dialogueBox.frame"));
        getDriver().switchTo().frame(frameElement);
        ListOfWebElementFacades userDetails = $$(getString("locators", "dialogueBox.userDetails"));
        return userDetails.stream().filter(x -> x.getText().equals(user)).collect(Collectors.toList())
                .get(0).getText();
    }

    public void clickCreateUserButton() {
        WebElement frameElement = $(getString("locators", "dialogueBox.frame"));
        getDriver().switchTo().frame(frameElement);
        $(getString("locators", "dialogueBox.createUserButton")).click();
    }

    public void userDetails(String name, String email, String password) {
        $(getString("locators", "dialogueBox.userName")).clear();
        $(getString("locators", "dialogueBox.userName")).sendKeys(name);
        $(getString("locators", "dialogueBox.userEmail")).clear();
        $(getString("locators", "dialogueBox.userEmail")).sendKeys(email);
        $(getString("locators", "dialogueBox.userPassword")).clear();
        $(getString("locators", "dialogueBox.userPassword")).sendKeys(password);
        $$(getString("locators", "dialogueBox.createAccountButton")).stream()
                .filter(x -> x.getText().equals("Create an account"))
                .toList().get(0).click();
        getDriver().switchTo().parentFrame();
    }

    public String clickOnTab(String tab) {
        WebElement tabName = $("[id='" + tab + "']");
        tabName.click();
        String confirmationText = tabName.getText();
        if (tab.equals(getString("pageText", "Confirmation.Box"))) {
            WebElement confirmationFrame = $(getString("locators", "dialogueBox.confirmationFrame"));
            getDriver().switchTo().frame(confirmationFrame);
        } else {
            WebElement dialogueMessageFrame = $(getString("locators", "dialogue.dialogueMessageFrame"));
            getDriver().switchTo().frame(dialogueMessageFrame);
        }
        return confirmationText;
    }

    public String getEmptyRecycleBinBoxText(String tab) {
        if (tab.equals(getString("pageText", "Confirmation.Box"))) {
            return $(getString("locators", "dialogue.confirmationBoxText")).getText();
        } else {
            return $$(getString("locators", "dialogue.messageBoxText")).get(0).getText();
        }
    }
}
