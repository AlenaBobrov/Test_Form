import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;

import java.util.Locale;
import java.util.Random;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


public class Test_Form {
    @BeforeEach
    void setup() {
        open("https://groall.noda.pro/test_qa");
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
    @DisplayName("Отправка формы Вывод средств со счета с использованием корректного значения в поле Вывести")
    void validNumber1() {
        $(withText("Выбор офиса обслуживания")).shouldBe(visible);
        $x("//div//span[contains(text(), 'Москва')]").click();
        $("[name='value']").setValue("10");
        $("[value='Вывести']").click();
        $("[error]").shouldBe(hidden);

    }

    @Test
    @DisplayName("Отправка формы Вывод средств со счета с использованием дробного числа с разделителем 'точка' в поле Вывести")
    void validNumber2() {
        $(withText("Выбор офиса обслуживания")).shouldBe(visible);
        $x("//div//span[contains(text(), 'Москва')]").click();
        $("[name='value']").setValue("0.01");
        $("[value='Вывести']").click();
        $("[error]").shouldBe(hidden);

    }

    @Test
    @DisplayName("Отправка формы Вывод средств со счета с использованием дробного числа с разделителем 'запятая' в поле Вывести")
    void commaNumber() {
        $(withText("Выбор офиса обслуживания")).shouldBe(visible);
        $x("//div//span[contains(text(), 'Москва')]").click();
        $("[name='value']").setValue("0,01");
        $("[value='Вывести']").click();
        $x("//div//label[contains(text(), 'Неверный формат!')]").shouldBe(visible);

    }

    @Test
    @DisplayName("Отправка формы Вывод средств со счета с пустым значением в поле Вывести")
    void emptyField() {
        $(withText("Выбор офиса обслуживания")).shouldBe(visible);
        $x("//div//span[contains(text(), 'Москва')]").click();
        $("[name='value']").setValue("");
        $("[value='Вывести']").click();
        $x("//div//label[contains(text(), 'Поле обязательно для заполнения')]").shouldBe(visible);

    }

    @Test
    @DisplayName("Отправка формы Вывод средств со счета с использованием спецсимвола в поле Вывести")
    void symbolsField() {
        $(withText("Выбор офиса обслуживания")).shouldBe(visible);
        $x("//div//span[contains(text(), 'Москва')]").click();
        $("[name='value']").setValue(Test_Form.getSymbols());
        $("[value='Вывести']").click();
        $x("//div//label[contains(text(), 'Поле должно содержать только цифры!')]").shouldBe(visible);
    }

    @Test
    @DisplayName("Отправка формы Вывод средств со счета с использованием латинских символов в поле Вывести")
    void latinLettersField() {
        $(withText("Выбор офиса обслуживания")).shouldBe(visible);
        $x("//div//span[contains(text(), 'Москва')]").click();
        $("[name='value']").setValue(faker.name().lastName());
        $("[value='Вывести']").click();
        $x("//div//label[contains(text(), 'Поле должно содержать только цифры!')]").shouldBe(visible);
    }

    @Test
    @DisplayName("Отправка формы Вывод средств со счета с использованием кириллических символов в поле Вывести")
    void cyrillicLettersField() {
        $(withText("Выбор офиса обслуживания")).shouldBe(visible);
        $x("//div//span[contains(text(), 'Москва')]").click();
        $("[name='value']").setValue(fakerRU.name().lastName());
        $("[value='Вывести']").click();
        $x("//div//label[contains(text(), 'Поле должно содержать только цифры!')]").shouldBe(visible);
    }

    @Test
    @DisplayName("Отправка формы Вывод средств со счета используя написанное латинскими буквами значение суммы в поле Вывести")
    void latinNumberField() {
        $(withText("Выбор офиса обслуживания")).shouldBe(visible);
        $x("//div//span[contains(text(), 'Москва')]").click();
        $("[name='value']").setValue("one");
        $("[value='Вывести']").click();
        $x("//div//label[contains(text(), 'Поле должно содержать только цифры!')]").shouldBe(visible);
    }

    @Test
    @DisplayName("Отправка формы Вывод средств со счета используя написанное кириллицей значение суммы в поле Вывести")
    void cyrillicNumberField() {
        $(withText("Выбор офиса обслуживания")).shouldBe(visible);
        $x("//div//span[contains(text(), 'Москва')]").click();
        $("[name='value']").setValue("один");
        $("[value='Вывести']").click();
        $x("//div//label[contains(text(), 'Поле должно содержать только цифры!')]").shouldBe(visible);
    }

    @Test
    @DisplayName("Отправка формы Вывод средств со счета используя проценты в поле Вывести")
    void percentNumberField() {
        $(withText("Выбор офиса обслуживания")).shouldBe(visible);
        $x("//div//span[contains(text(), 'Москва')]").click();
        $("[name='value']").setValue("50%");
        $("[value='Вывести']").click();
        $x("//div//label[contains(text(), 'Поле должно содержать только цифры!')]").shouldBe(visible);
    }

    @Test
    @DisplayName("Отправка формы Вывод средств со счета используя отрицательное число в поле Вывести")
    void negativeNumberField() {
        $(withText("Выбор офиса обслуживания")).shouldBe(visible);
        $x("//div//span[contains(text(), 'Москва')]").click();
        $("[name='value']").setValue("-10");
        $("[value='Вывести']").click();
        $x("//div//label[contains(text(), 'Поле должно содержать только цифры!')]").shouldBe(visible);
    }

    @Test
    @DisplayName("Отправка формы Вывод средств со счета используя число c + в поле Вывести")
    void positiveNumberField() {
        $(withText("Выбор офиса обслуживания")).shouldBe(visible);
        $x("//div//span[contains(text(), 'Москва')]").click();
        $("[name='value']").setValue("+10");
        $("[value='Вывести']").click();
        $x("//div//label[contains(text(), 'Поле должно содержать только цифры!')]").shouldBe(visible);
    }

    @Test
    @DisplayName("Отправка формы Вывод средств со счета используя ноль в поле Вывести")
    void boundaryValueZeroShouldNotWork() {
        $(withText("Выбор офиса обслуживания")).shouldBe(visible);
        $x("//div//span[contains(text(), 'Москва')]").click();
        $("[name='value']").setValue("0");
        $("[value='Вывести']").click();
        $x("//div//label[contains(text(), 'Поле должно содержать значение больше 0')]").shouldBe(visible);
    }

    @Test
    @DisplayName("Отправка формы Вывод средств со счета используя число больше суммы на счете в поле Вывести")
    void boundaryValueOverShouldNotWork() {
        $(withText("Выбор офиса обслуживания")).shouldBe(visible);
        $x("//div//span[contains(text(), 'Москва')]").click();
        $("[name='value']").setValue("1221");
        $("[value='Вывести']").click();
        $x("//div//label[contains(text(), 'Значение поля не может быть больше суммы на счете')]").shouldBe(visible);
    }

    @Test
    @DisplayName("Отправка формы Вывод средств со счета используя значение 1 в поле Вывести")
    void boundaryValueOneShouldWork() {
        $(withText("Выбор офиса обслуживания")).shouldBe(visible);
        $x("//div//span[contains(text(), 'Москва')]").click();
        $("[name='value']").setValue("1");
        $("[value='Вывести']").click();
        $("[error]").shouldBe(hidden);
    }

    @Test
    @DisplayName("Отправка формы Вывод средств со счета используя значение 1219.99 в поле Вывести")
    void boundaryValueAlmostMaxShouldWork() {
        $(withText("Выбор офиса обслуживания")).shouldBe(visible);
        $x("//div//span[contains(text(), 'Москва')]").click();
        $("[name='value']").setValue("1219.99");
        $("[value='Вывести']").click();
        $("[error]").shouldBe(hidden);
    }

    @Test
    @DisplayName("Отправка формы Вывод средств со счета используя максимальное значение в поле Вывести")
    void boundaryValueMaxShouldWork() {
        $(withText("Выбор офиса обслуживания")).shouldBe(visible);
        $x("//div//span[contains(text(), 'Москва')]").click();
        $("[name='value']").setValue("1220.00");
        $("[value='Вывести']").click();
        $("[error]").shouldBe(hidden);
    }

    @Test
    @DisplayName("Отправка формы Вывод средств со счета используя чек-бокс Вывести все")
    void outputAllShouldWork() {
        $(withText("Выбор офиса обслуживания")).shouldBe(visible);
        $x("//div//span[contains(text(), 'Москва')]").click();
        $("[id='all']").click();
        $("[value='Вывести']").click();
        $("[error]").shouldBe(hidden);
    }

    @Test
    @DisplayName("Отправка формы Вывод средств с использованием разделителя _ в поле Вывести все")
    void separatorNumber() {
        $(withText("Выбор офиса обслуживания")).shouldBe(visible);
        $x("//div//span[contains(text(), 'Москва')]").click();
        $("[name='value']").setValue("1_220");
        $("[value='Вывести']").click();
        $x("//div//label[contains(text(), 'Поле должно содержать только цифры!')]").shouldBe(visible);
    }

    @Test
    @DisplayName("Отправка формы Вывод средств с использованием разделителя пробел в поле Вывести все")
    void separatorSpaceNumber() {
        $(withText("Выбор офиса обслуживания")).shouldBe(visible);
        $x("//div//span[contains(text(), 'Москва')]").click();
        $("[name='value']").setValue("1 220");
        $("[value='Вывести']").click();
        $x("//div//label[contains(text(), 'Поле должно содержать только цифры!')]").shouldBe(visible);
    }

}
