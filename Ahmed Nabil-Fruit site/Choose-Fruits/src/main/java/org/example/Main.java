package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;


public class Main {

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    static String promoCode = "Bla Bla Bla";

    protected static By cart = By.cssSelector("[alt='Cart']");
    protected static By proceed_btn = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
    protected static By promoCode_txtBox = By.className("promoCode");
    protected static By promoCodeInfo_msg = By.className("promoInfo");
    protected static By placeOrder_btn = By.xpath("//button[text()='Place Order']");

    // Setup WebDriver
    public static void initWeb() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    static List<String> productsToAdd = Arrays.asList(
            "Cucumber - 1 Kg",
            "Carrot - 1 Kg",
            "Potato - 1 Kg",
            "Capsicum"
    );

    public static void addProductsToCart(List<String> products) {
        for (String product : products) {
            String xpath = String.format("//h4[text()='%s']/following-sibling::div/button", product);
            driver.findElement(By.xpath(xpath)).click();
        }
    }

    public static void goToCart() {
        driver.findElement(cart).click();
        driver.findElement(proceed_btn).click();
    }

    public static String applyPromoCode(String promoCode) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(promoCode_txtBox)).sendKeys(promoCode);
        driver.findElement(By.className("promoBtn")).click();
        return wait.until(ExpectedConditions.visibilityOfElementLocated(promoCodeInfo_msg)).getText();
    }

    public static void placeOrder() {
        driver.findElement(placeOrder_btn).click();
    }

    public static void tearDown() {
        driver.quit();
    }

    public static void main(String[] args) {
        initWeb();
        addProductsToCart(productsToAdd);
        goToCart();
        System.out.println(applyPromoCode(promoCode));
        placeOrder();
        tearDown();

    }
}