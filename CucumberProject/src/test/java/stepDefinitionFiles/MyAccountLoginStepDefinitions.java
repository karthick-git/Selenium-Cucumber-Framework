package stepDefinitionFiles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class MyAccountLoginStepDefinitions {
	
	WebDriver driver;
	
	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		this.driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown() throws InterruptedException {
		this.driver.manage().deleteAllCookies();
		this.driver.quit();
		this.driver = null;
	}
	
	@Given("^User navigates to practice automationtesting website$")
	public void enter_the_URL() throws Throwable {
		driver.get("http://practice.automationtesting.in/");
	}

	@And("^Click on My Account Menu$")
	public void click_on_My_Account_Menu() throws Throwable {
		driver.findElement(By.linkText("My Account")).click();
		Thread.sleep(2000);
	}

	@And("^Enter registered username and password$")
	public void enter_registered_username_and_password() throws Throwable {
		driver.findElement(By.id("username")).sendKeys("pavanoltraining");
	    driver.findElement(By.id("password")).sendKeys("Test@selenium123");
	}

	@When("^Click on login button$")
	public void click_on_login_button() throws Throwable {
		driver.findElement(By.name("login")).click();
	}

	@Then("^User must successfully login to the web page$")
	public void user_must_successfully_login_to_the_web_page() throws Throwable {
	  String capText= driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/div/p[1]/strong")).getText();
	  Assert.assertEquals(true,capText.contains("pavanoltraining"));
	}
}
