package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

public class TvCatalogPage extends BasePage {

    @FindBy(xpath = "//SPAN[@class='_1qOETCp-Ym'][text()='Все фильтры']")
    public WebElement wideSearch;

    @FindBy(xpath = "//div[contains(@data-filter-id, 'glprice')]")
    WebElement productPrice;

    @FindBy(xpath = "//div//a[contains(text(), 'Показать')]")
    public WebElement acceptBtn;

    @FindBy(xpath = "//BUTTON")
    WebElement sizeButton;

    @FindBy(xpath = "//div")
    WebElement sizeControl;

    @FindBy(xpath = "//INPUT[@id='header-search']")
    WebElement searchField;

    @FindBy(xpath = "//BUTTON[@type='submit']")
    WebElement searchBtn;

    public TvCatalogPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectPrice(String range, String value) {
        fillField(
                productPrice.findElement(By.xpath("//div[contains(@data-prefix, '" + range + "')]//input")),
                value
        );
    }

    public void selectProductProducer(String producer) {
        ((JavascriptExecutor) BaseSteps.getDriver()).executeScript("return arguments[0].scrollIntoView(true);",
                BaseSteps.getDriver().findElement(By.xpath("//DIV[text()='" + producer + "']")));
        new WebDriverWait(BaseSteps.getDriver(), 5).
                until(ExpectedConditions.visibilityOf(
                        BaseSteps.getDriver().findElement(
                                By.xpath("//DIV[text()='" + producer + "']")))).click();
    }

    public void checkItemsSum(String itemsSum) {

        if (!sizeButton.findElement(By.xpath("//span[contains(text(), 'Показывать по')]")).
                getText().contains(itemsSum)) {
            BaseSteps.getDriver().findElement(By.xpath("//button[@aria-expanded='false']")).click();
            sizeControl.findElement(By.xpath("//button[contains(text(),'Показывать по " + itemsSum + "')]")).click();
        }
        String actualValue = sizeButton.findElement(By.xpath("//span[contains(text(), 'Показывать по')]")).
                getText();
        org.junit.Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualValue, "Показывать по " + itemsSum),
                actualValue.contains("Показывать по " + itemsSum));
    }

    public String setItemInfo(String itemNum) {
        return BaseSteps.getDriver().findElement(
                By.xpath("(//SPAN[@class=''])[" + itemNum + "]")).getText();
    }

    public void searchItem(String itemInfo) {
        fillField(searchField, itemInfo);
        searchBtn.click();
    }

    public String setSearchItemInfo() {
        return BaseSteps.getDriver().findElement(
                By.xpath("(//DIV[@class='_1OAvzJPfIW'])[1]")).getText();
    }

}
