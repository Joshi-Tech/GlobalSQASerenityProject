package actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractions;
import org.openqa.selenium.interactions.Actions;
import pages.HomePage;

import static enums.MenuItemsID.*;

public class HomePageActions extends UIInteractions {
    HomePage homePage;

    public void openPage() {
        homePage.openUrl();
    }

    @Step
    public void hoverOver(String id1, String id2, String id3) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement($(MENU_ITEMS.getId() + id1)).perform();
        actions.moveToElement($(MENU_ITEMS.getId() + id2)).perform();
        actions.moveToElement($(MENU_ITEMS.getId() + id3)).click().perform();
    }

    @Step
    public void hoverOver(String id1, String id2) {
        WebElementFacade testerSHub = $(MENU_ITEMS.getId() + id1 + ">a");
        Actions actions = new Actions(getDriver());
        actions.moveToElement(testerSHub).perform();
        actions.moveToElement($(MENU_ITEMS.getId() + id2)).click().perform();
    }
}
