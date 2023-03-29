package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultModal {
    public RegistrationResultModal verifyModalAppears(String value) {
        $(".modal-open").shouldHave(text(value));
        return this;
    }
    public RegistrationResultModal verifyResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
        return this;
    }
}
