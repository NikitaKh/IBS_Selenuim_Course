import org.junit.Test;
import pages.CatalogPage;
import pages.InsuranceForTravelersPage;
import pages.MainPage;
import pages.SendAppPage;

public class MyRefactoringTest extends BaseTest {

    @Test
    public void newInsuranceTest() {
        driver.get(baseUrl + "/");
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenu("Страхование");
        mainPage.selectSubMenu("Перейти в каталог");

        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.selectFromCatalog("Страхование для путешественников");

        new InsuranceForTravelersPage(driver).assertAndClick();

        SendAppPage sendAppPage = new SendAppPage(driver);

        /** Страница "Выбор полиса" */
        sendAppPage.insuranceSum("Минимальная");
        sendAppPage.issueButton("Оформить");

        /** Заполнение страницы "Оформление" */
        sendAppPage.fillField("Фамилия", "Привет");
        sendAppPage.fillField("Имя", "Петр");
        sendAppPage.fillField("Отчество", "Сергеевич");
        sendAppPage.fillField("Дата рождения", "10.03.1980");
        sendAppPage.fillField("Пол", "Мужской");
        sendAppPage.fillField("Серия", "5515");
        sendAppPage.fillField("Номер", "123456");
        sendAppPage.fillField("Дата выдачи", "15.05.2015");
        sendAppPage.fillField("Кем выдан", "УФМС РОССИИ");

        /** Проверка страницы "Оформление" */
        sendAppPage.checkField("Фамилия", "Привет");
        sendAppPage.checkField("Имя", "Петр");
        sendAppPage.checkField("Отчество", "Сергеевич");
        sendAppPage.checkField("Дата рождения", "10.03.1980");
        sendAppPage.checkField("Серия", "5515");
        sendAppPage.checkField("Номер", "123456");
        sendAppPage.checkField("Дата выдачи", "15.05.2015");
        sendAppPage.checkField("Кем выдан", "УФМС РОССИИ");

        sendAppPage.issueButton("Продолжить");

        sendAppPage.checkFieldErrorMessage("Поле не заполнено");
        sendAppPage.checkFieldErrorMessage("При заполнении данных произошла ошибка");

    }
}
