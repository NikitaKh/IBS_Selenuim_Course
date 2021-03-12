package steps;

import pages.ItemCatalogPage;
import ru.yandex.qatools.allure.annotations.Step;

public class ItemCatalogSteps {

    public String itemInfo;

    @Step("Переход в расширенный поиск")
    public void wideSearch(String item) {
        new ItemCatalogPage().selectWideSearch(item);
    }

    @Step("Задан ценовой диапазон {0} {1} рублей")
    public void pricesRange(String range, String value) {
        new ItemCatalogPage().selectPrice(range, value);
    }

    @Step("Выбран производитель {0}")
    public void selectProducer(String producerName) {
        new ItemCatalogPage().selectProductProducer(producerName);
    }

    @Step("Нажата кнопка 'Применить'")
    public void clickAcceptBtn() {
        new ItemCatalogPage().acceptBtn.click();
    }

    @Step("На странице {0} элементов")
    public void checkItemsSum(String itemsSum) {
        new ItemCatalogPage().checkItemsSum(itemsSum);
    }

    @Step("Выполнена запись информации о {0} элементе")
    public void saveItemInfo(String itemNum) {
        itemInfo = new ItemCatalogPage().setItemInfo(itemNum);
    }

    @Step("Поиск по наименованию - {0}")
    public void searchItem(String itemValue) {
        new ItemCatalogPage().searchItem(itemValue);
    }

    @Step("Выполнена проверка запомненного значения")
    public void matchItems() {
        String actualValue = new ItemCatalogPage().setSearchItemInfo();
        org.junit.Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualValue, itemInfo),
                actualValue.contains(itemInfo));
    }
}
