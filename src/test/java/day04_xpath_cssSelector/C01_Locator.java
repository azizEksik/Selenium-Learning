package day04_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;

public class C01_Locator {

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1- https://www.amazon.com/ sayfasına gidin.
        driver.get("https://www.amazon.com");

        //2- Arama kutusuna “city bike” yazip aratin
        WebElement searchButtonElement = driver.findElement(By.id("twotabsearchtextbox"));
        searchButtonElement.sendKeys("city bike" + Keys.ENTER);

        //3- Görüntülenen sonuçların sayısını yazdırın
        WebElement sonucSayisi = driver.findElement(By.className("sg-col-inner"));

        System.out.println(sonucSayisi.getText()); // 1-16 of 244 results for "city bike"

        //4- Listeden ilk urunun resmine tıklayın.

        WebElement ilkResimTikla = driver.findElement(By.xpath("//img[@src='https://m.media-amazon.com/images/I/71DpJTRRvkL._AC_UY218_.jpg']"));
        ilkResimTikla.click();

        Thread.sleep(3000);
        driver.close();
    }
}
