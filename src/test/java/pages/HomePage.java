package pages;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;

import static util.ExtractString.getString;

public class HomePage extends PageObject {

    public void openUrl() {
        String url = getString("pageText", "baseUrl");
        openUrl(url);
        getDriver().manage().window().maximize();
        if (find(By.xpath(getString("locators", "consentButton"))).isPresent()) {
            $(getString("locators", "consentButton")).click();
        } else {
            //do nothing
        }
        Serenity.reportThat("Global SQA home page opens: ",
                () -> Assert.assertEquals(getString("pageText", "homePage.title"), getDriver().getTitle()));
    }
}
