package steps;

import pages.TvCatalogPage;
import ru.yandex.qatools.allure.annotations.Step;

public class TvCatalogSteps {

    public String itemInfo;

    @Step("Переход в расширенный поиск")
    public void wideSearch() {
        new TvCatalogPage().wideSearch.click();
    }

    @Step("Задан ценовой диапазон {0} {1} рублей")
    public void pricesRange(String range, String value) {
        new TvCatalogPage().selectPrice(range, value);
    }

    @Step("Выбран производитель {0}")
    public void selectProducer(String producerName) {
        new TvCatalogPage().selectProductProducer(producerName);
    }

    @Step("Нажата кнопка 'Применить'")
    public void clickAcceptBtn() {
        new TvCatalogPage().acceptBtn.click();
    }

    @Step("На странице {0} элементов")
    public void checkItemsSum(String itemsSum) {
        new TvCatalogPage().checkItemsSum(itemsSum);
    }

    @Step("Выполнена запись информации о {0} элементе")
    public void saveItemInfo(String itemNum) {
        itemInfo = new TvCatalogPage().setItemInfo(itemNum);
    }

    @Step("Поиск по наименованию - {0}")
    public void searchItem(String itemValue) {
        new TvCatalogPage().searchItem(itemValue);
    }

    @Step("Выполнена проверка запомненного значения")
    public void matchItems() {
        String actualValue = new TvCatalogPage().setSearchItemInfo();
        org.junit.Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualValue, itemInfo),
                actualValue.contains(itemInfo));
    }
}
