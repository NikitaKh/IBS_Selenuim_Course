package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

public class ElektronikaCatalogPage extends BasePage {

    public ElektronikaCatalogPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectProductType(String productItem) {
        new WebDriverWait(BaseSteps.getDriver(), 5).
                until(ExpectedConditions.visibilityOf(
                        BaseSteps.getDriver().findElement(By.xpath("//A[text()='" +
                                productItem + "']")))).click();
    }
}
