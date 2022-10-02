package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//страница заполнения данных заказчика
public class OrderProfileData {
    private WebDriver driver;

    //локатор поля "Имя"
    private final static By FIRST_NAME = By.xpath(".//div[@class='Order_Form__17u6u']/div/input[@placeholder='* Имя']");

    //локатор поля "Фамилия"
    private final static By SECOND_NAME = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/input");

    //локатор поля "Адрес"
    private final static By ADDRESS = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[3]/input");

    //локатор поля "Станция метро"
    private final static By METRO = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/div/div[1]/input");

    //локатор раскрывающегося списка станций метро
    private final static String METRO_EXPANDED = ".//div[@class='Order_Text__2broi' and text()='%s']";

    //локатор поля "Телефон"
    private final static By PHONE = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[5]/input");

    //локатор кнопки "Далее"
    private final static By NEXT_BUTTON = By.xpath("//*[@id='root']/div/div[2]/div[3]/button");

    //конструктор
    public OrderProfileData(WebDriver driver) {
        this.driver = driver;
    }
    //заполнить форму
    public void orderFillInProfileData(String name, String surname, String address, String metro, String phone) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(FIRST_NAME)));
        driver.findElement(FIRST_NAME).sendKeys(name);
        driver.findElement(SECOND_NAME).sendKeys(surname);
        driver.findElement(ADDRESS).sendKeys(address);
        fillInStation(metro);
        driver.findElement(PHONE).sendKeys(phone);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(NEXT_BUTTON)) );
        driver.findElement(NEXT_BUTTON).click();

    }

    public void fillInStation(String metro) {

        driver.findElement(METRO).sendKeys(metro);
        String stringElement = String.format(METRO_EXPANDED, metro);
        By stationElement = By.xpath(stringElement);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(stationElement)));

        driver.findElement(stationElement).click();

    }

}
