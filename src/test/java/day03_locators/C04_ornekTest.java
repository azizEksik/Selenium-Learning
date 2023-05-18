package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_ornekTest {

    public static void main(String[] args) throws InterruptedException {

        //1- Bir test class’i olusturun ilgili ayarlari yapin
        //2- https://www.automationexercise.com/ adresine gidin
        //3- Sayfada 147 adet link bulundugunu test edin.
        //4- Products linkine tiklayin
        //5- special offer yazisinin gorundugunu test edin
        //6- Sayfayi kapatin

        System.setProperty("webdrive.chrome.drive","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.automationexercise.com/");

        List<WebElement> listLinkWebElements = driver.findElements(By.tagName("a"));

        if (listLinkWebElements.size()==147){
            System.out.println("Link sayisi : " +listLinkWebElements.size()+", Test PASSED" );
        }else {
            System.out.println("Link sayisi : " +listLinkWebElements.size()+", Test FAILED" );
        }

        WebElement productsElement = driver.findElement(By.partialLinkText("Products"));

        productsElement.click();

        WebElement specialOfferElement = driver.findElement(By.id("sale_image"));

        if (specialOfferElement.isDisplayed()){
            System.out.println("specialOffer Test PASSED");
        }else {
            System.out.println("specialOffer Test FAILED");
        }


        Thread.sleep(2000);
        driver.close();
    }
}
