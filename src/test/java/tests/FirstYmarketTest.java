package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FirstYmarketTest {


   /* @CsvSource({
    "primekraft, Primekraft в Пензе",
    "Maxler, Maxler в Пензе"
    })
*/
    @CsvFileSource(resources = "/testData.csv")

    /*@ValueSource(
            strings = {"Primekraft в Пензе", "Maxler в Пензе"}
    )
*/
    @ParameterizedTest( name = " {1} продукт должен быть в выдаче товаров по запросу {0}")
    @Tag("UI_TEST")

    void yMarketSearchProductsTest (
            String productName,
            String productResult
    ) {
        open("https://market.yandex.ru/");
        $("#header-search").setValue(productName).pressEnter();
        $("[data-zone-name=searchTitle]").shouldHave(text(productResult));

    }


}
