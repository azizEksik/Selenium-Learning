package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_ilkTest {

    public static void main(String[] args) throws InterruptedException {

        //1. Yeni bir package olusturalim : day01
        //2. Yeni bir class olusturalim : C03_GetMethods
        //3. Amazon sayfasina gidelim. https://www.amazon.com/
        //4. Sayfa basligini(title) yazdirin
        //5. Sayfa basliginin “Amazon” icerdigini test edin
        //6. Sayfa adresini(url) yazdirin
        //7. Sayfa url’inin “amazon” icerdigini test edin.
        //8. Sayfa handle degerini yazdirin
        //9. Sayfa HTML kodlarinda “alisveris” kelimesi gectigini test edin
        //10. Sayfayi kapatin.


        // once gerekli ayarlamalari yapip driver objesi olusturmaliyiz

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com");

        System.out.println("sayfa basligi : " + driver.getTitle());

        String expectedIcerik = "Amazon";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedIcerik)){
            System.out.println("sayfa basligi amazon iceriyor, Title TEST PASSED");
        }else {
            System.out.println("sayfa basligi amazon icermiyor, Title TEST FAILED");
        }

        expectedIcerik = "amazon";
        String actulaUrl = driver.getCurrentUrl();

        if (actulaUrl.contains(expectedIcerik)){
            System.out.println("Url amazon iceriyor, Url TEST PASSED");
        }else {
            System.out.println("Url amazon icermiyor, Url TEST FAILED");
        }

        System.out.println("sayfanin handle degeri : " + driver.getWindowHandle());

        expectedIcerik = "alisveris";
        String actualPageSource = driver.getPageSource();

        if (actualPageSource.contains(expectedIcerik)){
            System.out.println("kaynak kodlar alisveris kelimesi iceriyor, Source TEST PASSED");
        }else {
            System.out.println("kaynak kodlar alisveris kelimesi icermiyor, Source TEST FAILED");
        }

        Thread.sleep(3000);
        driver.close();


    }
}
