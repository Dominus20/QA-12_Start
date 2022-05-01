package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class StartSelenium {

    WebDriver webDriver;

    @BeforeMethod
    public void init(){
        webDriver = new ChromeDriver();
       // webDriver.get("https://contacts-app.tobbymarshall815.vercel.app/login");//without history

        webDriver.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/login"); // with history
       // webDriver.navigate().refresh();
       // webDriver.navigate().forward();
       // webDriver.navigate().back();

    }

    @Test
    public void firstTest(){
        WebElement element =  webDriver.findElement(By.tagName("div"));
        List<WebElement> list = webDriver.findElements(By.tagName("a"));



    }

    @AfterMethod
    public void tearDown(){
       // webDriver.quit();
       // webDriver.close();

    }
}
