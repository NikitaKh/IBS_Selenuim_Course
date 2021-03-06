package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps {

    @Step("Переход в Яндекс {0}")
    public void selectMenuWidget(String widgetName) {
        new MainPage().selectMenuItem(widgetName);
    }
}
