package tests;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Demoqaform extends TestBase {

    @Test
    void DemoForm() {
        String userName = "Max";
        String lastName = "Bochkin";
        String userEmail = "parararapa@mail.ru";
        String userNumber = "7927388223";
        String currentAdress = "Bobrovskaya";

        //Открытие формы
        demoformqaPages.openPage();

        //Заполнение полей формы
        demoformqaPages.setFirstName(userName);
        demoformqaPages.setLastName(lastName);
        demoformqaPages.setEmail(userEmail);

        //Выбор гендера
        demoformqaPages.setGender("Other");

        //Заполнение полей: номер телефона и дата рождения
        demoformqaPages.setNumber(userNumber);
        demoformqaPages.setBirthDate("16", "February", "1999");


        //Выбор предметов
        $("#subjectsInput").setValue("English").pressEnter();
        //$("#subjectsInput").setValue("Mat").pressEnter();

        $(byText("Sports")).click();

        //Загрузка файла
        File file = new File("src/test/java/tests/test_file");
        $("#uploadPicture").uploadFile(file);

        $("#currentAddress").setValue(currentAdress);
        //Это выглядит как какая-то шляпа? или так делают?
        $(byText("Select State")).click();
        $("#react-select-3-option-1").click();

        $(byText("Select City")).click();
        $("#react-select-4-option-2").click();
        $("#submit").click();

        demoformqaPages.verifyResultsModalAppears();
        demoformqaPages.verifyResults("Student Name", userName + " " + lastName);
        demoformqaPages.verifyResults("Student Email", userEmail);
        demoformqaPages.verifyResults("Gender", "Other");
        demoformqaPages.verifyResults("Mobile", userNumber);
        demoformqaPages.verifyResults("Date of Birth", "16 February,1999");


        $(".table-responsive").shouldHave(text("English"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("test_file"));
        $(".table-responsive").shouldHave(text(currentAdress));
        $(".table-responsive").shouldHave(text("Uttar Pradesh Merrut"));


        sleep(7000);
    }
}
