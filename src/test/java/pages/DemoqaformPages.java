package pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class DemoqaformPages {

    private final String titleText = "Student Registration Form";

public void openPage() {

    Selenide.open("https://demoqa.com/automation-practice-form");
    $(".practice-form-wrapper").shouldHave(text(titleText));

    }
public void setFirstName (String value) {

    $("#firstName").setValue(value);

}











}
