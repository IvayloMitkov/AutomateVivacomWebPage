import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import java.util.concurrent.TimeUnit;

public class AutomationTest {

    public static WebDriver driver;


    @BeforeTest
    public void Setup() {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resourses/chromedriver.exe");
        driver =new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.vivacom.bg/bg");
        //driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);


    }

    @AfterTest
    public void Close() {
        driver.close();
    }

    @Test
    void AddPhoneToTheChart() throws InterruptedException {


        driver.findElement(By.xpath("//*[@id=\"CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll\"]")).click();

        driver.findElement(By.cssSelector("#main-big-menu > li:nth-child(2) > a")).click();
        driver.findElement(By.cssSelector("#main-big-menu > li.dropdown.open > ul > li:nth-child(1) > div > div.dropdown-link-text > a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"filter-manufacturer\"]/label[1]/em")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"filter-colors.color\"]/label[2]/em")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//DIV[@class='e-shop-devices-product-details-phone-grid-box'])[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"relatedOfferDiv-epc_cfi230105161710184106_so_juu230914134418289888\"]/div[3]/div[2]/div[1]/label/span[2]")).click();
        driver.findElement(By.id("xSellBtn")).click();
        driver.findElement(By.xpath("//*[@id=\"faciaDataHighResView\"]/div[4]/div[1]/button")).click();
        Thread.sleep(3000);

        String expectedtitle = "Кошница | VIVACOM";
        String actualtitle = driver.getTitle();
        Assert.assertEquals(actualtitle,expectedtitle);

        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"vivacom-devices-navbar\"]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//A[@href='/online/bg/shop/devices/listing?navigation=product-category-accessories'][text()='Аксесоари']")).click();
        driver.findElement(By.xpath("//SPAN[@class='analytics-skip'][text()='APPLE']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//SPAN[@class='analytics-skip'][text()='над 40 лв.']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//DIV[@class='select-color-info-row'][text()='\t\t\t\t\t\t\t\t'])[4]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"faciaDataHighResView\"]/div[4]/div[1]/button")).click();


        String expectedtitle2 = "Кошница | VIVACOM";
        String actualtitle2 = driver.getTitle();
        Assert.assertEquals(actualtitle,expectedtitle);

        Thread.sleep(3000);

        WebElement checkbox = driver.findElement(By.xpath("//EM[@class='vivacom-icon icon-box_empty']"));

        if (checkbox.isDisplayed())
        {
            driver.findElement(By.xpath("//EM[@class='vivacom-icon icon-box_empty']")).click();
        }

        Thread.sleep(3000);

        driver.findElement(By.xpath("(//EM[@class='vivacom-icons icon-close_x'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//EM[@class='vivacom-icons icon-close_x']")).click();
        Thread.sleep(2000);

        WebElement emptychartmessage = driver.findElement(By.xpath("//*[@id=\"shopping-cart-span\"]/div[1]/div/div/section/div/div/h3"));

        if (emptychartmessage.isDisplayed())
        {
            driver.findElement(By.xpath("//*[@id=\"shopping-cart-span\"]/div[1]/div/div/section/div/div/div/button")).click();
        }

    }
}
