package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioSteps {

    MainSteps mainSteps = new MainSteps();
    CatalogSteps catalogSteps = new CatalogSteps();
    InsuranceSteps insuranceSteps = new InsuranceSteps();
    SendAppSteps sendAppSteps = new SendAppSteps();


    @When("^Закрытие cookie уведомления$")
    public void closeCookieWarning() {
        mainSteps.closeCookieWarning();
    }

    @When("^выбран пункт основного меню \"(.*)\"$")
    public void stepSelectMainMenu(String menuItem) {
        mainSteps.selectMainMenuItem(menuItem);
    }

    @When("^выбран пункт вспомогательного меню\"(.*)\"$")
    public void stepSelectSubMenu(String menuItem) {
        mainSteps.selectSubMenuItem(menuItem);
    }

    @Then("^выбран вид странования \"(.*)\"$")
    public void selectCatalogItem(String catalogItem) {
        catalogSteps.selectCatalogItem(catalogItem);
    }

    @Then("^заголовок сраницы 'Страхование путешественников' равен - \"(.*)\"$")
    public void pageHeaderCheck(String pageHeader) {
        insuranceSteps.insurancePageTitle(pageHeader);
    }

    @Then("^выполнить нажатие 'Оформить онлайн'$")
    public void clickInsuranceBtn() {
        insuranceSteps.clickInsurancePageBtn();
    }

    @When("^выбрана сумма страховой защиты - \"(.*)\"$")
    public void insuranceSum(String insuranceSum) {
        sendAppSteps.chooseInsuranceSum(insuranceSum);
    }

    @Then("^выполнено нажате на кнопку - \"(.*)\"$")
    public void pressBtn(String btnName) {
        sendAppSteps.pressTheBtn(btnName);
    }

    @When("^заполняются поля:$")
    public void fieldFilling(DataTable fields) {
        fields.asMap(String.class, String.class).forEach(
                (key, value) -> sendAppSteps.fillFieldStep(key, value));
    }

    @Then("^значения полей равны:$")
    public void checkFillForm(DataTable fields) {
        fields.asMap(String.class, String.class).forEach(
                (key, value) -> sendAppSteps.checkFillField(key, value));
    }

    @Then("^на странице присутствует сообщение об ошибке - \"(.*)\"$")
    public void checkErrorMessage(String errorValue) {
        sendAppSteps.errorFieldCheck(errorValue);
    }
}
