package steps;

import pages.CatalogPage;
import ru.yandex.qatools.allure.annotations.Step;

public class CatalogSteps {

    @Step("Нажатие на - {0}")
    public void selectCatalogItem(String catalogItem) {
        new CatalogPage().selectFromCatalog(catalogItem);
    }
}
