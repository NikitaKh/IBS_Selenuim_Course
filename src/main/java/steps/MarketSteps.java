package steps;

import pages.MarketPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MarketSteps {

    @Step("Выбор раздела {0}")
    public void selectMarketSection(String marketItem) {
        new MarketPage().selectMarketItem(marketItem);
    }
}
