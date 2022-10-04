package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;

    //урл главной страницы
    public final static String URL_MAIN_PAGE = "https://qa-scooter.praktikum-services.ru/";

    //локатор верхней кнопки "Заказать"
    private final By ORDER_BUTTON_TOP = By.xpath(".//div[2]/button[1]");

    //локатор нижней кнопки "Заказать"
    private final By ORDER_BUTTON_BOTTOM = By.xpath(".//div[5]/button");

    //локатор куки-баннера
    private final By COOKIE_BANNER_SUBMIT_BUTTON = By.id("rcc-confirm-button");


    //конструктор класса
    public MainPage (WebDriver driver) {
        this.driver = driver;
    }

    //нажатие верхней кнопки "Заказать"
    public void clickOrderButtonTop() {
        driver.findElement(ORDER_BUTTON_TOP).click();
    }

    //закрыть куки-баннер, если он отображается на странице
    public void closeCookieBanner() {
        if (driver.findElement(COOKIE_BANNER_SUBMIT_BUTTON).isDisplayed()) {
            driver.findElement(COOKIE_BANNER_SUBMIT_BUTTON).click();
        }
    }

    //нажатие нижней кнопки "Заказать"
    public void clickOrderButtonBottom() {

        closeCookieBanner();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(ORDER_BUTTON_BOTTOM));
        driver.findElement(ORDER_BUTTON_BOTTOM).click();
    }
}
