import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class Demoqaform {

    @BeforeAll
    static void beforeAll(){

        Configuration.pageLoadTimeout = 60000;
        Configuration.browserSize = "1920x1080";

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
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1999");
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__day--016").click();

        /*
        Выбор предметов
        Не смог понять, почему ебаный setValue не работает.
        $("#subjectsContainer").click();
        $(".subjects-auto-complete__control--menu-is-open").setValue("E").$(byText("English")).click();
        $("#subjectsContainer").setValue("Mat").$(byText("Maths")).click();
        */

        $(byText("Sports")).click();

        //Загрузка файла
        File file = new File("src/test/java/test_file");
        $("#uploadPicture").uploadFile(file);

        $("#currentAddress").setValue("Bobrovskaya");
        //Это выглядит как какая-то шляпа? или так делают?
        $(byText("Select State")).click();
        $("#react-select-3-option-1").click();

        $(byText("Select City")).click();
        $("#react-select-4-option-2").click();


        //$("#submit").click();


        sleep(5000);
    }
}
