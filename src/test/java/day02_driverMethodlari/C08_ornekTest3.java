package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_ornekTest3 {

    public static void main(String[] args) throws InterruptedException {

        //1.Yeni bir class olusturalim (Homework)
        //2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin
        //(title) “facebook” oldugunu dogrulayin (verify), degilse dogru basligi
        //yazdirin.
        //3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa
        //“actual” URL’i yazdirin.
        //4.https://www.walmart.com/ sayfasina gidin.
        //5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        //6. Tekrar “facebook” sayfasina donun
        //7. Sayfayi yenileyin
        //8. Sayfayi tam sayfa (maximize) yapin
        //9.Browser’i kapatin

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.facebook.com");
        Thread.sleep(2000);

        if (driver.getTitle().equals("facebook")){
            System.out.println("Title Test PASSED");
        }else {
            System.out.println("Dogru title : " + driver.getTitle());
        }

        if (driver.getCurrentUrl().contains("facebook")){
            System.out.println("Url Test PASSED");
        }else {
            System.out.println("Dogru Url : " + driver.getCurrentUrl());
        }

        driver.navigate().to("https://www.walmart.com");
        Thread.sleep(2000);

        if (driver.getTitle().contains("Walmart.com")){
            System.out.println("Walmart Title Test PASSED");
        }else {
            System.out.println("Walmart Title Test FAILED");
        }

        driver.navigate().back();
        Thread.sleep(2000);

        driver.navigate().refresh();
        Thread.sleep(2000);

        driver.manage().window().maximize();

        driver.close();
    }
}
