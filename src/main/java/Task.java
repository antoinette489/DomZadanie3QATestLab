import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task {
    public static void main(String[] args) {
        WebDriver driver = getDriver();
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("webinar.test@gmail.com");
        WebElement passwField = driver.findElement(By.id("passwd"));
        passwField.sendKeys("Xcg7299bnSmMuRLp9ITw");
        WebElement signInButton = driver.findElement(By.name("submitLogin"));
        signInButton.click();

        Actions action = new Actions(driver);
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Каталог")));

        WebElement catalog = driver.findElement(By.linkText("Каталог"));

        action.moveToElement(catalog).build().perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("категории")));
        WebElement categories = driver.findElement(By.linkText("категории"));
        categories.click();

        WebElement addCategory = driver.findElement(By.id("page-header-desc-category-new_category"));
        addCategory.click();
        WebElement nameField = driver.findElement(By.id("name_1"));
        nameField.sendKeys("A_Test_Category");
        nameField.submit();
        WebElement backButton = driver.findElement(By.id("desc-category-back"));
        backButton.click();

        WebElement filterButton = driver.findElement(By.xpath("(.//*[@class='title_box'])[2]/a[2]"));
        filterButton.click();



    }
    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", Task.class.getResource("chromedriver.exe").getPath());
        return new ChromeDriver();
    }

    /*public static WebDriver getHandler() {
        System.setProperty("webdriver.chrome.driver", Test.class.getResource("chromedriver.exe").getPath());
        EventFiringWebDriver driver = new EventFiringWebDriver(new ChromeDriver());
        final EventFiringWebDriver register = driver.register(new EventHandler());
        return driver;
    }*/
}