package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.DemoformResultsModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DemoqaformPages {

    DemoformResultsModal demoformResultsModal = new DemoformResultsModal();
    CalendarComponent calendarComponent = new CalendarComponent();
    File file = new File("src/test/java/tests/test_file");

    private final String TITTLE_TEXT = "Student Registration Form";
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            EmailInput = $("#userEmail"),
            GenderButton = $("#genterWrapper"),
            SetNumberInput = $("#userNumber"),
            DateOfBirthInput = $("#dateOfBirthInput"),
            SetSubjectInput = $("#subjectsInput"),
            SetHobbiesInput = $(byText("Sports")),
            UploadFileButton = $("#uploadPicture"),
            SetAdressInput = $("#currentAddress"),
            StateCl = $("#state"),
            CityCl = $("#city"),
            SetState = $("#stateCity-wrapper"),
            SetCity = $("#stateCity-wrapper");

    public void openPage() {

        Selenide.open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITTLE_TEXT));
    }

    public void setFirstName(String value) {
        firstNameInput.setValue(value);
    }

    public void setLastName(String value) {
        lastNameInput.setValue(value);
    }

    public void setEmail(String value) {
        EmailInput.setValue(value);
    }

    public void setGender(String value) {
        GenderButton.$(byText(value)).click();
    }

    public void setNumber(String value) {
        SetNumberInput.setValue(value);
    }

    public void setBirthDate(String day, String month, String year) {
        DateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
    }

    public void verifyResultsModalAppears() {
        demoformResultsModal.verifyModalAppers();
    }

    public void verifyResults(String key, String value) {
        demoformResultsModal.verifyResults(key, value);
    }

    public void setSubject(String value) {
        SetSubjectInput.setValue(value).pressEnter();
    }

    public void setHobbies() {
        SetHobbiesInput.click();
    }

    public void uploadFile() {
        UploadFileButton.uploadFile(file);
    }

    public void setAdress(String value) {
        SetAdressInput.setValue(value);
    }

    public void setState(String value) {
        StateCl.click();
        SetState.$(byText(value)).click();

    }

    public void setCity(String value) {
        CityCl.click();
        SetCity.$(byText(value)).click();

    }
}