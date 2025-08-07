package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import pages.DemoqaformPages;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;

public class TestBase {

    Faker faker = new Faker(new Locale("es"));

    String userName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String userNumber = faker.number().numberBetween(7926000000L,7926999999L) + "";
    String currentAdress = faker.address().fullAddress();
    SelenideElement submitButton = $("#submit");

    DemoqaformPages demoformqaPages = new DemoqaformPages();

    @BeforeAll
    static void beforeAll(){

        Configuration.pageLoadTimeout = 60000;
        Configuration.browserSize = "1920x1080";

    }





}
