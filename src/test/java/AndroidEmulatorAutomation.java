import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class AndroidEmulatorAutomation {

    AndroidDriver driver;

    @BeforeClass
    public void setupAppiumAndroid() throws MalformedURLException, URISyntaxException {
        UiAutomator2Options options=new UiAutomator2Options();
        options.setDeviceName("Appium Emulator");
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
//        not installed app in device
//        options.setApp(System.getProperty("user.dir")+"/App/ApiDemos-debug.apk");
        options.setNoReset(false);
        //installed app
        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.ApiDemos");

        driver=new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
    }

    @Test
    public void Test_Text() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Preference\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"9. Switch\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//android.widget.Switch[@resource-id=\"android:id/switch_widget\"])[1]")).click();
        Thread.sleep(2000);
    }

    @AfterClass
    public void tearDown(){
        if(driver !=null){
            driver.quit();
        }
    }
}
