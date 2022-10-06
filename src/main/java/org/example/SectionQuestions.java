package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


//Секция "Вопросы о важном"
public class SectionQuestions {
    private WebDriver driver;

    //Локатор вопросов
    private final String question = "accordion__heading-"+"%s";

    // Локатор ответов
    private final String answer = "//*[@id='accordion__panel-%s']/p";



    //Локатор секции
    private final By sectionQuestions = By.xpath("//*[@id=\"root\"]/div/div[1]/div[5]/div[1]") ;

    //Конструктор
    public SectionQuestions(WebDriver driver) {
        this.driver = driver;
    }

    //Скролл страницы к сеции "Вопросы о важном"
    public void scrollToSectionQuestions() {
        Object element = driver.findElement(sectionQuestions);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //Раскрытие вопроса
    public void expandQuestion(String numberQuestion){
        String stringElement = String.format(question, numberQuestion);
        By questionElement = By.id(stringElement);

        driver.findElement(questionElement).click();
    }

    //Получение текста ответа
    public String showAnswer(String numberAnswer){
        String stringElement = String.format(answer, numberAnswer);
        By answerElement = By.xpath(stringElement);

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(answerElement)));
            return driver.findElement(answerElement).getText();
    }
}
