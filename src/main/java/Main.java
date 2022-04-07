import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Main {

    public static WebDriver driver;

    public static void initWebDriver(){
        System.setProperty("webdriver.chrome.driver", "Resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
    }

    public static void search(){
        initWebDriver();
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/button[1]")).click();
        driver.findElement(By.name("q")).sendKeys("Selenium WebDriver" + Keys.ENTER);
    }

    public static void getNumberOfLinksAndPrintTexts(){
        initWebDriver();
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/button[1]")).click();
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        for(WebElement link : links){
            System.out.println(link.getText());
        }
    }

    public static void getBlankets(){
        initWebDriver();
        Actions actions = new Actions(driver);
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/button[1]")).click();
        WebElement Home = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[6]/a[1]/div[1]/div[1]/img[1]"));
        actions.moveToElement(Home).perform();
        driver.findElement(By.linkText("Blankets")).click();
    }

    public static void searchButton(){
        initWebDriver();
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/button[1]")).click();
        //relative xpath
        driver.findElement(By.xpath("//body/div[@id='container']/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/input[1]")).sendKeys("shoes");
        driver.findElement(By.cssSelector("path._34RNph")).click();
    }

    public static void main(String[] args){
        search();
        getNumberOfLinksAndPrintTexts();
        getBlankets();
        searchButton();
    }
}
