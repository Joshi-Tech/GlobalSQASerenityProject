package pages;


import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.ExtractString.getString;

public class SamplePage extends PageObject {


    public String getH1Text() {
        return $(getString("locators", "common.h1Text")).getText();
    }

    public void submitUserDetails(String name, String email, String website, String value,
                                  String expertise, String education, String message) {
        WebElement fileUpload = $(getString("locators", "samplePage.addAttachment"));
        fileUpload.sendKeys("C:\\Users\\LaxmiKantJoshi\\Desktop\\GlobalSQA\\GlobalSQASerenityProject\\src\\test\\resources\\attachments\\catPicture.jpg");
        $(getString("locators", "samplePage.nameTextBox")).sendKeys(name);
        $(getString("locators", "samplePage.emailTextBox")).sendKeys(email);
        $(getString("locators", "samplePage.websiteTextBox")).sendKeys(website);
        WebElement dropdown = $(getString("locators", "samplePage.experienceDropdown"));
        Select select = new Select(dropdown);
        select.selectByValue(value);
        Actions actions = new Actions(getDriver());
        List<WebElementFacade> checkBox = $$(getString("locators", "samplePage.checkBox"));
        List<WebElementFacade> checkBoxList = checkBox.stream().filter(x -> x.getText().equals(expertise.trim())).collect(Collectors.toList());
        checkBoxList.get(0).click();
        checkBoxList.get(0).sendKeys(Keys.TAB);
        List<WebElementFacade> educationRadioLabel = $$(getString("locators", "samplePage.educationRadioLabel"));
        $(getString("locators", "samplePage.AlertBox")).click();
        String alertText = getDriver().switchTo().alert().getText();
        assertEquals(getString("pageText", "samplePage.firstAlertText"), alertText);
        getDriver().switchTo().alert().accept();
        String secondAlertText = getDriver().switchTo().alert().getText();
        assertEquals(getString("pageText", "samplePage.secondAlertText"), secondAlertText);
        getDriver().switchTo().alert().accept();
        List<WebElementFacade> educationList = educationRadioLabel.stream().filter(x -> x.getText().equals(education)).collect(Collectors.toList());
        actions.moveToElement(educationList.get(0)).click().perform();
        $(getString("locators", "samplePage.textArea")).sendKeys(message);
        actions.moveToElement($("[type='submit']")).click().perform();
    }

    public String getMessageText() {
        return $(getString("locators", "samplePage.messageSent")).getText();
    }
}
