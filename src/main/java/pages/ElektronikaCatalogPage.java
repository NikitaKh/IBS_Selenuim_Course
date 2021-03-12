package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class ElektronikaCatalogPage extends BasePage {

    @FindBy(xpath = "//div[2]/div[2]/div/div/div/div[1]")
    WebElement subItems;

    public ElektronikaCatalogPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public String selectProductType(String productItem) {
        subItems.findElement(By.xpath("//div/div/div/div/div/div/div[*]/div[1]/a[contains(text(),'" + productItem + "')]")).click();
        return productItem;
    }
}
