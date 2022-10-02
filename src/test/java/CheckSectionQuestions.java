import org.example.SectionQuestions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


//Проверка секции "Вопросы о важном"
public class CheckSectionQuestions {
    private WebDriver driver;

    //настройка драйвера
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/irida/Webdriver/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
    }

    @Test
    public void expandQuestion0ShowCorrectText(){

        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        String expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";

        SectionQuestions ObjQuestion0 = new SectionQuestions(driver);
        ObjQuestion0.scrollToSectionQuestions();
        ObjQuestion0.expandQuestion(SectionQuestions.QUESTION0);
        String actual = ObjQuestion0.showAnswer(SectionQuestions.ANSWER0);
        Assert.assertEquals("Текст не соответствует ожидаемому!", expected,actual);

    }

    @Test
    public void expandQuestion1ShowCorrectText(){

        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        String expected = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";

        SectionQuestions ObjQuestion1 = new SectionQuestions(driver);
        ObjQuestion1.scrollToSectionQuestions();
        ObjQuestion1.expandQuestion(SectionQuestions.QUESTION1);
        String actual = ObjQuestion1.showAnswer(SectionQuestions.ANSWER1);
        Assert.assertEquals("Текст не соответствует ожидаемому!",expected,actual);

    }

    @Test
    public void expandQuestion2ShowCorrectText(){

        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        String expected = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";

        SectionQuestions ObjQuestion2 = new SectionQuestions(driver);
        ObjQuestion2.scrollToSectionQuestions();
        ObjQuestion2.expandQuestion(SectionQuestions.QUESTION2);
        String actual = ObjQuestion2.showAnswer(SectionQuestions.ANSWER2);
        Assert.assertEquals("Текст не соответствует ожидаемому!", expected,actual);

    }

    @Test
    public void expandQuestion3ShowCorrectText(){

        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        String expected = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";

        SectionQuestions ObjQuestion3 = new SectionQuestions(driver);
        ObjQuestion3.scrollToSectionQuestions();
        ObjQuestion3.expandQuestion(SectionQuestions.QUESTION3);
        String actual = ObjQuestion3.showAnswer(SectionQuestions.ANSWER3);
        Assert.assertEquals("Текст не соответствует ожидаемому!", expected,actual);

    }

    @Test
    public void expandQuestion4ShowCorrectText(){

        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        String expected = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";

        SectionQuestions ObjQuestion4 = new SectionQuestions(driver);
        ObjQuestion4.scrollToSectionQuestions();
        ObjQuestion4.expandQuestion(SectionQuestions.QUESTION4);
        String actual = ObjQuestion4.showAnswer(SectionQuestions.ANSWER4);
        Assert.assertEquals("Текст не соответствует ожидаемому!", expected,actual);

    }
    @Test
    public void expandQuestion5ShowCorrectText(){

        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        String expected = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";

        SectionQuestions ObjQuestion5 = new SectionQuestions(driver);
        ObjQuestion5.scrollToSectionQuestions();
        ObjQuestion5.expandQuestion(SectionQuestions.QUESTION5);
        String actual = ObjQuestion5.showAnswer(SectionQuestions.ANSWER5);
        Assert.assertEquals("Текст не соответствует ожидаемому!", expected,actual);

    }
    @Test
    public void expandQuestion6ShowCorrectText(){

        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        String expected = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";

        SectionQuestions ObjQuestion6 = new SectionQuestions(driver);
        ObjQuestion6.scrollToSectionQuestions();
        ObjQuestion6.expandQuestion(SectionQuestions.QUESTION6);
        String actual = ObjQuestion6.showAnswer(SectionQuestions.ANSWER6);
        Assert.assertEquals("Текст не соответствует ожидаемому!", expected,actual);

    }
    @Test
    public void expandQuestion7ShowCorrectText(){

        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        String expected = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

        SectionQuestions ObjQuestion7 = new SectionQuestions(driver);
        ObjQuestion7.scrollToSectionQuestions();
        ObjQuestion7.expandQuestion(SectionQuestions.QUESTION7);
        String actual = ObjQuestion7.showAnswer(SectionQuestions.ANSWER7);
        Assert.assertEquals("Текст не соответствует ожидаемому!", expected,actual);
    }

//закрытие браузера
    @After
    public void cleanUp(){
        driver.quit();
    }

}
