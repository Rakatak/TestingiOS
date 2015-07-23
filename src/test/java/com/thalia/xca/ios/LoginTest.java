package com.thalia.xca.ios;

import static org.junit.Assert.assertTrue;

import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import com.google.common.annotations.VisibleForTesting;
import com.thalia.xca.ios.prop.AbstractExcAction;
import com.thalia.xca.ios.prop.AppiumSetup;
import com.thalia.xca.ios.prop.IOSCapabilities;

public class LoginTest {
	
	private IOSDriver<MobileElement> wd; 
	IOSCapabilities iCap;
	
	@Before
	public void setUp() throws Exception {
		iCap = new IOSCapabilities(); 
		wd = iCap.setCap();
	}

	@VisibleForTesting
	private MobileElement openSearch() throws Exception {
		MobileElement elementSearch = null;
		if (iCap.screenHeight >= 1024){
	        elementSearch = wd.findElementByClassName("UIASearchBar");  //iPad                 
		}else {
			elementSearch = wd.findElementByName("Suche");
		}
		return elementSearch;
	}
    
    @Test
    public void loginFailTest() throws Exception {
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
				
				eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);
				
				eName = "Mein Konto";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(2000);

		        if (iCap.screenHeight < 1024) {
		        	wd.tap(1, 162, 278, 500);
		        } else {
		        	wd.tap(1, 400, 275, 500);
		        }
		        Thread.sleep(2000);
		        
				eName = "UIATextField";
				element = wd.findElementByClassName(eName);
				element.click();
				element.sendKeys("Robin");
				Thread.sleep(500);
				
				eName = "UIASecureTextField";
				element = wd.findElementByClassName(eName);
				element.click();
				element.sendKeys("Textunes");
				Thread.sleep(500);
			
				eName = "Anmelden";
				List<MobileElement> temps = wd.findElementsByName(eName);;
//				element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAStaticText[1]");
				temps.get(2).click();
				Thread.sleep(1000);
				
				eName = "Zugangsdaten nicht korrekt";
				element = wd.findElementByName(eName);
				
				assertTrue("No Failed Login alert was displayed, though expected", element.isDisplayed());
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void loginTestDE() throws Exception {
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {

				eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);
				
				eName = "Mein Konto";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(2000);

		        if (iCap.screenHeight < 1024) {
		        	wd.tap(1, 162, 278, 500);
		        } else {
		        	wd.tap(1, 400, 275, 500);
		        }
		        Thread.sleep(2000);

				eName = "UIATextField";
				element = wd.findElementByClassName(eName);
				element.click();
				element.sendKeys(iCap.username);
				Thread.sleep(500);
				
				eName = "UIASecureTextField";
				element = wd.findElementByClassName(eName);
				element.click();
		    	element.sendKeys(iCap.password);
				Thread.sleep(500);
				
				eName = "Anmelden";
				List<MobileElement> temps = wd.findElementsByName(eName);
				temps.get(2).click();
				Thread.sleep(5000);
		        
				eName = "Mein Konto";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);
				
				if (AppiumSetup.v.equals("8")){
					eName = iCap.username;
				} else {
					eName = "Benutzer, " + iCap.username;
				}
				element = wd.findElementByName(eName);
				
				assertTrue("Login didn't result in logged in screen", element.getAttribute("name").contains(iCap.username));
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void dashboardLoginTest() throws Exception {
    	        
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
    	
		    	eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);
				
				eName = "Mein Konto";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(2000);

		        if (iCap.screenHeight < 1024) {
		        	wd.tap(1, 162, 278, 500);
		        } else {
		        	wd.tap(1, 400, 275, 500);
		        }
		        Thread.sleep(2000);

				eName = "UIATextField";
				element = wd.findElementByClassName(eName);
				element.click();
				element.sendKeys("jens.zech@textunes.de");
				Thread.sleep(500);
				
				eName = "UIASecureTextField";
				element = wd.findElementByClassName(eName);
				element.click();
		    	element.sendKeys("textunes");
				Thread.sleep(5000);
				
				eName = "Anmelden";
				List<MobileElement> temps = wd.findElementsByName(eName);
				temps.get(2).click();
				Thread.sleep(5000);
				
				eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(500);
				
				eName = "Buchhändler-Menü";
		        if (iCap.screenHeight < 1024) {
		        	element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[5]/UIAStaticText[1]");
		        } else {
					element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
		        }
				element.click();
				Thread.sleep(500);
			
				eName = "textyo";
				element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]");
				String check = element.getAttribute("name");
				element.click();
				Thread.sleep(500);
				
				assertTrue("Login didn't result in logged in screen", check.contains("Buchh"));
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void loginLogoutTest() throws Exception {
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {

				eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(2000);
				
				eName = "Mein Konto";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(2000);

		        if (iCap.screenHeight < 1024) {
		        	wd.tap(1, 162, 278, 500);
		        } else {
		        	wd.tap(1, 400, 275, 500);
		        }
		        Thread.sleep(2000);

				eName = "UIATextField";
				element = wd.findElementByClassName(eName);
				element.click();
				element.sendKeys(iCap.username);
				Thread.sleep(500);
				
				eName = "UIASecureTextField";
				element = wd.findElementByClassName(eName);
				element.click();
		    	element.sendKeys(iCap.password);
				Thread.sleep(500);
				
				eName = "Anmelden";
				List<MobileElement> temps = wd.findElementsByName(eName);;
				temps.get(2).click();
				Thread.sleep(5000);
		        
				eName = "Mein Konto";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);
				
				eName = "Abmelden";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);
				
				eName = "Abmelden2";
				if (AppiumSetup.v.equals("8")){
					element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]");
				} else {
					element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[3]/UIAAlert[1]/UIATableView[2]/UIATableCell[1]");
				}
				element.click();
				Thread.sleep(1000);
				
				eName = "Mein Konto";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);
				
				eName = "Sortiment zeigen";
				element = wd.findElementByName(eName);
				Thread.sleep(1000);
				
				assertTrue("User didn't log out", element.isEnabled());
			}
    	};
    	action.performAction();
    }
}