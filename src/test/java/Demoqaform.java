import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.DemoqaformPages;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Demoqaform {

    @BeforeAll
    static void beforeAll(){

        Configuration.pageLoadTimeout = 60000;
        Configuration.browserSize = "1920x1080";

    }

    @Test
    void DemoForm() {
        String userName = "Max";
        String lastName = "Bochkin";
        String userEmail = "parararapa@mail.ru";
        String userNumber = "7927388223";
        String currentAdress = "Bobrovskaya";

        //Открытие формы
        new DemoqaformPages().openPage();

        //Заполнение полей формы
        new DemoqaformPages().setFirstName(userName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        //Выбор гендера
        // с помощью Радиобаттон$(".custom-control-input").selectRadio("Male");
        $(byText("Male")).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1999");
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__day--016").click();


        //Выбор предметов
        //Тут не понимаю почему тоже самое в одну строку не работало?
        //$("#subjectsContainer").click();
        $("#subjectsInput").setValue("English").pressEnter();
        // $(byText("English")).click();
        //$("#subjectsInput").setValue("Mat").pressEnter();
        //$(byText("Maths")).click();


        $(byText("Sports")).click();

        //Загрузка файла
        File file = new File("src/test/java/test_file");
        $("#uploadPicture").uploadFile(file);

        $("#currentAddress").setValue(currentAdress);
        //Это выглядит как какая-то шляпа? или так делают?
        $(byText("Select State")).click();
        $("#react-select-3-option-1").click();

        $(byText("Select City")).click();
        $("#react-select-4-option-2").click();

        $("#submit").click();
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(userName));
        $(".table-responsive").shouldHave(text(lastName));
        $(".table-responsive").shouldHave(text(userEmail));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text(userNumber));
        $(".table-responsive").shouldHave(text("16 February,1999"));
        $(".table-responsive").shouldHave(text("English"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("test_file"));
        $(".table-responsive").shouldHave(text(currentAdress));
        $(".table-responsive").shouldHave(text("Uttar Pradesh Merrut"));


        sleep(7000);
    }
}
