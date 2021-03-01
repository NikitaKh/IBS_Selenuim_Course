package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InsuranceForTravelersPage extends BasePage {

    @FindBy(xpath = "//H1[@class='kitt-heading  page-teaser-dict__header kitt-heading_size_l']" +
            "[text()='Страхование путешественников']")
    WebElement header;

    @FindBy(xpath = "//div[@class='page-teaser-dict__button']//span[@class='kitt-button__text']")
    WebElement button;

    public InsuranceForTravelersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void assertAndClick() {
        WebDriverWait wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(header));
        wait.until(ExpectedConditions.visibilityOf(button)).click();
    }
}
