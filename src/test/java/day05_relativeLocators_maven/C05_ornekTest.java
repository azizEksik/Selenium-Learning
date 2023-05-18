package day05_relativeLocators_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;

public class C05_ornekTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- C01_TekrarTesti isimli bir class olusturun
        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        //3- cookies uyarisini kabul ederek kapatin
        //4- Sayfa basliginin “Google” ifadesi icerdigini test edin
        if (driver.getTitle().contains("Google")){
            System.out.println("Title Test PASSED");
        }else {
            System.out.println("Title Test FILED");
        }

        //5- Arama cubuguna “Nutella” yazip aratin
        WebElement searchButton = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        searchButton.sendKeys("Nutella" + Keys.ENTER);

        //6- Bulunan sonuc sayisini yazdirin
        String aramaSonucuSayisi = driver.findElement(By.xpath("//div[@id='result-stats']")).getText();
        System.out.println(aramaSonucuSayisi);

        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        aramaSonucuSayisi = aramaSonucuSayisi.replaceAll("\\D","");
        double sonucSayisi= Double.parseDouble(aramaSonucuSayisi);

        if (sonucSayisi>10000000){
            System.out.println("Sonuc Sayisi Testi PASSED");
        }else {
            System.out.println("Sonuc Sayisi Testi FAILED");
        }

        //8- Sayfayi kapatin

        Thread.sleep(2000);
        driver.close();
    }
}
