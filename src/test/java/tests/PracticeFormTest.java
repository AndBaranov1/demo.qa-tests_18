package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static utils.FakerData.*;

public class PracticeFormTest extends TestBase{

    @Tag("main_property")
    @DisplayName("Registration Form Validation")
    @Test
    void fillFormTest() {
        step("Open main page", () -> {
                    registrationPage.openPage();
                });

        step("Remove banners and footer", () -> {
            registrationPage.removeFooter()
                    .removeBanner();
        });

        step("Fill form", () -> {
            registrationPage.setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(email)
                    .setGender(gender)
                    .setPhone(phone)
                    .setBirthDate(day, month, year)
                    .setSubject(subject)
                    .setHobby(hobbies)
                    .setUploadPicture(file)
                    .setCurrentAddress(address)
                    .setState(state)
                    .setCity(city);
                });

        step("Click submit", () -> {
            registrationPage.clickSubmit();
                });

        step("Verify results form", () -> {
            registrationResultModal.verifyModalAppears("Thanks for submitting the form")
                    .verifyResult("Student Name", firstName + " " + lastName)
                    .verifyResult("Student Email", email)
                    .verifyResult("Gender", gender)
                    .verifyResult("Mobile", phone)
                    .verifyResult("Date of Birth", day + " " + month + "," + year)
                    .verifyResult("Subjects", subject)
                    .verifyResult("Hobbies", hobbies)
                    .verifyResult("Picture", file)
                    .verifyResult("Address", address)
                    .verifyResult("State and City", state + " " + city);
                });
    }
}