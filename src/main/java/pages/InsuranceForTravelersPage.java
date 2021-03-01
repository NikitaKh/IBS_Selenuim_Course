package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class InsuranceForTravelersPage extends BasePage {

    @FindBy(xpath = "//H1[@class='kitt-heading  page-teaser-dict__header kitt-heading_size_l']" +
            "[text()='Страхование путешественников']")
    public WebElement header;

    @FindBy(xpath = "//div[@class='page-teaser-dict__button']//span[@class='kitt-button__text']")
    public WebElement button;

    public InsuranceForTravelersPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }
}
