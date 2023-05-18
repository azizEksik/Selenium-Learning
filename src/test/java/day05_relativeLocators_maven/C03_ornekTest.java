package day05_relativeLocators_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ornekTest {
    public static void main(String[] args) throws InterruptedException {

        //1- https://www.amazon.com/ sayfasina gidelim
        //2- arama kutusunu locate edelim
        //3- “Samsung headphones” ile arama yapalim
        //4- Bulunan sonuc sayisini yazdiralim
        //5- Ilk urunu tiklayalim
        //6- Sayfadaki tum basliklari yazdiralim

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");

        //2- arama kutusunu locate edelim
        WebElement searchElement = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        //3- “Samsung headphones” ile arama yapalim
        searchElement.sendKeys("Samsung headphones");
        searchElement.submit();

        //4- Bulunan sonuc sayisini yazdiralim
        System.out.println(driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText());
        //5- Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
        //6- Sayfadaki tum basliklari yazdiralim
        System.out.println(driver.getTitle());

        Thread.sleep(2000);
        driver.close();
    }
}
