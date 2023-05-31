import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:/Users/xrist/chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);

        //driver.wait(3000);

        driver.get("http://tutorialsninja.com/demo/"); // opens the url
        driver.manage().window().maximize(); // maximizes the window

        int count = driver.findElements(By.tagName("a")).size(); // counts how many links there are on the site
        System.out.println("There are " + count + " links on the site");

        driver.findElement(By.name("search")).click(); // clicks search bar
        Thread.sleep(2000); // wait for 2 seconds

        driver.findElement(By.name("search")).sendKeys("MacBook"); // types "MacBook" in the search bar
        Thread.sleep(2000); // wait for 2 seconds

        driver.findElement(By.className("input-group-btn")).click(); // clicks search button
        Thread.sleep(2000);

        driver.findElement(By.xpath("//img[@alt='MacBook']")).click(); // clicks on the MacBook image
        Thread.sleep(2000);

        driver.findElement(By.id("input-quantity")).clear(); // selects the quantity field and clears the default value
        Thread.sleep(2000);

        driver.findElement(By.id("input-quantity")).sendKeys("2"); // types number 2 in the quantity field
        Thread.sleep(2000);

        driver.findElement(By.id("button-cart")).click(); // adds the product in the cart
        Thread.sleep(2000);

        String txt = driver.findElement(By.className("alert-success")).getText(); // gets the text from the success alert
        String expectedMessage = "Success: You have added MacBook to your shopping cart!\n×";
        System.out.println(txt);

        // asserts that the txt variable matches the expected success message
        Assert.assertEquals(txt, expectedMessage);

        driver.close(); // closes the current tab
    }
}
