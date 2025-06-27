package pages;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
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
                () -> assertThat(getDriver().getTitle())
                        .isEqualTo(getString("pageText", "homePage.title")));
    }
}
