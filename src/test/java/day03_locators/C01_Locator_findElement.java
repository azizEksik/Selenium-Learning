package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Locator_findElement {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // amazon ana sayfaya gidin
        driver.get("https://www.amazon.com");

        // arama kutusuna Nutella yazdırıp
        /*
            Test otomasyonu yaparken
            bir webelementi kullanmak istersek 2 seye ihtiyacimiz var
            1- o webelementi benzersiz olarak tarif edebilecegimiz bir locator
            2- bu locator'i soyledigimizde bize webelementi bulup getirecek method

            ornegin amazon sitesindeki arama kutusunun unique tarif edicisi olarak
            id = "twotabsearchtextbox" kullanabiliriz
         */

        WebElement aramaKutusuElementi =driver.findElement(By.id("twotabsearchtextbox"));
        // findElement(By.) web elementi bulan method, icine yazdıgımız By ise locator'u beliledigimiz method

        /*
            findElement() verdigimiz locator turu ve o lacator icin verdigimiz degere gore
            weblementi arar
            locator icin verdigimiz deger hatali ise veya
            locator stratejisinde hata yaptiysak
            aranan webelementi implicitlyWait tanimladigimiz
            maximum sure boyunca arar
            bulmadigi icin "NoSuchElementException" firlatir ve
            kodlarin kalanini calistirmaz
         */

        aramaKutusuElementi.sendKeys("Nutella");
        // istenen webelemente istenen yaziyi gonderen method

        // Enter tusuna basarak arama yapin
        aramaKutusuElementi.submit();
        // istenen web elementi üzerinde enter tusuna basan method

        Thread.sleep(5000);
        driver.close();
    }
}
