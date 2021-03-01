package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps extends BaseSteps {

    @Step("Закрыть cookie уведомление.")
    public void closeCookieWarning() {
        new MainPage().cookie.click();
    }

    @Step("Выбран пункт основного меню - {0}")
    public void selectMainMenuItem(String menuItem) {
        new MainPage().selectMainMenu(menuItem);
    }

    @Step("Выбран пункт вспомогательного меню - {0}")
    public void selectSubMenuItem(String menuItem) {
        new MainPage().selectSubMenu(menuItem);
    }
}
