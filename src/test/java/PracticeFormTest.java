import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {

    @BeforeAll
    static  void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("test@test.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9991005050");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-dropdown-container").$(byText("September")).click();
        $(".react-datepicker__year-dropdown-container").$(byText("1990")).click();
        $(".react-datepicker__month-container").$(byText("8")).click();
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Test");
        $("#hobbies-checkbox-2").parent().$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("pictures/1.png");
        $("#currentAddress").setValue("St Test Address");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Ivan Ivanov"));
        $(".modal-body").shouldHave(text("test@test.ru"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("9991005050"));
        $(".modal-body").shouldHave(text("08 September,1990"));
        $(".modal-body").shouldHave(text("Test"));
        $(".modal-body").shouldHave(text("Reading"));
        $(".modal-body").shouldHave(text("1.png"));
        $(".modal-body").shouldHave(text("St Test Address"));
        $(".modal-body").shouldHave(text("NCR Delhi"));
        $("#closeLargeModal").click();
    }
}