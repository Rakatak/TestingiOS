package com.thalia.xca.ios;

import static org.junit.Assert.assertTrue;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import com.google.common.annotations.VisibleForTesting;
import com.thalia.xca.ios.prop.AbstractExcAction;
import com.thalia.xca.ios.prop.AppiumSetup;
import com.thalia.xca.ios.prop.IOSCapabilities;

public class StoreFinderTest {
	
	private IOSDriver<MobileElement> wd; 
	IOSCapabilities iCap;
	
	@Before
	public void setUp() throws Exception {
		iCap = new IOSCapabilities(); 
		if (wd == null){
    		wd = iCap.setCap();
    	}	
	}
    
	@VisibleForTesting
    private void checkLocal(String eName, List<MobileElement> temps) {
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		temps = wd.findElementsByName(eName);
		temps.addAll(wd.findElementsByName("Erlauben"));
		if (temps.size() != 0){
			temps.get(0).click();
			
		}	
		wd.manage().timeouts().implicitlyWait(AppiumSetup.timeOut, TimeUnit.SECONDS);
    }
	
    @Test
    public void closestStoreTest() throws Exception {
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
				
//				findByNameShort("hshshshs");
				eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);
				
				eName = "Vor Ort";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);

				eName = "OK";
				List<MobileElement> temps = null;
				if (iCap.screenHeight >= 1024){
					checkLocal("OK", temps);
					Thread.sleep(3000);
				}
				
				eName = "Filialen in Ihrer Nähe";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);
				
				if (iCap.screenHeight < 1024){
					checkLocal("OK", temps);
					Thread.sleep(3000);
				}
				
				eName = "filiale";
				temps = wd.findElementsByName(eName);
				Thread.sleep(2000);

				assertTrue("No Stores closest were located", temps.size() > 1);
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void stateStoreTest() throws Exception {
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
				
				eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);
				
				eName = "Vor Ort";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);

				eName = "OK";
				List<MobileElement> temps = null;
				if (iCap.screenHeight >= 1024){
					checkLocal("OK", temps);
					Thread.sleep(3000);
				}
				
				eName = "Alle Filialen";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);
				
				eName = "Berlin";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);
					
				eName = "filiale";
				temps = wd.findElementsByName(eName);
				Thread.sleep(2000);

				assertTrue("No Stores with state selection were located", temps.size() > 1);
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void chooseStoreTest() throws Exception {
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
				
				eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);
				
				eName = "Vor Ort";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);

				eName = "OK";
				List<MobileElement> temps = null;
				if (iCap.screenHeight >= 1024){
					checkLocal("OK", temps);
					Thread.sleep(3000);
				}

				eName = "Filialen in Ihrer Nähe";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);
				
				if (iCap.screenHeight < 1024){
					checkLocal("OK", temps);
					Thread.sleep(3000);
					
					eName = "Store Icon";
					element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[4]");
					element.click();
					Thread.sleep(1000);
					
					eName = "Als meine Filiale festlegen";
					element = wd.findElementByName(eName);
					element.click();
					Thread.sleep(1000);
					
					eName = "Vor Ort";
					temps = wd.findElementsByName(eName);
					temps.get(0).click();
					Thread.sleep(1000);
					
					eName = "Shopping Center ALEXA";
					temps = wd.findElementsByName(eName);
					
					assertTrue("No store was chosen", temps.size() > 0 );
					
				} else {
					
					eName = "Store Icon";
					element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAButton[4]");
					element.click();
					Thread.sleep(1000);
					
					eName = "Als meine Filiale festlegen";
					element = wd.findElementByName(eName);
					element.click();
					Thread.sleep(1000);
					
					eName = "Shopping Center ALEXA";
					temps = wd.findElementsByName(eName);
					
					assertTrue("No store was chosen", temps.size() > 0 );
				}
				
				

			}
    	};
    	action.performAction();
    }
    
    @Test
    public void farStoreTest() throws Exception {
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
				
				eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);
				
				eName = "Vor Ort";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);

				eName = "OK";
				List<MobileElement> temps = null;
				if (iCap.screenHeight >= 1024){
					checkLocal("OK", temps);
					Thread.sleep(3000);
				}
				
				eName = "Filialen in Ihrer Nähe";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);
				
				if (iCap.screenHeight < 1024){
					checkLocal("OK", temps);
					Thread.sleep(3000);
					wd.swipe((int)(iCap.screenWidth*0.7), (int)(iCap.screenHeight*0.8), (int)(iCap.screenWidth*0.8), (int)(iCap.screenHeight*0.2), 500);
					Thread.sleep(3000);
					wd.swipe((int)(iCap.screenWidth*0.7), (int)(iCap.screenHeight*0.8), (int)(iCap.screenWidth*0.8), (int)(iCap.screenHeight*0.2), 500);
					Thread.sleep(3000);
				} 
				
				eName = "weiter entfernte Filialen ›";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(5000);
				
				eName = "filiale";
				temps = wd.findElementsByName(eName);
				Thread.sleep(2000);

				assertTrue("No Stores far were located", temps.size() > 2);
			}
    	};
    	action.performAction();
    }
   
}