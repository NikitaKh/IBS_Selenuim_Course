package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendAppPage extends BasePage {

    @FindBy(xpath = "//form//div[@class='container']")
    WebElement firstPage;

    @FindBy(xpath = "//INPUT[@id='surname_vzr_ins_0']")
    WebElement surname;

    @FindBy(xpath = "//INPUT[@id='name_vzr_ins_0']")
    WebElement name;

    @FindBy(xpath = "//INPUT[@id='birthDate_vzr_ins_0']")
    WebElement birthDate;

    @FindBy(xpath = "//INPUT[@id='person_lastName']")
    WebElement lastName;

    @FindBy(xpath = "//INPUT[@id='person_firstName']")
    WebElement firstName;

    @FindBy(xpath = "//INPUT[@id='person_middleName']")
    WebElement middleName;

    @FindBy(xpath = "//INPUT[@id='person_birthDate']")
    WebElement personBirthDate;

    @FindBy(xpath = "//div[contains(@class, 'btn-group')]")
    WebElement gender;

    @FindBy(xpath = "//INPUT[@id='passportSeries']")
    WebElement passportSeries;

    @FindBy(xpath = "//INPUT[@id='passportNumber']")
    WebElement passportNumber;

    @FindBy(xpath = "//INPUT[@id='documentDate']")
    WebElement documentDate;

    @FindBy(xpath = "//INPUT[@id='documentIssue']")
    WebElement issuer;

    public SendAppPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void insuranceSum(String value) {
        firstPage.findElement(By.xpath("//h3[contains(text(),'"
                + value + "')]")).click();
    }

    public void issueButton(String buttonName) {
        WebDriverWait wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(),'" + buttonName + "')]"))).click();
    }

    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "Фамилия":
                fillField(surname, value);
                new WebDriverWait(driver, 2, 1000).
                        until(ExpectedConditions.visibilityOf(lastName)).click();
                fillField(lastName, value);
                break;
            case "Имя":
                fillField(name, value);
                new WebDriverWait(driver, 2, 1000).
                        until(ExpectedConditions.visibilityOf(firstName)).click();
                fillField(firstName, value);
                break;
            case "Отчество":
                fillField(middleName, value);
                break;
            case "Дата рождения":
                fillField(birthDate, value);
                new WebDriverWait(driver, 2, 1000).
                        until(ExpectedConditions.visibilityOf(personBirthDate));
                fillField(personBirthDate, value);
                break;
            case "Серия":
                fillField(passportSeries, value);
                break;
            case "Номер":
                fillField(passportNumber, value);
                break;
            case "Дата выдачи":
                fillField(documentDate, value);
                break;
            case "Кем выдан":
                issuer.click();
                fillField(issuer, value);
                break;
            case "Пол":
                gender.findElement(By.xpath("//label[contains(text(),'" + value + "')]")).click();
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }

    public void checkField(String fieldName, String value) {
        switch (fieldName) {
            case "Фамилия":
                checkFillField(surname, value);
                new WebDriverWait(driver, 2, 1000).
                        until(ExpectedConditions.visibilityOf(lastName)).click();
                checkFillField(lastName, value);
                break;
            case "Имя":
                checkFillField(name, value);
                new WebDriverWait(driver, 2, 1000).
                        until(ExpectedConditions.visibilityOf(firstName)).click();
                checkFillField(firstName, value);
                break;
            case "Отчество":
                checkFillField(middleName, value);
                break;
            case "Дата рождения":
                checkFillField(birthDate, value);
                new WebDriverWait(driver, 2, 1000).
                        until(ExpectedConditions.visibilityOf(personBirthDate));
                checkFillField(personBirthDate, value);
                break;
            case "Серия":
                checkFillField(passportSeries, value);
                break;
            case "Номер":
                checkFillField(passportNumber, value);
                break;
            case "Дата выдачи":
                checkFillField(documentDate, value);
                break;
            case "Кем выдан":
                issuer.click();
                checkFillField(issuer, value);
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }

    public void checkFieldErrorMessage(String errorMessage) {
        String actualValue;

        switch (errorMessage) {
            case "Поле не заполнено":
                actualValue = driver.findElement(By.cssSelector(".was-validated")).getText();
                org.junit.Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualValue, errorMessage),
                        actualValue.contains(errorMessage));
                break;
            case "При заполнении данных произошла ошибка":
                actualValue = driver.findElement(
                        By.cssSelector(".alert-form-error")).getText();
                org.junit.Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualValue, errorMessage),
                        actualValue.contains(errorMessage));
                break;
            default:
                throw new AssertionError("Ошибки '" + errorMessage + "' не объявлено на странице");
        }
    }
}
