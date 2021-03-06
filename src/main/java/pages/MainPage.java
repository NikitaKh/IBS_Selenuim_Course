package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class MainPage extends BasePage {

    @FindBy(xpath = "//DIV[@class='col main widgets']")
    WebElement mainWidgets;

    public MainPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectMenuItem(String menuItem) {
        mainWidgets.findElement(
                By.xpath("//DIV[@class='services-new__item-title'][text()='" + menuItem + "']")).click();
    }
}
