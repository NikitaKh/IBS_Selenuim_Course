import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.*;

import java.util.HashMap;

public class AllureReportTask3 extends BaseSteps {

    @Test
    @Title("Страхование путешественников \"Сбербанк\"")
    public void allureInsuranceTest() {
        driver.get(baseUrl + "/");
        MainSteps mainSteps = new MainSteps();
        CatalogSteps catalogSteps = new CatalogSteps();
        InsuranceSteps insuranceSteps = new InsuranceSteps();
        SendAppSteps sendAppSteps = new SendAppSteps();

        HashMap<String, String> testData = new HashMap<String, String>() {
            {
                put("Фамилия", "Привет");
                put("Имя", "Петр");
                put("Отчество", "Сергеевич");
                put("Дата рождения", "10.03.1980");
                put("Пол", "Мужской");
                put("Серия", "5515");
                put("Номер", "122323");
                put("Дата выдачи", "15.05.2015");
                put("Кем выдан", "УФМС РОССИИ");
            }
        };

        /** Дейстивия на главной странице */
        mainSteps.closeCookieWarning();
        mainSteps.selectMainMenuItem("Страхование");
        mainSteps.selectSubMenuItem("Перейти в каталог");

        /** Действия на странице "Каталога" */
        catalogSteps.selectCatalogItem("Страхование для путешественников");

        /** Действия на странице "Страхование для путешественников" */
        insuranceSteps.insurancePageTitle("Страхование путешественников");
        insuranceSteps.clickInsurancePageBtn();

        /** Действия на странице 'Выбор полиса' */
        sendAppSteps.chooseInsuranceSum("Минимальная");
        sendAppSteps.pressTheBtn("Оформить");

        /** Действия на странице 'Оформление' */
        sendAppSteps.fillFieldsStep(testData);
        sendAppSteps.checkFillFields(testData);
        sendAppSteps.pressTheBtn("Продолжить");
        sendAppSteps.errorFieldCheck("Поле не заполнено");
        sendAppSteps.errorFieldCheck("При заполнении данных произошла ошибка");
    }
}
