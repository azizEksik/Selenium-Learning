package day02_driverMethodlari;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_DriverManageMethodlari {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");

        /*
            System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");

            Selenium 4.7 versiyonu ile kendi driver'ini sisteme ekledi
            Kodlar calismaya başladığında biz driver için yol göstermezsek
            Selenium kendi driver'ini devreye sokuyor
            Ama baslangıçta driver ayarı aradığı için biraz yavaş çalışır


            driver.manage().window().istenenAyar ile window'umuzu istediğimiz boyuta getirebilir
            veya window'un konum ve büyüklük bilgilerine ulaşabiliriz

            Biz genelde bir teste baslamadan once
            window'u maximize yapmayi tercih ederiz
         */

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        /*
            implicitlyWait() bir web sayfasi acilincaya veya
            aradıgımız elemntler bulununcaya kadar
            driver'in bekleyecegi maximum sureyi belirler
         */

        driver.get("https://www.amazon.com");

        System.out.println("Baslangıcta konum : " + driver.manage().window().getPosition()); // konumu döndürür
        // Baslangıcta konum : (10, 10)
        System.out.println("Baslangıcta boyut : " + driver.manage().window().getSize()); // boyutu döndürür
        // Baslangıcta boyut : (945, 1020)

        Thread.sleep(1000);
        driver.manage().window().maximize();

        System.out.println("Maximize konum : " + driver.manage().window().getPosition());
        // Maximize konum : (-8, -8)
        System.out.println("Maximize boyut : " + driver.manage().window().getSize());
        // Maximize boyut : (1936, 1056)

        Thread.sleep(1000);
        driver.manage().window().fullscreen(); // ekrani fullscreen yapar

        System.out.println("fullscreen konum : " + driver.manage().window().getPosition());
        // fullscreen konum : (0, 0)
        System.out.println("fullscreen boyut : " + driver.manage().window().getSize());
        // fullscreen boyut : (1920, 1080)

        Thread.sleep(1000);
        driver.manage().window().minimize();

        System.out.println("minimize konum : " + driver.manage().window().getPosition());
        // minimize konum : (10, 10)
        System.out.println("minimize boyut : " + driver.manage().window().getSize());
        // minimize boyut : (945, 1020)

        // pencereyi istediğimiz boyut ve konuma getirelim

        Thread.sleep(1000);
        driver.manage().window().setPosition(new Point(50,50));
        driver.manage().window().setSize(new Dimension(500,500));

        System.out.println("istedigiz(set) konum : " + driver.manage().window().getPosition());
        // istedigiz(set) konum : (50, 50)
        System.out.println("istedigimiz(set) boyut : " + driver.manage().window().getSize());
        // istedigimiz(set) boyut : (516, 500)


        Thread.sleep(3000);
        driver.close();
    }
}
