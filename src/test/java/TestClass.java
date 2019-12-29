import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;

public class TestClass extends TestBase {


    @Test
    public void LaunchSite() {

        d.get("https://www.myresponsee.com/");
        d.manage().window().maximize();
        //d.findElement(By.xpath("//*[@id=\"home-mobile\"]/div/a")).click();
        //Assert.assertEquals(d.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText(),"Built on Response");
        System.out.println(d.getTitle());
    }

    @AfterTest
    public void killDriver() {
        d.quit();
    }
}
