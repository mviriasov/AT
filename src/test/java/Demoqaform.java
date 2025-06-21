import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class Demoqaform {

    @BeforeAll
    static void beforeAll(){

        Configuration.pageLoadTimeout = 60000;

    }


    @Test
    void DemoForm() {


        //Открытие формы
        Selenide.open("https://demoqa.com/automation-practice-form");

        //Заполнение полей формы
        $("#firstName").setValue("Max");
        $("#lastName").setValue("Bochkin");
        $("#userEmail").setValue("parararapa@mail.ru");
        //Выбор гендера
        // с помощью Радиобаттон$(".custom-control-input").selectRadio("Male");
        $(byText("Male")).click();
        $("#userNumber").setValue("7927388223");




        sleep(5000);
    }
}
