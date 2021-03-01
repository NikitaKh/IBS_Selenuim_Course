import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class InsuranceTest {

    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {

        /**
         * Вызов драйвера из папки drv
         */
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver");

        baseUrl = "https://www.sberbank.ru/ru/person";  //осноовной url

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void testInsurance() {

        WebDriverWait wait = new WebDriverWait(driver, 5, 5000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        /**
         * Нажать на "Страхование"
         */
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("(//A[@role='button'])[11]")).click();


        /**
         * Нажать на "Перейти в каталог"
         */
        driver.findElement(
                By.xpath("//A[@class='kitt-top-menu__link kitt-top-menu__link_second'][text()='Перейти в каталог']"))
                .click();


        /**
         * Проверка на соответствие
         */
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//H3[@class='uc-full__header'][text()='Страхование для путешественников']"))));
        driver.findElement(By.xpath("//H3[@class='uc-full__header'][text()='Страхование для путешественников']"));

        /**
         * Нажать на "Оформить онлайн"
         */
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(
                By.xpath("(//B[@class='kit-button__text'][text()='Оформить онлайн'][text()='Оформить онлайн'])[2]"))));

        jse.executeScript("arguments[0].click()", driver.findElement(
                By.xpath("(//B[@class='kit-button__text'][text()='Оформить онлайн'][text()='Оформить онлайн'])[2]")));

        /**
         * Нажать на "Минимальный" пакет
         */
        driver.findElement(By.xpath("//P[@_ngcontent-c11=''][text()='Необходимый минимум для оплаты медицинской помощи за границей']")).click();

        /**
         * Нажать "Оформить"
         */
        wait.until((ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//BUTTON[@class='btn btn-primary btn-large'][text()='Оформить']")))));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//BUTTON[@class='btn btn-primary btn-large'][text()='Оформить']"))).click();

        /**
         * Заполнение полей
         */
        String name = "Петр";
        String surName = "Петров";
        String secondName = "Петрович";
        String birth = "10.03.1995";

        String series = "4545";
        String num = "121121";
        String dateOfIssue = "10.03.2015";
        String issuer = "УФМС РОССИИ";

        fillField(By.xpath("//INPUT[@id='surname_vzr_ins_0']"), surName);

        fillField(By.xpath("//INPUT[@id='name_vzr_ins_0']"), name);

        fillField(By.xpath("//INPUT[@id='birthDate_vzr_ins_0']"), birth);

        driver.findElement(By.xpath("//INPUT[@id='person_lastName']")).click();
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//INPUT[@id='person_lastName']"))));
        fillField(By.xpath("//INPUT[@id='person_lastName']"), surName);

        fillField(By.xpath("//INPUT[@id='person_firstName']"), name);

        fillField(By.xpath("//INPUT[@id='person_middleName']"), secondName);

        fillField(By.xpath("//INPUT[@id='person_birthDate']"), birth);

        driver.findElement(By.xpath("//INPUT[@id='person_middleName']")).click();
        driver.findElement(By.xpath("//LABEL[@class='btn ng-untouched ng-pristine ng-valid active'][text()='Мужской']")).click();

        fillField(By.xpath("//INPUT[@id='passportSeries']"), series);

        fillField(By.xpath("//INPUT[@id='passportNumber']"), num);

        fillField(By.xpath("//INPUT[@id='documentDate']"), dateOfIssue);

        driver.findElement(By.xpath("//INPUT[@id='documentIssue']")).click();
        fillField(By.xpath("//INPUT[@id='documentIssue']"), issuer);

        /**
         * Проверка заполненных полей
         */
        assertion(By.xpath("//INPUT[@id='surname_vzr_ins_0']"), surName);
        assertion(By.xpath("//INPUT[@id='name_vzr_ins_0']"), name);
        assertion(By.xpath("//INPUT[@id='birthDate_vzr_ins_0']"), birth);
        assertion(By.xpath("//INPUT[@id='person_lastName']"), surName);
        assertion(By.xpath("//INPUT[@id='person_firstName']"), name);
        assertion(By.xpath("//INPUT[@id='person_middleName']"), secondName);
        assertion(By.xpath("//INPUT[@id='person_birthDate']"), birth);
        assertion(By.xpath("//INPUT[@id='passportSeries']"), series);
        assertion(By.xpath("//INPUT[@id='passportNumber']"), num);
        assertion(By.xpath("//INPUT[@id='documentDate']"), dateOfIssue);
        assertion(By.xpath("//INPUT[@id='documentIssue']"), issuer);

        /**
         * Нажать "Продолжить"
         */
        wait.until((ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".btn-primary")))));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-primary"))).click();

        /**
         * Проверка ответов
         */
        assertEquals("При заполнении данных произошла ошибка",
                driver.findElement(By.cssSelector(".alert-form")).getText());
        assertEquals("Поле не заполнено.",
                driver.findElement(By.cssSelector(".form-control__message")).getText());

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    private void fillField(By locator, String value) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    private void assertion(By locator, String value) {
        assertEquals(value, driver.findElement(locator).getAttribute("value"));
    }
}
