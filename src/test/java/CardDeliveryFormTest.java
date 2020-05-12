import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@DisplayName("Тест формы заказа доставки карты")
public class CardDeliveryFormTest {

    DataGenerator dataGenerator = new DataGenerator();

    @Test
    @DisplayName("Проверка изменения даты встречи")
    void shouldSubmit() {
        open("http://localhost:9999");
        SelenideElement form = $("form[class='form form_size_m form_theme_alfa-on-white']");
        form.$("[data-test-id=city] input").setValue(dataGenerator.generateCity());
        form.$("[data-test-id=name] input").setValue(dataGenerator.generateName());
        form.$("[data-test-id=phone] input").setValue(dataGenerator.generatePhone());
        form.$("[data-test-id=agreement]").click();
        form.$(".button").click();
        form.$("[data-test-id=date] input").sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        form.$("[data-test-id=date] input").sendKeys(dataGenerator.futureDate(7));
        $$("span.button__text").find(exactText("Запланировать")).click();
        $$("span.button__text").find(exactText("Перепланировать")).click();
        $("[data-test-id='success-notification']").shouldBe(visible);
    }
}
