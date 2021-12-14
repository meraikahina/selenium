package seleniumgluecode;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MyTestStepDefinition {

    public static WebDriver driver;

    @Given("^user is  on homepage$")
    public void user_is_on_homepage() throws Throwable {
        System.setProperty("webdriver.chrome.driver","src/test/java/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.legalife.fr/");
    }

    @When("^user navigates to Login Page$")
    public void user_navigates_to_Login_Page() throws Throwable {
        driver.findElement(By.xpath("//a[@title='Connectez-vous']")).click();
    }

    @When("^user enters username and Password$")
    public void user_enters_username_and_Password() throws Throwable {

        WebElement email = driver.findElement(By.xpath("//*[@id='login-popup-login']/form/input[2]"));
        email.sendKeys("aoudia_f@yahoo.fr");
        WebElement password = driver.findElement(By.xpath("//*[@id='login-popup-login']/form/input[3]"));
        password.sendKeys("9vkrmaq6");
        driver.findElement(By.xpath("//button[text()='Connexion']")).click();
    }

    @Then("^compte page is displayed$")
    public void success_message_is_displayed() throws Throwable {
        String monCompte = driver.findElement(By.linkText("MON COMPTE")).getText();

        Assert.assertEquals("MON COMPTE", monCompte);
        driver.quit();
    }
}
