import org.example.MainPage;
import org.example.OrderProfileData;
import org.example.OrderRentData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RunWith(Parameterized.class)
public class CheckOrderPositive {
    private WebDriver driver;
    private final String firstName;
    private final String secondName;
    private final String address;
    private final String metro;
    private final String phone;

    private final String lasting;
    private final String color;
    private final String comment;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy"); // готовим нужный форматтер
    String date = LocalDate.now().format(formatter); // получаем текущую дату и форматируем



    //настройка драйвера
    @Before
    public void setUp(){

        System.setProperty("webdriver.gecko.driver","/Users/irida/Webdriver/bin/geckodriver_2");

        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("marionette", false);

        driver = new FirefoxDriver(options);
        driver.get(MainPage.URL_MAIN_PAGE);
    }

    public CheckOrderPositive(String firstName, String secondName, String address, String metro, String phone, String lasting, String color, String comment) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.address = address;
            this.metro = metro;
            this.phone = phone;
            this.lasting = lasting;
            this.color = color;
            this.comment = comment;
    }

        // Тестовые данные
        @Parameterized.Parameters
        public static Object[][] getProfileData() {
            return new Object[][]{
                    {"Тест", "Тестов", "Адрес", "Сокольники", "89279811062","сутки","черный","blabla"},
                    {"Иван", "Петров", "г.Ульяновск ул. Гончарова 55-29", "Румянцево", "89999811011","четверо суток","серый","Комментарий к заказу"},
            };
        }

        //Проверка успешного оформления заказа с нажатием на нижнюю кнопку "Заказать"
        @Test
        public void checkOrderWithButtonBottomPositive() {
            MainPage mainPage = new MainPage(driver);
            mainPage.clickOrderButtonBottom();
            OrderProfileData orderProfileData = new OrderProfileData(driver);
            orderProfileData.orderFillInProfileData(firstName, secondName, address, metro, phone);
            OrderRentData orderRentData = new OrderRentData(driver);
            orderRentData.orderFillInRentData(date,lasting,color,comment);
        }


        //Проверка успешного оформления заказа с нажатием на верхнюю кнопку "Заказать"
    @Test
    public void checkOrderWithButtonTopPositive() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOrderButtonTop();
        OrderProfileData orderProfileData = new OrderProfileData(driver);
        orderProfileData.orderFillInProfileData(firstName, secondName, address, metro, phone);
        OrderRentData orderRentData = new OrderRentData(driver);
        orderRentData.orderFillInRentData(date,lasting,color,comment);
    }

    //закрытие браузера
    @After
    public void cleanUp(){
        driver.quit();
    }

}
