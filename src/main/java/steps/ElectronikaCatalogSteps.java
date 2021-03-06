package steps;

import pages.ElektronikaCatalogPage;
import ru.yandex.qatools.allure.annotations.Step;

public class ElectronikaCatalogSteps {

    @Step("Выбор раздела {0} в калоге электроки.")
    public void selectElectronikaSection(String sectionName) {
        new ElektronikaCatalogPage().selectProductType(sectionName);
    }
}
