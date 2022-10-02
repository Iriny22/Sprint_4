package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


//страница заполнения информации об аренде
public class OrderRentData {
    private WebDriver driver;

    //локатор, когда привезти самокат
    private final static By WHEN_DATE = By.xpath(".//div[@class='react-datepicker__input-container']/input[@placeholder='* Когда привезти самокат']");


    //локатор для текущей даты в календаре
    private final static By NOW_DATE = By.xpath(".//div[@class=\"react-datepicker__month-container\"]/div[2]/div/div[@tabindex=\"0\"]");

    //локатор - срок аренды
    private final static By LASTING = By.className("Dropdown-placeholder");

    //локатор список сроков аренды
    private final static String LIST_LASTING_EXPANDED = ".//div[@class='Dropdown-menu' and @aria-expanded='true']/div[text() = '%s']";


    //локатор - цвет самоката (черный)
    private final static By COLOR_BLACK = By.id("black");

    //локатор - цвет самоката (серый)
    private final static By COLOR_GREY = By.id("grey");

    //локатор - комментарий для курьера
    private final static By COMMENT = By.xpath(".//div[@class='Order_Form__17u6u']/div/input[@placeholder=\"Комментарий для курьера\"]");

    //кнопка Заказать
    private final static By ORDER_BUTTON = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[2]");

    //окно подтверждения заказа
    private final static By WINDOW_SUBMIT_ORDER = By.className("Order_Modal__YZ-d3");

    //кнопка подтверждения заказа
    private final static By SUBMIT_ORDER_BUTTON = By.xpath(".//div[@class=\"Order_Buttons__1xGrp\"]/button[text()='Да']");

    //заказ оформлен
    private final static By SUCCESS_ORDER_STATUS = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[text()='Заказ оформлен']");

    public OrderRentData (WebDriver driver) {
        this.driver = driver;
    }

    public void orderFillInRentData(String whenDate, String lasting, String color, String comment) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(driver.findElement(WHEN_DATE)));
        driver.findElement(WHEN_DATE).sendKeys(whenDate);
        driver.findElement(NOW_DATE).click();
        driver.findElement(LASTING).click();
        String stringElement = String.format(LIST_LASTING_EXPANDED, lasting);
        By lastingElement = By.xpath(stringElement);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(driver.findElement(lastingElement)));
        driver.findElement(lastingElement).click();

        fillInColor(color);

        driver.findElement(COMMENT).sendKeys(comment);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(ORDER_BUTTON)) );
        driver.findElement(ORDER_BUTTON).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(SUBMIT_ORDER_BUTTON)) );
        driver.findElement(SUBMIT_ORDER_BUTTON).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(driver.findElement(SUCCESS_ORDER_STATUS)));

    }

    public void fillInColor (String color) {
        if (color == "черный") {
            driver.findElement(COLOR_BLACK).click();
        } else driver.findElement(COLOR_GREY).click();
    }
}
