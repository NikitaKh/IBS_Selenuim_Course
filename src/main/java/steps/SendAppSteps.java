package steps;

import pages.SendAppPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class SendAppSteps extends BaseSteps {

    @Step("Сумма страховой защиты - {0} ")
    public void chooseInsuranceSum(String insuranceSum) {
        new SendAppPage().insuranceSum(insuranceSum);
    }

    @Step("Нажата кнопка - {0}")
    public void pressTheBtn(String btnValue) {
        new SendAppPage().issueButton(btnValue);
    }

    @Step("Поле {0} заполняется значением {1}")
    private void fillFieldStep(String field, String value) {
        new SendAppPage().fillField(field, value);
    }

    @Step("Заполнение полей ->")
    public void fillFieldsStep(HashMap<String, String> fields) {
        fields.forEach(this::fillFieldStep);
    }

    @Step("Поле {0} заполнено значением {1}")
    private void checkFillField(String field, String value) {
        String actualValue = new SendAppPage().getFillField(field, value);
        assertEquals(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]",
                field, actualValue, value), actualValue, value);
    }

    @Step("Поля заполнены верно")
    public void checkFillFields(HashMap<String, String> fields) {
        fields.forEach(this::checkFillField);
    }

    @Step("Присутствует сообщение об ошибке - {0}")
    public void errorFieldCheck(String errorValue) {
        new SendAppPage().checkFieldErrorMessage(errorValue);
    }
}
