package tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import data.Locale;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class SelenideTest {
    @BeforeAll
    static void beforeAll(){

        Configuration.pageLoadTimeout = 60000;

    }

    static Stream<Arguments> selenideLocaleTest () {
        return Stream.of(
                Arguments.of(Locale.EN, List.of("Quick start", "Docs", "FAQ", "Blog", "Javadoc", "Users", "Quotes")),
                Arguments.of(Locale.RU, List.of("С чего начать?", "Док", "ЧАВО", "Блог", "Javadoc", "Пользователи", "Отзывы"))

        );

    }

    @MethodSource
    @ParameterizedTest(name = "Для локали {0} отображаюстя кнопки  {1}")
    @Tag("MAJOR")
    void selenideLocaleTest(
            Locale locale,
            List<String> buttons
    ) {
        open("https://ru.selenide.org/");
        $$("#languages").find(text(locale.name())).click();
        $$(".main-menu-pages a")
                .filter(visible)
                .shouldHave(CollectionCondition.texts(buttons));

    }

}
