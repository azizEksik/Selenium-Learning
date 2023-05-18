package day02_driverMethodlari;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_ornekTest2 {
    public static void main(String[] args) throws InterruptedException {

        //1. Yeni bir Class olusturalim.C07_ManageWindowSet
        //2. Amazon soyfasina gidelim. https://www.amazon.com/
        //3. Sayfanin konumunu ve boyutlarini yazdirin
        //4. Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        //5. Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
        //8. Sayfayi kapatin

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://wwww.amazon.com");
        Thread.sleep(2000);

        System.out.println("Sayfanın konumu : " + driver.manage().window().getPosition());
        System.out.println("Sayfanın boyutu : " + driver.manage().window().getSize());

        driver.manage().window().setPosition(new Point(1000,600));
        driver.manage().window().setSize(new Dimension(1000,1000));
        Thread.sleep(2000);

        Point expectedPosition = driver.manage().window().getPosition();
        Dimension expectedSize = driver.manage().window().getSize();

        if (expectedPosition.toString().equals("(1000, 600)") &&
            expectedSize.toString().equals("(1000, 1000)")){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }

        driver.close();

    }
}
