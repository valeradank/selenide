import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {
    WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void teardown() {
        driver.quit();


    }


    @Test
    void cardDeliveryTest() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("input[type='text']").setValue("Астрахань");
        $("input[type='tel']").sendKeys(Keys.BACK_SPACE);
        $("input[type='tel']").sendKeys(Keys.BACK_SPACE);
        $("input[type='tel']").sendKeys(Keys.BACK_SPACE);
        $("input[type='tel']").sendKeys(Keys.BACK_SPACE);
        $("input[type='tel']").sendKeys(Keys.BACK_SPACE);
        $("input[type='tel']").sendKeys(Keys.BACK_SPACE);
        $("input[type='tel']").sendKeys(Keys.BACK_SPACE);
        $("input[type='tel']").sendKeys(Keys.BACK_SPACE);
        $("input[type='tel']").setValue("22.02.2023");
        $("input[name='name']").setValue("Валерий Данковцев");
        $("input[name='phone']").setValue("+79295964548");
        $("[data-test-id='agreement']").click();
        $x("//span[text()='Забронировать']").click();
        $("div[data-test-id='notification']").should(appear, Duration.ofSeconds(15));
    }
}
