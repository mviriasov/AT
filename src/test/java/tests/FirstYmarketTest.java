package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FirstYmarketTest {



    @DisplayName("Бренд PRIMEKRAFT должен быть в выдаче marketa по запросу 'primekraft'")
    @Test
    @Tag("UI_TEST")

    void yMarketSearchprimeKraftTest() {
        open("https://market.yandex.ru/");
        $("#header-search").setValue("primekraft").pressEnter();
        $("[data-zone-name=searchTitle]").shouldHave(text("Primekraft в Пензе"));

    }
}
