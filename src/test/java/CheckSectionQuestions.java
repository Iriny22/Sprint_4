import org.example.MainPage;
import org.example.SectionQuestions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
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
        // переход на страницу тестового приложения
        driver.get(MainPage.URL_MAIN_PAGE);
    }



    @Test
    public void expandQuestion0ShowCorrectText(){
        String expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";

        SectionQuestions sectionQuestions = new SectionQuestions(driver);
        sectionQuestions.scrollToSectionQuestions();
        sectionQuestions.expandQuestion("0");
        String actual = sectionQuestions.showAnswer("0");
        Assert.assertEquals("Текст не соответствует ожидаемому!", expected,actual);

    }

    @Test
    public void expandQuestion1ShowCorrectText(){
        String expected = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";

        SectionQuestions sectionQuestions = new SectionQuestions(driver);
        sectionQuestions.scrollToSectionQuestions();
        sectionQuestions.expandQuestion("1");
        String actual = sectionQuestions.showAnswer("1");
        Assert.assertEquals("Текст не соответствует ожидаемому!",expected,actual);

    }

    @Test
    public void expandQuestion2ShowCorrectText(){
        String expected = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";

        SectionQuestions sectionQuestions = new SectionQuestions(driver);
        sectionQuestions.scrollToSectionQuestions();
        sectionQuestions.expandQuestion("2");
        String actual = sectionQuestions.showAnswer("2");
        Assert.assertEquals("Текст не соответствует ожидаемому!", expected,actual);

    }

    @Test
    public void expandQuestion3ShowCorrectText(){
        String expected = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";

        SectionQuestions sectionQuestions = new SectionQuestions(driver);
        sectionQuestions.scrollToSectionQuestions();
        sectionQuestions.expandQuestion("3");
        String actual = sectionQuestions.showAnswer("3");
        Assert.assertEquals("Текст не соответствует ожидаемому!", expected,actual);

    }

    @Test
    public void expandQuestion4ShowCorrectText(){
        String expected = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";

        SectionQuestions sectionQuestions = new SectionQuestions(driver);
        sectionQuestions.scrollToSectionQuestions();
        sectionQuestions.expandQuestion("4");
        String actual = sectionQuestions.showAnswer("4");
        Assert.assertEquals("Текст не соответствует ожидаемому!", expected,actual);

    }
    @Test
    public void expandQuestion5ShowCorrectText(){
        String expected = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";

        SectionQuestions sectionQuestions = new SectionQuestions(driver);
        sectionQuestions.scrollToSectionQuestions();
        sectionQuestions.expandQuestion("5");
        String actual = sectionQuestions.showAnswer("5");
        Assert.assertEquals("Текст не соответствует ожидаемому!", expected,actual);

    }
    @Test
    public void expandQuestion6ShowCorrectText(){
        String expected = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";

        SectionQuestions sectionQuestions = new SectionQuestions(driver);
        sectionQuestions.scrollToSectionQuestions();
        sectionQuestions.expandQuestion("6");
        String actual = sectionQuestions.showAnswer("6");
        Assert.assertEquals("Текст не соответствует ожидаемому!", expected,actual);

    }
    @Test
    public void expandQuestion7ShowCorrectText(){
        String expected = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

        SectionQuestions sectionQuestions = new SectionQuestions(driver);
        sectionQuestions.scrollToSectionQuestions();
        sectionQuestions.expandQuestion("7");
        String actual = sectionQuestions.showAnswer("7");
        Assert.assertEquals("Текст не соответствует ожидаемому!", expected,actual);
    }

//закрытие браузера
    @After
    public void cleanUp(){
        driver.quit();
    }

}
