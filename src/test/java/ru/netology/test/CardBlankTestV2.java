package ru.netology.test;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardBlankTestV2 {

    @Test
//    @Disabled
    void invalidNameBox() {
        open("http://localhost:9999/");
        $("[data-test-id=name] input").setValue("Alex Winter");
        $("[data-test-id=phone] input").setValue("+79991234564");
        $("[data-test-id=agreement]").click();
        $("button[type=button]").click();
        $("[data-test-id=name] span[class=input__sub]").shouldHave(exactText("Имя и Фамилия указанные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    void invalidNamePhone() {
        open("http://localhost:9999/");
        $("[data-test-id=name] input").setValue("Артем Рец");
        $("[data-test-id=phone] input").setValue("79991234568");
        $("[data-test-id=agreement]").click();
        $("button[type=button]").click();
        $("[data-test-id=phone] span[class=input__sub]").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    void noClickCheckBox() {
        open("http://localhost:9999/");
        $("[data-test-id=name] input").setValue("Артем Рец");
        $("[data-test-id=phone] input").setValue("+79991234568");
        $("button[type=button]").click();
        $(".input_invalid").shouldHave(cssValue("color", "rgba(255, 92, 92, 1)"));
    }

}
