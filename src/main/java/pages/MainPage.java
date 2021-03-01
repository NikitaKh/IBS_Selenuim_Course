package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    @FindBy(xpath = "//ul[contains(@class,'kitt-top-menu')]")
    WebElement mainMenu;

    @FindBy(xpath = "//DIV[contains(@class,' kitt-top-menu__column kitt-top-menu__column_3  ')]")
    WebElement subMenu;

    @FindBy(xpath = "//BUTTON[@class='kitt-cookie-warning__close'][text()='Закрыть']")
    public WebElement cookie;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        cookie.click();
    }

    public void selectMainMenu(String menuItem) {
        mainMenu.findElement(By.xpath("//li/*[text()='" + menuItem + "']")).click();
    }

    public void selectSubMenu(String menuItem) {
        subMenu.findElement(By.xpath("//ul/li/*[text()='" + menuItem + "']")).click();
    }
}