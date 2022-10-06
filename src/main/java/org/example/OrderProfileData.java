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
    private final By firstName = By.xpath(".//div[@class='Order_Form__17u6u']/div/input[@placeholder='* Имя']");

    //локатор поля "Фамилия"
    private final By secondName = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/input");

    //локатор поля "Адрес"
    private final By address = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[3]/input");

    //локатор поля "Станция метро"
    private final By metro = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/div/div[1]/input");

    //локатор раскрывающегося списка станций метро
    private final String metroExpanded = ".//div[@class='Order_Text__2broi' and text()='%s']";

    //локатор поля "Телефон"
    private final By phone = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[5]/input");

    //локатор кнопки "Далее"
    private final By nextButton = By.xpath("//*[@id='root']/div/div[2]/div[3]/button");

    //конструктор
    public OrderProfileData(WebDriver driver) {
        this.driver = driver;
    }

    //заполнить форму
    public void orderFillInProfileData(String name, String surname, String address, String metro, String phone) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(firstName)));
        driver.findElement(firstName).sendKeys(name);
        driver.findElement(secondName).sendKeys(surname);
        driver.findElement(this.address).sendKeys(address);
        fillInStation(metro);
        driver.findElement(this.phone).sendKeys(phone);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(nextButton)) );
        driver.findElement(nextButton).click();
    }

    public void fillInStation(String metro) {

        driver.findElement(this.metro).sendKeys(metro);
        String stringElement = String.format(metroExpanded, metro);
        By stationElement = By.xpath(stringElement);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(stationElement)));

        driver.findElement(stationElement).click();

    }
}
