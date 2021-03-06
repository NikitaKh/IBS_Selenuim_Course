package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioSteps {

    MainSteps mainSteps = new MainSteps();
    MarketSteps marketSteps = new MarketSteps();
    ElectronikaCatalogSteps electronikaCatalogSteps = new ElectronikaCatalogSteps();
    TvCatalogSteps tvCatalogSteps = new TvCatalogSteps();

    @When("^выбран пункт меню \"(.*)\"$")
    public void selectMainMenu(String menuItem) {
        mainSteps.selectMenuWidget(menuItem);
    }

    @When("^выбран раздел каталога \"(.*)\"$")
    public void selectMarketCatalog(String marketItem) {
        marketSteps.selectMarketSection(marketItem);
    }

    @Then("^выбран вид товара - \"(.*)\"$")
    public void selectProductSection(String productSection) {
        electronikaCatalogSteps.selectElectronikaSection(productSection);
    }

    @Then("^выполнен переход во 'Все фильтры'$")
    public void wideSearch() {
        tvCatalogSteps.wideSearch();
    }

    @When("^задать параметры поиска по цене \"(.*)\" \"(.*)\"$")
    public void pricesRange(String range, String value) {
        tvCatalogSteps.pricesRange(range, value);
    }

    @When("^выбрать производителей:$")
    public void selectProducers(DataTable producers) {
        producers.asList(String.class).forEach(producer -> tvCatalogSteps.selectProducer(producer));
    }

    @Then("^нажать кнопку 'Применить'$")
    public void clickAcceptBtn() {
        tvCatalogSteps.clickAcceptBtn();
    }

    @Then("^количество элементов на странице равно - \"(.*)\"$")
    public void checkItemsSum(String items) {
        tvCatalogSteps.checkItemsSum(items);
    }

    @When("^записана информация о \"(.*)\" элементе$")
    public void saveItemsInfo(String itemNum) {
        tvCatalogSteps.saveItemInfo(itemNum);
    }

    @Then("^в поисковую строку введено записанное значение и нажата кнопка 'Найти'$")
    public void searchItem() {
        tvCatalogSteps.searchItem(tvCatalogSteps.itemInfo);
    }

    @Then("^наименование товара соответствует запомненному значению$")
    public void matchItems() {
        tvCatalogSteps.matchItems();
    }

}
