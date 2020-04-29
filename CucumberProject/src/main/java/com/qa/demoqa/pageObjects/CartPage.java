package com.qa.demoqa.pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CartPage {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using = ".cart-button")
	private WebElement btn_Cart;

	@FindBy(how = How.XPATH, using = "//select[@id='pa_color']")
	private WebElement color_dropdown;

	@FindBy(how = How.XPATH, using = "//select[@id='pa_size']")
	private WebElement size_dropdown;

	@FindBy(how = How.XPATH, using = "//button[text()='Add to cart']")
	private WebElement add_to_cart;

	@FindBy(how = How.CSS, using = ".checkout-button.alt")
	private WebElement btn_ContinueToCheckout;

	public void clickOn_Cart() {
		btn_Cart.click();
	}

	public void clickOn_AddToCart() {
		add_to_cart.click();
	}

//	public void select_Color() {
//		try {
//			Select color = new Select(color_dropdown);
//			color.selectByValue("white");
//		} catch (UnhandledAlertException f) {
//		    try {
//		        Alert alert = driver.switchTo().alert();
//		        String alertText = alert.getText();
//		        System.out.println("Alert data: " + alertText);
//		        alert.accept();
//		    } catch (NoAlertPresentException e) {
//		        e.printStackTrace();
//		    }
//		}
//		
//	}
	
	public void select_Color() {
		Alert alert = driver.switchTo().alert();
        alert.accept();
		Select color = new Select(color_dropdown);
		color.selectByValue("white");
		
	}

	public void select_Size() {
		Select size = new Select(size_dropdown);
		size.selectByIndex(1);
	}

	public void clickOn_ContinueToCheckout() {
		btn_ContinueToCheckout.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
	}

}
