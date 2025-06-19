import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;

public class SulutionTest {


    @Test
    void testSl() {

        //Открыть страницу Github

        open("https://github.com/");

        //Выбрать меню Solutions -> Enterprize

        $(".HeaderMenu-nav>ul>li:nth-of-type(2)").hover();
        $$(".HeaderMenu-column div ul li").findBy(text("Enterprises")).click();

        //Проверить, что заголовок - "Build like the best."

        $$(".enterprise-hero-background").findBy(text("The AI-powered"))
                .shouldHave(Condition.text("The AI-powered"));

        sleep(5000);

    }
}
