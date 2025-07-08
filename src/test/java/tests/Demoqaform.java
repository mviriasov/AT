package tests;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import pages.DemoqaformPages;

import static com.codeborne.selenide.Selenide.*;

public class Demoqaform extends TestBase {


    @Test
    void DemoForm() {
        String userName = "Max";
        String lastName = "Bochkin";
        String userEmail = "parararapa@mail.ru";
        String userNumber = "7927388223";
        String currentAdress = "Bobrovskaya";
        SelenideElement submitButton = $("#submit");

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

        //Выбор предмета
        demoformqaPages.setSubject("English");

        //Выбор хобби
        demoformqaPages.setHobbies();

        //Загрузка файла
        demoformqaPages.uploadFile();

        //Адрес
        demoformqaPages.setAdress(currentAdress);

        //Выбор Штата и города
        demoformqaPages.setState("Uttar Pradesh");
        demoformqaPages.setCity("Merrut");
        submitButton.click();

        demoformqaPages.verifyResultsModalAppears();
        demoformqaPages.verifyResults("Student Name", userName + " " + lastName);
        demoformqaPages.verifyResults("Student Email", userEmail);
        demoformqaPages.verifyResults("Gender", "Other");
        demoformqaPages.verifyResults("Mobile", userNumber);
        demoformqaPages.verifyResults("Date of Birth", "16 February,1999");
        demoformqaPages.verifyResults("Subjects", "English");
        demoformqaPages.verifyResults("Hobbies", "Sports");
        demoformqaPages.verifyResults("Picture", "test_file");
        demoformqaPages.verifyResults("Address", currentAdress);
        demoformqaPages.verifyResults("State and City", "Uttar Pradesh Merrut");

        sleep(7000);
    }
}
