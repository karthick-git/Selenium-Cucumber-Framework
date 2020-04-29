package com.qa.manager;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;

import com.qa.Enum.DriverType;
import com.qa.Enum.EnvironmentType;

import io.github.bonigarcia.wdm.WebDriverManager;
 
public class DriverManager {
 private WebDriver driver;
 private static DriverType driverType;
 private static EnvironmentType environmentType;
 
 public DriverManager() {
 driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
 environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
 }
 
 public WebDriver getDriver() {
 if(driver == null) driver = createDriver();
 return driver;
 }
 
 private WebDriver createDriver() {
    switch (environmentType) {     
         case LOCAL : driver = createLocalDriver();
          break;
         case REMOTE : driver = createRemoteDriver();
          break;
    }
    return driver;
 }
 
 private WebDriver createRemoteDriver() {
 throw new RuntimeException("RemoteWebDriver is not yet implemented");
 }
 
 private WebDriver createLocalDriver() {
        switch (driverType) {     
        case FIREFOX : 
        	WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(); 
      break;
        case CHROME : 
        	WebDriverManager.chromedriver().version("81.0.4044.69").setup();
        	ChromeOptions chromeOptions = new ChromeOptions();
        	chromeOptions.setExperimentalOption(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
			chromeOptions.setExperimentalOption("useAutomationExtension", false);
			chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			driver = new ChromeDriver(chromeOptions);
      break;
        }
 
        if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
 return driver;
 } 
 
 public void closeDriver() {
 driver.close();
 driver.quit();
 }
 
}
