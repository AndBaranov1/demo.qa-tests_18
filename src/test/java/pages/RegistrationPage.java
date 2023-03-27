package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultModal registrationResultsModal = new RegistrationResultModal();
    private final String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            uploadPicture = $("#uploadPicture"),
            currentAddress =$("#currentAddress"),
            dateOfBirthInput = $(".react-datepicker-wrapper"),
            subjectInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper");
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(Condition.text(TITLE_TEXT));
        return this;
    }

    public RegistrationPage removeFooter() {
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        $("#userEmail").setValue(email);
        return this;
    }

    public RegistrationPage setGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setPhone(String value) {
        $("#userNumber").setValue(value);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setHobby(String hobbies) {
        hobbiesInput.$(byText(hobbies)).click();
        return this;
    }

    public RegistrationPage setUploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setCurrentAddress(String address) {
        currentAddress.setValue(address);
        return this;
    }

    public RegistrationPage setState(String state) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        return this;
    }

    public RegistrationPage setCity(String city) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        return this;
    }

    public RegistrationPage clickSubmit() {
        $("#submit").click();
        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }

}
