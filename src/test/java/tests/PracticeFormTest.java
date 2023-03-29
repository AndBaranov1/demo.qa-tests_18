package tests;

import org.junit.jupiter.api.Test;

import static utils.FakerData.*;


public class PracticeFormTest extends TestBase{

    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .removeFooter()
                .removeBanner()
                .setFirstName(firstName)
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
                .setCity(city)
                .clickSubmit();

        registrationPage.verifyResultsModalAppears()
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
    }
}