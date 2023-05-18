package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverGetMethodlari {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        // sisteme WebDriver'in ne olacagini ve bu direver'in hangi dosya yolunda oldugunu soyler

        WebDriver driver = new ChromeDriver();
        // bilgisayarimizdaki chrome browser'in otomasyonla caliscak bir kopyasini olusturur
        // Chrome disinda bir browser kullanmak istersek o browser'in driver'ini indirip
        // System.setProperty("webdriver.safari.driver","safari driver'in dosya yolu");

        // Olusturdugumuz driver objesi bizim elimiz, gozumuz gibidir

        driver.get("https:/www.amazon.com"); // get methodu bizden URL ister bizi istedigimiz URL ' e goturur
        // www yazmazsak da calisir ancak https:// yazmazsak calismaz

        System.out.println(driver.getTitle()); // bize title'i yani basligi döndürür
        // Amazon.com. Spend less. Smile more.

        System.out.println(driver.getCurrentUrl()); // gidilen URL'i döndürür
        //https://www.amazon.com/

        //System.out.println(driver.getPageSource()); // gidilen web sayfanin  kaynak kodlarini döndüren method

        System.out.println(driver.getWindowHandle()); // 732138A6158770EE018FDA838A74B27F
        // acilan her bir pencereye verilen unique hash code degeridir

        System.out.println(driver.getWindowHandles()); // // [B4ECC6D26CD1219B94612A5AEAC4997A]
        // eger driver calisirken birden fazla pencere veya tab olusturduysa
        // acilan tum windows/tab'lerin unique hash kodlarini bir Set<> olarak döndürür

        Thread.sleep(3000); // mili saniye olarak yazdigimiz sayi suresince kadu bekletir

        driver.close(); // acilan borwser'i kapatan method


    }
}
