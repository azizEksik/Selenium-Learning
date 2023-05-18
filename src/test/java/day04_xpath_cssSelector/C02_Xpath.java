package day04_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Xpath {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        Thread.sleep(2000);

        //2- Add Element butonuna basin
        WebElement addElementButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        addElementButton.click();                                             // //button[text()='Add Element']
        Thread.sleep(2000);

        //3- Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButton = driver.findElement(By.xpath("//button[@class='added-manually']"));
        if (deleteButton.isDisplayed()){
            System.out.println("Delete Button Test PASSED");
        }else {
            System.out.println("Delete Button Test FAILED");
        }

        //4- Delete tusuna basin
        deleteButton.click();

        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemoveElement  = driver.findElement(By.xpath("//h3"));

        if (addRemoveElement.isEnabled()){
            System.out.println("Add/Remove Elements Test PASSED");
        }else {
            System.out.println("Add/Remove Elements Test FAILED");
        }

        Thread.sleep(3000);
        driver.close();

    }
}
