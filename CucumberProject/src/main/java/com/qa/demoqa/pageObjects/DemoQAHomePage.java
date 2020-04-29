package com.qa.demoqa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
 
public class DemoQAHomePage {
 WebDriver driver;
 
 public DemoQAHomePage(WebDriver driver) {
 this.driver = driver;
 PageFactory.initElements(driver, this);
 }
 
 public void perform_Search(String search) {
 driver.navigate().to("http://shop.demoqa.com/?s=" + search + "&post_type=product");
 }
 
 public void navigateTo_HomePage() {
 driver.get("http://www.shop.demoqa.com");
 }
 
}
