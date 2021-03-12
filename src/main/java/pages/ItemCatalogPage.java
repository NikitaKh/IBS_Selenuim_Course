package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

public class ItemCatalogPage extends BasePage {

    @FindBy(xpath = "//SPAN[@class='_1qOETCp-Ym'][text()='Все фильтры']")
    WebElement wideSearch;

    @FindBy(xpath = "//div[contains(@data-filter-id, 'glprice')]")
    WebElement productPrice;

    @FindBy(xpath = "//section/div[2]/div/div/div[2]/div[1]/div[5]/div/div/div/button")
    WebElement expandProducers;

    @FindBy(xpath = "//div//a[contains(text(), 'Показать')]")
    public WebElement acceptBtn;

    @FindBy(xpath = "//INPUT[@id='header-search']")
    WebElement searchField;

    @FindBy(xpath = "//BUTTON[@type='submit']")
    WebElement searchBtn;

    public ItemCatalogPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectWideSearch(String selectedItem) {
        try {
            wideSearch.click();
        } catch (NoSuchElementException e) {
            ((JavascriptExecutor) BaseSteps.getDriver()).executeScript("arguments[0].click()",
                    BaseSteps.getDriver().findElement(
                            By.xpath("//div[2]/div/div/div/div[*]/div/div/div/div" +
                                    "/div/div/div[*]/div/a[contains(text(),'" + selectedItem + "')]")));
            wideSearch.click();
        }
    }

    public void selectPrice(String range, String value) {
        fillField(
                productPrice.findElement(By.xpath("//div[contains(@data-prefix, '" + range + "')]//input")),
                value
        );
        ((JavascriptExecutor) BaseSteps.getDriver()).executeScript("return arguments[0].scrollIntoView(true);",
                expandProducers);
        expandProducers.click();
    }

    public void selectProductProducer(String producer) {
        ((JavascriptExecutor) BaseSteps.getDriver()).executeScript("return arguments[0].scrollIntoView(true);",
                BaseSteps.getDriver().findElement(By.xpath("//DIV[text()='" + producer + "']")));
        new WebDriverWait(BaseSteps.getDriver(), 5).
                until(ExpectedConditions.visibilityOf(
                        BaseSteps.getDriver().findElement(
                                By.xpath("//div[text()='" + producer + "']")))).click();
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
                By.xpath("//article[" + itemNum + "]//h3[@data-zone-name='title']//span")).getText();
    }

    public void searchItem(String itemInfo) {
        fillField(searchField, itemInfo);
        searchBtn.click();
    }

    public String setSearchItemInfo() {
        return BaseSteps.getDriver().findElement(
                By.xpath("//article[1]//h3[@data-zone-name='title']//a")).getText();
    }

}
