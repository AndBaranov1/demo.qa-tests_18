package tests;

import org.junit.jupiter.api.Test;

public class PracticeFormTest extends TestBase{

    @Test
    void fillFormTest() {
        String userName = "Ivan";
        String userLastName = "Ivanov";

        registrationPage.openPage()
                .removeFooter()
                .removeBanner()
                .setFirstName(userName)
                .setLastName(userLastName)
                .setEmail("test@test.ru")
                .setGender("Male")
                .setPhone("9991005050")
                .setBirthDate("10", "September", "1990")
                .setSubject("English")
                .setHobby("Reading")
                .setUploadPicture("pictures/1.png")
                .setCurrentAddress("St Test Address")
                .setState("NCR")
                .setCity("Delhi")
                .clickSubmit();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", userName + " " + userLastName)
                .verifyResult("Student Email", "test@test.ru")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "9991005050")
                .verifyResult("Date of Birth", "10 September,1990")
                .verifyResult("Subjects", "English")
                .verifyResult("Hobbies", "Reading")
                .verifyResult("Picture","1.png")
                .verifyResult("Address", "St Test Address")
                .verifyResult("State and City", "NCR" + " " + "Delhi");
    }
}