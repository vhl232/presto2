import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.io.File;
import java.io.IOException;


import static org.openqa.selenium.Keys.chord;

public class PrestoShop {
    public static Logger log = LoggerFactory.getLogger(PrestoShop.class);

    static int countScreen = 0;
    static WebDriver driver;
    static Actions builder;
    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver","E:\\hachik NE TROGAT\\test\\selenium drivera" +
                "\\ChromeDriver\\chromedriver_win32 last\\chromedriver.exe");


        log.info("creat driver");
        driver = new ChromeDriver();
        String urlPrestoShop = "http://prestashop.qatestlab.com.ua/en/";
        driver.get(urlPrestoShop);

        Thread.sleep(3000);



        screensotDo();
//изминение размеров окна
        driver.manage().window().setSize(new Dimension(1000,1000));

//смена языка
        WebElement languege = driver.findElement(By.id("languages-block-top"));
        languege.click();
        WebElement ukr = (new  WebDriverWait(driver,10))
                .until(ExpectedConditions
                .elementToBeClickable(By.xpath("//a[@href='http://prestashop.qatestlab.com.ua/uk/']")));
        ukr.click();

        screensotDo();

        //driver.manage().window().setSize(new Dimension(1000, 1000)); //уменьшение размеров окна
//ввход на регистрацию
        WebElement login = driver.findElement(By.xpath("//a[@class='login']"));
        login.click();

        screensotDo();
//проверка аккаунта
        WebElement createAccaunt = driver.findElement(By.xpath("//input[@id='email_create']"));

        builder = new Actions(driver);
        builder.sendKeys(createAccaunt,"seriislon@gmail.com").build().perform();

        screensotDo();

        createAccaunt.submit();
        Thread.sleep(3000);

        createAccaunt.clear();

        builder.sendKeys(createAccaunt,"dtgpechat2@gmail.com").build().perform();
        createAccaunt.submit();

//регистрация аккаунта
        /*WebElement sex = (new WebDriverWait(driver,20))
                        .until(ExpectedConditions
                        .elementToBeClickable(By.xpath("//input[@id='id_gender1']")));

        sex.click();

        WebElement name = driver.findElement(By.id("customer_firstname"));
        name.sendKeys("dtg");

        WebElement sekondName = driver.findElement(By.id("customer_lastname"));
        sekondName.sendKeys("dtg");

        WebElement pass = driver.findElement(By.xpath("//input[@id='passwd']"));
        pass.sendKeys("123456");

        Select dayDrop = new Select(driver.findElement(By.xpath("//select[@id='days']")));
        dayDrop.selectByValue("1");

        Select monthDrop = new Select(driver.findElement(By.xpath("//select[@id='months']")));
        monthDrop.selectByValue("1");

        WebElement yer = (new WebDriverWait(driver,10))
                        .until(ExpectedConditions
                        .elementToBeClickable((By.xpath("//div[@class='col-xs-4 lineForm']"))));
        yer.click();

        yer.findElement(By.xpath("//span[@val='2018']")).click();
        driver.manage().window().setSize(new Dimension(1000,1000))
        WebElement registr = driver.findElement(By.xpath("//button[@id='submitAccount']"));
        registr.click();*/
//копирование  и всавка почты
        builder.moveToElement(createAccaunt)
                .moveByOffset(20,0)
                .clickAndHold()
                .moveByOffset(-180,0)
                .sendKeys(chord(Keys.CONTROL+"c"))
                .perform();
        screensotDo();

        WebElement vhod = driver.findElement(By.xpath("//input[@id='email']"));

        builder.sendKeys(vhod,chord(Keys.CONTROL,"v")).perform();
        screensotDo();
//ввод пароля
        WebElement password = driver.findElement(By.xpath("//input[@id='passwd']"));
        password.sendKeys("123456");

        WebElement vhodParol = driver.findElement(By.xpath("//button[@id='SubmitLogin']//span"));
        vhodParol.click();
        screensotDo();
//переход на главную страницу
        WebElement mainPage = driver.findElement(By.xpath("//img[@class='logo img-responsive']"));
        mainPage.click();
//количество iframe
        int sizeIFrame = driver.findElements(By.tagName("iframe")).size();
        System.out.println(sizeIFrame);

        Thread.sleep(3000);
//наведение на окно выбора первого товара
        WebElement order = driver.findElement(By.xpath("//ul[@id='homefeatured']" +
                "//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 first-in-line first-item-of-tablet-line" +
                " first-item-of-mobile-line']//div[@class='product-container']" +
                "//div[@class='left-block']//div[@class='product-image-container']//a[@class='product_img_link']"));


        builder.moveToElement(order).build().perform();
        screensotDo();
        //order.click();
        //int sizeIFrame2 = driver.findElements(By.tagName("iframe")).size();
        //System.out.println(sizeIFrame2);

        //WebElement plus = driver.findElement(By.xpath("//span[@class='span_link no-print']"));
        //plus.click();

        //WebElement str = (new WebDriverWait(driver,10)
                //.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Next']"))));
        //builder.click(str).click(str).click(str).build().perform();
        //увеличение изображения и переключение фото

        //WebElement x = driver.findElement(By.xpath("//a[@title='Close']"));
       // x.click();

//добавление товара
        WebElement addTshort = (new WebDriverWait(driver,10)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//ul[@id='homefeatured']" +
                        "//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3" +
                        " first-in-line first-item-of-tablet-line first-item-of-mobile-line']" +
                        "//div[@class='product-container']//div[@class='right-block']//div[@class='button-container']" +
                        "//a[@class='button ajax_add_to_cart_button btn btn-default']//span[contains(text(),'У Кошик')]")));
        addTshort.click();
        screensotDo();

// close window with choice good
        WebElement closeAddTshort = (new WebDriverWait(driver,10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='cross']")));
        closeAddTshort.click();
//add another good
        String bluse = "//ul[@id='homefeatured']" +
                "//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 last-item-of-mobile-line']" +
                "//div[@class='product-container']//div[@class='left-block']//div[@class='product-image-container']" +
                "//a[@class='product_img_link']";
        WebElement anotherGood = driver.findElement(By.xpath(bluse));
        anotherGood.click();
       //добавить товара
        WebElement plusAnotherGood_a = driver.findElement(By.xpath("//*[@id=\"quantity_wanted_p\"]/a[2]"));
        builder.click(plusAnotherGood_a).click(plusAnotherGood_a).click(plusAnotherGood_a).build().perform();
        screensotDo();
        //убрать еденицу товара
        WebElement minusAnotherGood = driver.findElement(By.xpath("//*[@id=\"quantity_wanted_p\"]/a[1]/span/i"));
        builder.click(minusAnotherGood).build().perform();
        screensotDo();
        //изменить размер товара
        Select sizeGood = new Select(driver.findElement(By.xpath("//*[@id=\"group_1\"]")));
        sizeGood.selectByValue("2");
        //изменить цвет товара
        WebElement colorGood = driver.findElement(By.xpath("//*[@id=\"color_8\"]"));
        colorGood.click();
        //положить товар в корзину
        WebElement addAnotherGood = driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button"));
        addAnotherGood.click();
        //закрыть меню товара
        //WebElement closeAnotherGood = driver.findElement(By.xpath("//*[@id=\"index\"]/div[2]/div/div/a"));
        //closeAnotherGood.click();

        /*WebElement coshikprod = (new WebDriverWait(driver,10)
                        .until(ExpectedConditions.elementToBeClickable(By
                        .xpath("//span[@class='continue btn btn-default button exclusive-medium']"))));
        Thread.sleep(3000);
        coshikprod.click();*/


//наведение на кошик
        WebElement coshikAlon = driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a"));

        builder.moveToElement(coshikAlon).build().perform();

// удаление одного товара из кошика
        WebElement del = (new WebDriverWait(driver,10)
                        .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//a[@class='ajax_cart_block_remove_link']"))));

        del.click();
 //удаление пару товаров из корзины
        coshikAlon.click();
//удаление выброного товара из кошика
        Thread.sleep(3000);
        WebElement delAllGood = driver.findElement(By.xpath("//*[@class='icon-trash']"));
        delAllGood.click();
        WebElement minGoodKishik = driver.findElement(By.xpath("//*[@class='icon-minus']"));
        //builder.click(minGoodKishik).click(minGoodKishik).build().perform();
        minGoodKishik.click();
//yet one mainPage because --StaleElementReferenceException: stale element reference: element is not attached to the page document
        WebElement mainPaige = driver.findElement(By.xpath("//*[@id='header_logo']"));
        mainPaige.click();

        WebElement dress = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"));
        builder.moveToElement(dress).build().perform();
        WebElement eveningDress = (new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable((By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[2]/a")))));
        eveningDress.click();
//уменьшение разброса цен
        WebElement scroll = driver.findElement(By.xpath("//*[@id='layered_price_slider']"));
        driver.findElement(By.xpath("//*[@class='icon-th-list']")).click();
        Thread.sleep(3000);
        builder.moveToElement(scroll).clickAndHold(scroll).dragAndDropBy(scroll,-400,0).build().perform();

    }
//метод для скриншотов
    public static void screensotDo () throws IOException {
        File screen  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screen,new File("E:\\hachik NE TROGAT\\test\\prog\\newscrCount"+countScreen+".png" ));
        countScreen++;
    }

//метод наведения на окно с товаром
   /* public static void choiceWindiwGoods(String a){
        WebElement good = driver.findElement(By.xpath(a));
        builder.moveToElement(good).build().perform();
    }*/
        
    }

