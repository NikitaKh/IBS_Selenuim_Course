package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogPage extends BasePage {

    @FindBy(xpath = "//a[contains(@class,'kit-link kit-link_m')]")
    WebElement mainCatalog;

    public CatalogPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectFromCatalog(String catalogItem) {
        mainCatalog.findElement(
                By.xpath("//h3[contains(text(),'" + catalogItem + "')]")).click();
    }
}
