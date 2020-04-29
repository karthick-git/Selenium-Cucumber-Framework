package com.qa.stepDefinitionFiles;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qa.ExtentReport.ExtentReport;
import com.qa.Guru99.pageobjects.Guru99HomePage;
import com.qa.Guru99.pageobjects.Guru99LoginPageObjects;
import com.qa.Utils.ExcelRead;
import com.qa.manager.DriverManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Guru99Login {
		WebDriver driver;
		DriverManager driverManager;
	    Guru99LoginPageObjects objLogin;
	    Guru99HomePage objHomePage;
	    
	    ExtentReport extRpt = new ExtentReport();
	    ExcelRead excel = new ExcelRead();
	    
	    @Given("^I have user name and password$")
	    public void i_have_user_name_and_password() throws Throwable {
		 // Write code here that turns the phrase above into concrete actions
	    		driverManager = new DriverManager();
	    		driver = driverManager.getDriver();
		        driver.get("http://demo.guru99.com/V4/");
		     
		        extRpt.setUpReport();
	
	}

	@When("^I successfully login$")
	public void i_successfully_login() throws Throwable {
		   extRpt.startTestCase("User Login");
			
		    objLogin = new Guru99LoginPageObjects(driver);

		    //Verify login page title

		   
		    
		    String loginPageTitle = objLogin.getLoginTitle();

		    Assert.assertTrue(loginPageTitle.toLowerCase().contains(excel.readExcel(1,3, ".\\Data\\data.xlsx","Sheet1")));

		    //login to application

		    objLogin.loginToGuru99(excel.readExcel(1,1, ".\\Data\\data.xlsx","Sheet1"), excel.readExcel(1,2, ".\\Data\\data.xlsx","Sheet1"));
		   
		    extRpt.logEvents("Logged Successfully");

	}

	  
	   


	@Then("^I should navigate to the home page$")
	public void i_should_navigate_to_the_home_page() throws Throwable {
		 objHomePage = new Guru99HomePage(driver);

		    //Verify home page

	
		    //Verify home page

		    Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
		    //driver.close();
		   
		    extRpt.createFinalReport();
		 
	}


}
