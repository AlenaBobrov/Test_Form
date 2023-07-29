

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;

import java.util.Locale;
import java.util.Random;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


public class Test_Form {

    @BeforeAll
    static void setUpAll() {

        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @AfterEach
    void tearDown() {
        Selenide.clearBrowserCookies();
    }

    public static String getSymbols() {
        String symbols = "!№%:?*";
        Random r = new Random();
        char c = symbols.charAt(r.nextInt(symbols.length()));
        return String.valueOf(c);
    }

    private static Faker faker = new Faker(new Locale("en"));
    private static Faker fakerRU = new Faker(new Locale("ru"));

    @Test
    void shouldWork() {
        open("https://groall.noda.pro/test_qa");
        $(withText("Выбор офиса обслуживания")).shouldBe(visible);
        $x("//div//span[contains(text(), 'Москва')]").click();
        $("[name='value']").setValue("3");
        $("[value='Вывести']").click();
        $("[error]").shouldBe(hidden);

    }

    @Test
    void emptyField() {
        open("https://groall.noda.pro/test_qa");
        $(withText("Выбор офиса обслуживания")).shouldBe(visible);
        $x("//div//span[contains(text(), 'Москва')]").click();
        $("[name='value']").setValue("");
        $("[value='Вывести']").click();
        $x("//div//label[contains(text(), 'Поле обязательно для заполнения')]").shouldBe(visible);

    }

    @Test
    void symbolsField() {
        open("https://groall.noda.pro/test_qa");
        $(withText("Выбор офиса обслуживания")).shouldBe(visible);
        $x("//div//span[contains(text(), 'Москва')]").click();
        $("[name='value']").setValue(Test_Form.getSymbols());
        $("[value='Вывести']").click();
        $x("//div//label[contains(text(), 'Поле должно содержать только цифры!')]").shouldBe(visible);
    }

    @Test
    void latinLettersField() {
        open("https://groall.noda.pro/test_qa");
        $(withText("Выбор офиса обслуживания")).shouldBe(visible);
        $x("//div//span[contains(text(), 'Москва')]").click();
        $("[name='value']").setValue(faker.name().lastName());
        $("[value='Вывести']").click();
        $x("//div//label[contains(text(), 'Поле должно содержать только цифры!')]").shouldBe(visible);
    }

    @Test
    void cyrillicLettersField() {
        open("https://groall.noda.pro/test_qa");
        $(withText("Выбор офиса обслуживания")).shouldBe(visible);
        $x("//div//span[contains(text(), 'Москва')]").click();
        $("[name='value']").setValue(fakerRU.name().lastName());
        $("[value='Вывести']").click();
        $x("//div//label[contains(text(), 'Поле должно содержать только цифры!')]").shouldBe(visible);
    }

    @Test
    void boundaryValueZeroShouldNotWork() {
        open("https://groall.noda.pro/test_qa");
        $(withText("Выбор офиса обслуживания")).shouldBe(visible);
        $x("//div//span[contains(text(), 'Москва')]").click();
        $("[name='value']").setValue("0");
        $("[value='Вывести']").click();
        $x("//div//label[contains(text(), 'Значение поля должно быть больше 0')]").shouldBe(visible);
    }

    @Test
    void boundaryValueOverShouldNotWork() {
        open("https://groall.noda.pro/test_qa");
        $(withText("Выбор офиса обслуживания")).shouldBe(visible);
        $x("//div//span[contains(text(), 'Москва')]").click();
        $("[name='value']").setValue("122001");
        $("[value='Вывести']").click();
        $x("//div//label[contains(text(), 'Значение поля не может быть больше суммы на счете')]").shouldBe(visible);
    }

    @Test
    void boundaryValueOneShouldWork() {
        open("https://groall.noda.pro/test_qa");
        $(withText("Выбор офиса обслуживания")).shouldBe(visible);
        $x("//div//span[contains(text(), 'Москва')]").click();
        $("[name='value']").setValue("1");
        $("[value='Вывести']").click();
        $("[error]").shouldBe(hidden);
    }

    @Test
    void boundaryValueMaxShouldWork() {
        open("https://groall.noda.pro/test_qa");
        $(withText("Выбор офиса обслуживания")).shouldBe(visible);
        $x("//div//span[contains(text(), 'Москва')]").click();
        $("[name='value']").setValue("121999");
        $("[value='Вывести']").click();
        $("[error]").shouldBe(hidden);
    }

    @Test
    void minusShouldNotWork() {
        open("https://groall.noda.pro/test_qa");
        $(withText("Выбор офиса обслуживания")).shouldBe(visible);
        $x("//div//span[contains(text(), 'Москва')]").click();
        $("[name='value']").setValue("-10");
        $("[value='Вывести']").click();
        $x("//div//label[contains(text(), 'Значение поля должно быть больше 0')]").shouldBe(visible);
    }

    @Test
    void outputAllShouldWork() {
        open("https://groall.noda.pro/test_qa");
        $(withText("Выбор офиса обслуживания")).shouldBe(visible);
        $x("//div//span[contains(text(), 'Москва')]").click();
        $("[id='all']").click();
        $("[value='Вывести']").click();
        $("[error]").shouldBe(hidden);
    }

}
