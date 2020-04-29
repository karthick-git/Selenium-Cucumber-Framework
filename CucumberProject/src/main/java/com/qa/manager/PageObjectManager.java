package com.qa.manager;

import org.openqa.selenium.WebDriver;

import com.qa.demoqa.pageObjects.CartPage;
import com.qa.demoqa.pageObjects.CheckoutPage;
import com.qa.demoqa.pageObjects.DemoQAHomePage;
import com.qa.demoqa.pageObjects.ProductListingPage; 
 
public class PageObjectManager {
 
 private WebDriver driver;
 
 private ProductListingPage productListingPage;
 
 private CartPage cartPage;
 
 private DemoQAHomePage homePage;
 
 private CheckoutPage checkoutPage;
 
 
 
 
 public PageObjectManager(WebDriver driver) {
 
 this.driver = driver;
 
 }
 
 
 
 public DemoQAHomePage getHomePage(){
 
 return (homePage == null) ? homePage = new DemoQAHomePage(driver) : homePage;
 
 }
 
 
 
 public ProductListingPage getProductListingPage() {
 
 return (productListingPage == null) ? productListingPage = new ProductListingPage(driver) : productListingPage;
 
 }
 
 
 
 public CartPage getCartPage() {
 
 return (cartPage == null) ? cartPage = new CartPage(driver) : cartPage;
 
 }
 
 
 
 public CheckoutPage getCheckoutPage() {
 
 return (checkoutPage == null) ? checkoutPage = new CheckoutPage(driver) : checkoutPage;
 
 }
}