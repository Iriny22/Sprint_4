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


    //настройка драйвера
    @Before
    public void setUp(){

        System.setProperty("webdriver.gecko.driver","/Users/irida/Webdriver/bin/geckodriver_2");

        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("marionette", false);

        driver = new FirefoxDriver(options);
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
        public void CheckOrderWithButtonBottomPositive() {
            String date = LocalDate.now().toString().replace("-",".");
            // переход на страницу тестового приложения
            driver.get("https://qa-scooter.praktikum-services.ru/");

            MainPage objMainPage = new MainPage(driver);
            objMainPage.clickOrderButtonBottom();
            OrderProfileData objOrder = new OrderProfileData(driver);

            objOrder.orderFillInProfileData(firstName, secondName, address, metro, phone);
            OrderRentData objOrderRentData = new OrderRentData(driver);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy"); // готовим нужный форматтер

            objOrderRentData.orderFillInRentData(date,lasting,color,comment);
        }


        //Проверка успешного оформления заказа с нажатием на верхнюю кнопку "Заказать"
    @Test
    public void CheckOrderWithButtonTopPositive() {
       String date = LocalDate.now().toString().replace("-",".");
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOrderButtonTop();
        OrderProfileData objOrder = new OrderProfileData(driver);

        objOrder.orderFillInProfileData(firstName, secondName, address, metro, phone);
        OrderRentData objOrderRentData = new OrderRentData(driver);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy"); // готовим нужный форматтер

        objOrderRentData.orderFillInRentData(date,lasting,color,comment);
    }



    //закрытие браузера
    @After
    public void cleanUp(){
        driver.quit();
    }

}
