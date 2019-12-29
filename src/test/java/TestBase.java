import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/*@CucumberOptions(
        features = "src/main/resources/Features",

)*/

public class TestBase {

    WebDriver d;
    DesiredCapabilities dc;

    @BeforeTest(enabled = false)
    public void initDockerRun() throws MalformedURLException {
        dc=DesiredCapabilities.chrome();
        dc.setCapability("version","");
        //dc.setPlatform(Platform.LINUX);
        d=new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"),dc);
        d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeTest(enabled = true)
    public void initLocal(){
        WebDriverManager.chromedriver().setup();
        d=new ChromeDriver();
        d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

}
