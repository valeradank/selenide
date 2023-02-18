import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;


import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {
    String generateDate = new SelenideGenerateDate() {

        LocalDate date = LocalDate.now();
        String planningDate = generateDate(4);
    }.planningDate;

    @Test
    void cardDeliveryTest() {

        Configuration.holdBrowserOpen = true;

        open("http://localhost:9999/");

        $("input[type='text']").setValue("Астрахань");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("input[type='tel']").setValue(generateDate);
        $("input[name='name']").setValue("Валерий Данковцев");
        $("input[name='phone']").setValue("+79295964548");
        $("[data-test-id='agreement']").click();
        $x("//span[text()='Забронировать']").click();
        $("div[data-test-id='notification']").should(appear, Duration.ofSeconds(15)).shouldHave(Condition.text("Встреча успешно забронирована на " + generateDate), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);


    }



    }





