package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.ArrayList;

public class MarketPage extends BasePage {

    @FindBy(xpath = "//DIV[@data-zone-name='category-link']")
    WebElement tabList;

    public MarketPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectMarketItem(String catalogItem) {
        ArrayList<String> tabs = new ArrayList<>(BaseSteps.getDriver().getWindowHandles());
        BaseSteps.getDriver().switchTo().window(tabs.get(1));
        tabList.findElement(By.xpath("//div//span[contains(text(),'" + catalogItem + "')]")).click();
    }
}
