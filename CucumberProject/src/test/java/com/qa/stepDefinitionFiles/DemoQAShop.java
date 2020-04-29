package com.qa.stepDefinitionFiles;

import org.openqa.selenium.WebDriver;

import com.qa.demoqa.pageObjects.CartPage;
import com.qa.demoqa.pageObjects.CheckoutPage;
import com.qa.demoqa.pageObjects.DemoQAHomePage;
import com.qa.demoqa.pageObjects.ProductListingPage;
import com.qa.manager.DriverManager;
import com.qa.manager.PageObjectManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class DemoQAShop {
	WebDriver driver;
	DemoQAHomePage homePage;
	ProductListingPage productListingPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	PageObjectManager pageObjectManager;	
	DriverManager driverManager;
	
	
	@Given("^user is on Home Page$")
	public void user_is_on_Home_Page(){
		driverManager = new DriverManager();
		driver = driverManager.getDriver();
		pageObjectManager = new PageObjectManager(driver);
		homePage = pageObjectManager.getHomePage();
		homePage.navigateTo_HomePage();	
	}

	@When("^he search for \"([^\"]*)\"$")
	public void he_search_for(String product)  {
		homePage.perform_Search(product);
	}

	@When("^choose to buy the first item$")
	public void choose_to_buy_the_first_item() {
		productListingPage = pageObjectManager.getProductListingPage();
		productListingPage.select_Product(0);
		productListingPage.clickOn_AddToCart();		
	}

	@When("^moves to checkout from mini cart$")
	public void moves_to_checkout_from_mini_cart(){
		cartPage = pageObjectManager.getCartPage();
		cartPage.select_Color();
		cartPage.select_Size();
		cartPage.clickOn_AddToCart();
		cartPage.clickOn_Cart();
		cartPage.clickOn_ContinueToCheckout();	
	}
	
	@When("^enter personal details on checkout page$")
	public void enter_personal_details_on_checkout_page(){
		checkoutPage = pageObjectManager.getCheckoutPage();
		checkoutPage.fill_PersonalDetails();	
	}
	
	@When("^select same delivery address$")
	public void select_same_delivery_address(){
		checkoutPage.check_ShipToDifferentAddress(false);
	}
	
	@When("^select payment method as \"([^\"]*)\" payment$")
	public void select_payment_method_as_payment(String arg1){
		checkoutPage.select_PaymentMethod("CheckPayment");
	}

	@When("^place the order$")
	public void place_the_order() {
		checkoutPage.check_TermsAndCondition(true);
		checkoutPage.clickOn_PlaceOrder();		
		driverManager.closeDriver();
	}	
}
