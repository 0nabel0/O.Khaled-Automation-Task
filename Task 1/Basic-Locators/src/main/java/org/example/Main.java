package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/register");
        driver.findElement(By.id("FirstName")).sendKeys("Ahmed");
        driver.findElement(By.name("LastName")).sendKeys("Nabil");
        driver.findElement(By.cssSelector("input[type='email']")).sendKeys("aahmeed.naabeel@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("123456");
        driver.findElement(By.cssSelector("button[class='button-1 register-next-step-button']")).click();
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.xpath("//input[@class='email']")).sendKeys("aahmeed.naabeel@gmail.com");
        driver.findElement(By.cssSelector("input[class='password']")).sendKeys("123456");
    }

}