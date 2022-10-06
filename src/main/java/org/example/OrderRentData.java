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
    private final By whenDate = By.xpath(".//div[@class='react-datepicker__input-container']/input[@placeholder='* Когда привезти самокат']");


    //локатор для текущей даты в календаре
    private final By nowDate = By.xpath(".//div[@class=\"react-datepicker__month-container\"]/div[2]/div/div[@tabindex=\"0\"]");

    //локатор - срок аренды
    private final By lasting = By.className("Dropdown-placeholder");

    //локатор список сроков аренды
    private final String listLastingExpanded = ".//div[@class='Dropdown-menu' and @aria-expanded='true']/div[text() = '%s']";


    //локатор - цвет самоката (черный)
    private final By colorBlack = By.id("black");

    //локатор - цвет самоката (серый)
    private final By colorGrey = By.id("grey");

    //локатор - комментарий для курьера
    private final By comment = By.xpath(".//div[@class='Order_Form__17u6u']/div/input[@placeholder=\"Комментарий для курьера\"]");

    //кнопка Заказать
    private final By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[2]");

    //окно подтверждения заказа
    private final By windowSubmitOrder = By.className("Order_Modal__YZ-d3");

    //кнопка подтверждения заказа
    private final By submitOrderButton = By.xpath(".//div[@class=\"Order_Buttons__1xGrp\"]/button[text()='Да']");

    //заказ оформлен
    private final By successOrderStatus = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[text()='Заказ оформлен']");

    public OrderRentData (WebDriver driver) {
        this.driver = driver;
    }

    public void orderFillInRentData(String whenDate, String lasting, String color, String comment) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(driver.findElement(this.whenDate)));
        driver.findElement(this.whenDate).sendKeys(whenDate);
        driver.findElement(nowDate).click();
        driver.findElement(this.lasting).click();
        String stringElement = String.format(listLastingExpanded, lasting);
        By lastingElement = By.xpath(stringElement);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(driver.findElement(lastingElement)));
        driver.findElement(lastingElement).click();

        fillInColor(color);

        driver.findElement(this.comment).sendKeys(comment);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(orderButton)) );
        driver.findElement(orderButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(submitOrderButton)) );
        driver.findElement(submitOrderButton).click();
         checkSuccessOrderStatus();

    }

    public void checkSuccessOrderStatus() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(driver.findElement(successOrderStatus)));
    }

    public void fillInColor (String color) {
        if (color.equals("черный")) {
            driver.findElement(colorBlack).click();
        }
        else if(color.equals("серый")) {
            driver.findElement(colorGrey).click();
        }
    }
}
