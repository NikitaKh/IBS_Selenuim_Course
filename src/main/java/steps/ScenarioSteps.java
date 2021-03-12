package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioSteps {

    MainSteps mainSteps = new MainSteps();
    MarketSteps marketSteps = new MarketSteps();
    ElectronikaCatalogSteps electronikaCatalogSteps = new ElectronikaCatalogSteps();
    ItemCatalogSteps itemCatalogSteps = new ItemCatalogSteps();

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
        itemCatalogSteps.wideSearch(electronikaCatalogSteps.selectedItem);
    }

    @When("^задать параметры поиска по цене \"(.*)\" \"(.*)\"$")
    public void pricesRange(String range, String value) {
        itemCatalogSteps.pricesRange(range, value);
    }

    @When("^выбрать производителей:$")
    public void selectProducers(DataTable producers) {
        producers.asList(String.class).forEach(producer -> itemCatalogSteps.selectProducer(producer));
    }

    @Then("^нажать кнопку 'Применить'$")
    public void clickAcceptBtn() {
        itemCatalogSteps.clickAcceptBtn();
    }

    @Then("^количество элементов на странице равно - \"(.*)\"$")
    public void checkItemsSum(String items) {
        itemCatalogSteps.checkItemsSum(items);
    }

    @When("^записана информация о \"(.*)\" элементе$")
    public void saveItemsInfo(String itemNum) {
        itemCatalogSteps.saveItemInfo(itemNum);
    }

    @Then("^в поисковую строку введено записанное значение и нажата кнопка 'Найти'$")
    public void searchItem() {
        itemCatalogSteps.searchItem(itemCatalogSteps.itemInfo);
    }

    @Then("^наименование товара соответствует запомненному значению$")
    public void matchItems() {
        itemCatalogSteps.matchItems();
    }

}
