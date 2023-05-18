package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_WebElementMethodlari {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // amazon ana sayfaya gidip arama kutusunu locate edelim

        driver.get("https://www.amazon.com");

        WebElement aramaKutusuWebElementi = driver.findElement(By.id("twotabsearchtextbox"));

        System.out.println(aramaKutusuWebElementi.isDisplayed()); // true
        // web elementinin görünür olup olmadıgını kontrol eder, true ya da false döner

        System.out.println(aramaKutusuWebElementi.isEnabled()); // true
        // web elementinin erişilebilir olup olmadığını kontrol eder, true ya da false döner

        System.out.println(aramaKutusuWebElementi.getText()); // ""
        // elementin uzerindeki yaziyi getirir, elementin üzerinde yazi yoksa hiçlik getirir

        aramaKutusuWebElementi.sendKeys("Nutella"); // isdegimiz yaziyi göderen method
        Thread.sleep(2000);

        aramaKutusuWebElementi.clear(); // gönderdiğimiz yazıyı temizleyen method

        System.out.println(aramaKutusuWebElementi.getSize()); // (1132, 38)
        // web elementin boyutunu getiren method

        System.out.println(aramaKutusuWebElementi.getTagName()); // input
        // web elemntinin html tag'inin adını getiren method

        System.out.println(aramaKutusuWebElementi.getAttribute("class")); // nav-input nav-progressive-attribute
        // web elmentinin attribute adını getiren method

        System.out.println(aramaKutusuWebElementi.getLocation()); // (295, 11)
        // web elementin pixel olarak konumunu veren method



        Thread.sleep(3000);
        driver.close();
    }

















}
