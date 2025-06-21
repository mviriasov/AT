import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.module.Configuration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class Demoqaform {

    @BeforeAll
    static void beforeAll(){



    }


    @Test
    void DemoForm() {

        //Открытие формы
        Selenide.open("https://demoqa.com/automation-practice-form");

        //Заполнение полей формы
        $("#firstName").setValue("Max");
        $("#lastName").setValue("Bochkin");
        $("#userEmail").setValue("parararapa@mail.ru");
        $("");






        sleep(5000);
    }
}
