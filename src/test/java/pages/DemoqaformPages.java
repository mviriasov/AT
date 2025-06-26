package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.DemoformResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DemoqaformPages {

DemoformResultsModal demoformResultsModal = new DemoformResultsModal();
CalendarComponent calendarComponent = new CalendarComponent();

private final String TITTLE_TEXT = "Student Registration Form";
private final SelenideElement
        firstNameInput =  $("#firstName"),
        lastNameInput = $("#lastName"),
        EmailInput = $("#userEmail"),
        GenderButton = $("#genterWrapper"),
        SetNumberInput = $("#userNumber"),
        DateOfBirthInput = $("#dateOfBirthInput");

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

public void setBirthDate (String day, String month, String year) {
    DateOfBirthInput.click();
    calendarComponent.setDate(day, month, year);
    }

public void verifyResultsModalAppears () {
    demoformResultsModal.verifyModalAppers();
    }

public void verifyResults(String key, String value) {
    demoformResultsModal.verifyResults(key, value);
}






}
