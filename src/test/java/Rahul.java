import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Rahul {

    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:/Users/xrist/chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);

        //driver.wait(3000);

        driver.get("https://rahulshettyacademy.com/AutomationPractice/"); // opens the url
        driver.manage().window().maximize(); // maximizes the window

        System.out.println(driver.findElement(By.id("checkBoxOption2")).isSelected()); // checks if the checkbox is selected

        driver.findElement(By.id("checkBoxOption2")).click(); // clicks the checkbox
        System.out.println(driver.findElement(By.id("checkBoxOption2")).isSelected()); // checks again if the checkbox is selected after clicking

        System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size()); // counts the quantity of the checkboxes

        driver.findElement(By.id("name")).sendKeys("User"); // enters the text "User" into the input field
        driver.findElement(By.id("alertbtn")).click(); // clicks the alert button

        Alert alert = driver.switchTo().alert(); // switches the focus to the alert message
        String alertText = alert.getText(); // gets the alert text
        System.out.println(alertText);

        String exp = "Hello User, share this practice page and share your knowledge";
        Assert.assertEquals(alertText, exp); // asserts that the actual alert text matches the expected text

        alert.accept(); // accepts the alert

        driver.close();
    }
}
