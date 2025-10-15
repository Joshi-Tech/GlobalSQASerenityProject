package pages;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import java.util.stream.Collectors;

import static util.ExtractString.getString;

public class DatePickerPage extends PageObject {

    @Step
    public void simpleDatePicker(String monthAndYear) {
        WebElement frameElement = $(getString("locators", "datePicker.frame"));
        getDriver().switchTo().frame(frameElement);
        $(getString("locators", "dateTextBox.id")).click();
        while (!$(getString("locators", "datePicker.title")).getText().equals(monthAndYear)) {
            $(getString("locators", "datePicker.nextButton")).click();
        }
    }

    public void selectDate(String date) {
        $$(getString("locators", "datePicker.date"))
                .stream().filter(x -> x.getText().equals(date))
                .toList()
                .get(0)
                .click();
    }

    public String getDate() {
        return $(getString("locators", "dateTextBox.id")).getValue();
    }

    public String getH1(){
        return $(getString("locators", "common.h1Text")).getText();
    }
}
