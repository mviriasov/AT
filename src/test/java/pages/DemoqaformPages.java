package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DemoqaformPages {

private final String TITTLE_TEXT = "Student Registration Form";
private final SelenideElement
        firstNameInput =  $("#firstName"),
        lastNameInput = $("#lastName"),
        EmailInput = $("#userEmail"),
        GenderButton = $("#genterWrapper"),
        SetNumberInput = $("#userNumber");


public void openPage() {

    Selenide.open("https://demoqa.com/automation-practice-form");
    $(".practice-form-wrapper").shouldHave(text(TITTLE_TEXT));

    }

public void setFirstName (String value) {
    firstNameInput.setValue(value);
}

public void setLastName (String value) {
        lastNameInput.setValue(value);
    }

public void setEmail (String value) {
        EmailInput.setValue(value);
    }

public void setGender (String value) {
        GenderButton.$(byText(value)).click();
    }

public void setNumber (String value) {
        SetNumberInput.setValue(value);
    }










}
