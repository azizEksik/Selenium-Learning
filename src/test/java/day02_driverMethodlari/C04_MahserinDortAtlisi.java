package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_MahserinDortAtlisi {

    public static void main(String[] args) {

        // 1- Driver icin gerekli ayarlamaları yap
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        // 2- WebDriver olustur
        WebDriver driver = new ChromeDriver();
        // 3- Window'u maximize yap
        driver.manage().window().maximize();
        // 4- gecikmeler icin maximum bekleme süresi tanımla
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // bu 4 adım her testin basinda yapacagimiz islemlerdir
    }
}
