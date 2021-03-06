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

    @FindBy(xpath = "(//INPUT[@class='_34OG20yGDA'])[1]")
    WebElement expandProducers;

    @FindBy(xpath = "//div//a[contains(text(), 'Показать')]")
    public WebElement acceptBtn;

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
        fillField(expandProducers, producer);
        new WebDriverWait(BaseSteps.getDriver(), 5).
                until(ExpectedConditions.visibilityOf(
                        BaseSteps.getDriver().findElement(
                                By.xpath("//DIV[text()='" + producer + "']")))).click();
    }

    public void checkItemsSum(String itemsSum) {
        int recordsCount = BaseSteps.getDriver().findElements(By.xpath("(//DIV[@class='_1OAvzJPfIW'])[*]")).size();
        if (recordsCount < 12) {
            org.junit.Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", recordsCount, itemsSum),
                    String.valueOf(recordsCount).contains(itemsSum));
        }
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
                By.xpath("(//DIV[@class='_1OAvzJPfIW'])[1]//h3//span")).getText();
    }

}
