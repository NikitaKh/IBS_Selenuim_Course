package steps;

import pages.InsuranceForTravelersPage;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertTrue;

public class InsuranceSteps {

    @Step("Заголовок страницы 'Страхование для путешественников' равен - {0}")
    public void insurancePageTitle(String expectedTitle) {
        String actualTitle = new InsuranceForTravelersPage().header.getText();
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }

    @Step("Нажата кнопка 'Оформить онлайн'")
    public void clickInsurancePageBtn() {
        new InsuranceForTravelersPage().button.click();
    }
}
