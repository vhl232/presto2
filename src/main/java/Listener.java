import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
public class Listener extends AbstractWebDriverEventListener {
    public static Logger log = LoggerFactory.getLogger(Listener.class);

    public static void main(String[] args)  {

        System.setProperty("webdriver.chrome.driver","E:\\hachik NE TROGAT\\test\\selenium drivera" +
                "\\ChromeDriver\\chromedriver_win32 last\\chromedriver.exe");
        EventFiringWebDriver driver = new EventFiringWebDriver(new  ChromeDriver());
        //ChromeDriver driver = new ChromeDriver();
        driver.register(new Listener());
        driver.get("http://prestashop.qatestlab.com.ua/en/");
        log.debug("pfgeoty");


    }

}
