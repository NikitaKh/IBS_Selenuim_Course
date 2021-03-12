package steps;

import pages.ElektronikaCatalogPage;
import ru.yandex.qatools.allure.annotations.Step;

public class ElectronikaCatalogSteps {

    public String selectedItem;

    @Step("Выбор раздела {0} в калоге электроки.")
    public void selectElectronikaSection(String sectionName) {
        selectedItem = new ElektronikaCatalogPage().selectProductType(sectionName);
    }
}
