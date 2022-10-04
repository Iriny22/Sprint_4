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

    //Локаторы вопросов - константы
    public final static By QUESTION0 = By.id("accordion__heading-0");
    public final static By QUESTION1 = By.id("accordion__heading-1");
    public final static By QUESTION2 = By.id("accordion__heading-2");
    public final static By QUESTION3 = By.id("accordion__heading-3");
    public final static By QUESTION4 = By.id("accordion__heading-4");
    public final static By QUESTION5 = By.id("accordion__heading-5");
    public final static By QUESTION6 = By.id("accordion__heading-6");
    public final static By QUESTION7 = By.id("accordion__heading-7");

    // Локаторы ответов - константы
    public final static By ANSWER0 = By.xpath("//*[@id='accordion__panel-0']/p");
    public final static By ANSWER1 = By.xpath("//*[@id='accordion__panel-1']/p");
    public final static By ANSWER2 = By.xpath("//*[@id='accordion__panel-2']/p");
    public final static By ANSWER3 = By.xpath("//*[@id='accordion__panel-3']/p");
    public final static By ANSWER4 = By.xpath("//*[@id='accordion__panel-4']/p");
    public final static By ANSWER5 = By.xpath("//*[@id='accordion__panel-5']/p");
    public final static By ANSWER6 = By.xpath("//*[@id='accordion__panel-6']/p");
    public final static By ANSWER7 = By.xpath("//*[@id='accordion__panel-7']/p");


    //Локатор секции
    private final By SECTION_QUESTIONS = By.xpath("//*[@id=\"root\"]/div/div[1]/div[5]/div[1]") ;

    //Конструктор
    public SectionQuestions(WebDriver driver) {
        this.driver = driver;
    }

    //Скролл страницы к сеции "Вопросы о важном"
    public void scrollToSectionQuestions() {
        Object element = driver.findElement(SECTION_QUESTIONS);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //Раскрытие вопроса
    public void expandQuestion(By question){
        driver.findElement(question).click();
    }

    //Получение текста ответа
    public String showAnswer(By answer){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(answer)));
            return driver.findElement(answer).getText();
    }
}
