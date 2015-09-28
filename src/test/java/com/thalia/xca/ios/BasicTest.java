package com.thalia.xca.ios;

import static org.junit.Assert.assertTrue;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import com.google.common.annotations.VisibleForTesting;
import com.thalia.xca.ios.prop.AbstractExcAction;
import com.thalia.xca.ios.prop.IOSCapabilities;

public class BasicTest {
	
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
    public void shoppingCartTest() throws Exception {
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
				
				eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);
				
				eName = "Warenkorb";
				element = wd.findElementByName(eName);
				String check = element.getAttribute("name");
				element.click();
				Thread.sleep(1000);
								
				eName = "Page Header NavigationBar";
				element = wd.findElementByXPath("//UIAWindow[1]/UIANavigationBar[1]");
				String result =  element.getAttribute("name");
		        
		    	assertTrue("The category: (" + check + ") didn't change the view. Result: " + result, result.equals(check));
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void wishListTest() throws Exception {
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
		
				eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);
				
		        eName = "Merkzettel";
				element = wd.findElementByName(eName);
				String check = element.getAttribute("name");
				element.click();
				Thread.sleep(1000);
				
				eName = "Page Header NavigationBar";
				element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]");
				String result =  element.getAttribute("name");
				
		    	assertTrue("The category: (" + check + ") didn't change the view. Result: " + result, result.equals(check));
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void accountTest() throws Exception {
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
		
				eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);
				
				eName = "Mein Konto";
				element = wd.findElementByName(eName);
				String check = element.getAttribute("name");
				element.click();
				Thread.sleep(1000);
								
				eName = "Page Header NavigationBar";
				element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]");
				String result =  element.getAttribute("name");
				
		    	assertTrue("The category: (" + check + ") didn't change the view. Result: " + result, result.equals(check));
		
			}
    	};
    	action.performAction();
    }
    
    @Test @Ignore
    public void countrySelectionTest() throws Exception {
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
		
				eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);
				
				eName = "Mein Konto";
				element = wd.findElementByName(eName);
				String check = element.getAttribute("name");
				element.click();
				Thread.sleep(1000);
				
				eName = "Deutschland (Thalia.de)";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);
				
				eName = "Page Header NavigationBar";
				element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]");
				String result =  element.getAttribute("name");
				
		    	assertTrue("The category: (" + check + ") didn't change the view. Result: " + result, result.equals(check));
			}
    	};
    	action.performAction();   
    }
    
    @Test
    public void helpTest() throws Exception {
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
		
				eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);
				
				eName = "Hilfe";
				element = wd.findElementByName(eName);
				String check = element.getAttribute("name");
				element.click();
				Thread.sleep(1000);
				
				eName = "Page Header NavigationBar";
				element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]");
				String result =  element.getAttribute("name");
				
		    	assertTrue("The category: (" + check + ") didn't change the view. Result: " + result, result.equals(check));
			}
    	};
    	action.performAction();  
    }
    
    
    @Test
    public void imprintTest() throws Exception {
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
		
				eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);
				
				eName = "Impressum";
				element = wd.findElementByName(eName);
		    	String check = element.getAttribute("name");
				element.click();
				Thread.sleep(1000);
				
				eName = "Page Header NavigationBar";
				element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]");
				String result =  element.getAttribute("name");
				
		    	assertTrue("The category: (" + check + ") didn't change the view. Result: " + result, result.equals(check));
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void conditionsTest() throws Exception {
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
		
				eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);
				
				eName = "AGB";
				element = wd.findElementByName(eName);
				String check = element.getAttribute("name");
				element.click();
				Thread.sleep(1000);
						        
				eName = "Page Header NavigationBar";
				element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]");
				String result =  element.getAttribute("name");
				
		    	assertTrue("The category: (" + check + ") didn't change the view. Result: " + result, result.equals(check));
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void storeLocatorTest() throws Exception {    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
			
				Thread.sleep(3000);
				eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);
				
				eName = "Vor Ort";
				element = wd.findElementByName(eName);
				String check = element.getAttribute("name");
				element.click();
				Thread.sleep(1000);
				
				eName = "OK";
				wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				List<MobileElement> temps = wd.findElementsByName(eName);
				temps.addAll(wd.findElementsByName("Erlauben"));
				if (temps.size() != 0){
					temps.get(0).click();
					Thread.sleep(5000);
				}
		        
				eName = "Page Header NavigationBar";
				element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]");
				String result =  element.getAttribute("name");
		    	
		    	assertTrue("The category: (" + check + ") didn't change the view. Result: " + result, result.equals(check));
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void scannerTest() throws Exception {
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
		
				eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);
				
				eName = "Scanner";
				element = wd.findElementByName(eName);
		    	String check = element.getAttribute("name");
				element.click();
				Thread.sleep(1000);

				eName = "OK";
				wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				List<MobileElement> temps = wd.findElementsByName(eName);
				temps.addAll(wd.findElementsByName("Ja"));
				if (temps.size() != 0){
					temps.get(0).click();
					Thread.sleep(5000);
				}

				eName = "Page Header NavigationBar";
				element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]");
				String result =  element.getAttribute("name");
		    	
		    	assertTrue("The category: (" + check + ") didn't change the view. Result: " + result, result.equals(check));
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void moreTest() throws Exception {
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
				
				eName = "Mehr";
				element = wd.findElementByName(eName);
				String check = element.getAttribute("name");
				element.click();
				Thread.sleep(1000);

				eName = "Page Header NavigationBar";
				element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]");
				String result =  element.getAttribute("name");
				
		    	assertTrue("The category: (" + check + ") didn't change the view. Result: " + result, result.equals(check));
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void editTest() throws Exception {
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
		    	if (iCap.screenHeight >= 1024) {
		    		System.out.println("iPad doesn't require this Test");  //iPad
		    		assertTrue(true);
		    		
		    	} else {
		            //Checking Tapbar switch
		    		eName = "Mehr";
		    		element = wd.findElementByName(eName);
		            element.click();
		            
		            eName = "Bearbeiten";
		            element = wd.findElementByName(eName);
		            element.click();
		            
		            eName = "//UIAWindow[1]/UIATabBar[1]/UIAButton[3]";
		            element = wd.findElementByXPath(eName);
		            String previousItem = element.getAttribute("name");
		            Thread.sleep(500);
		            
		            if (iCap.screenHeight < 550){
						wd.swipe(164, 338, 163, 529, 500);
//		                ((JavascriptExecutor)wd).executeScript("mobile: swipe", new HashMap<String, Double>() {{ put("touchCount", 1.0); put("startX", 164.0); put("startY", 338.0); put("endX", 163.0); put("endY", 529.0); put("duration", 0.5); }});
		            } else if (iCap.screenHeight > 550 && iCap.screenHeight < 1024){
						wd.swipe(164, 338, 163, 529, 500);
//		                ((JavascriptExecutor)wd).executeScript("mobile: swipe", new HashMap<String, Double>() {{ put("touchCount", 1.0); put("startX", 164.0); put("startY", 338.0); put("endX", 163.0); put("endY", 529.0); put("duration", 0.5); }});
		            }
		            
		            eName = "//UIAWindow[1]/UIATabBar[1]/UIAButton[3]";
		            element = wd.findElementByXPath(eName);
		            String newItem = element.getAttribute("name");
		            Thread.sleep(500);
		            
		            eName = "Fertig";
		            element = wd.findElementByName(eName);
		            element.click();
		            Thread.sleep(500);
		         
		            assertTrue("The tap-item: (" + previousItem + ") wasn't switched properly", !previousItem.equals(newItem)); 
		    	}
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void sortimentTest() throws Exception {

    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
				eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();

				eName = "Sortiment";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(500);
				
				eName = "Sortiment";
				element = wd.findElementByName(eName);
				element.click();
				
				eName = "Page Header NavigationBar";
				element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]");
				String result =  element.getAttribute("name");
				
		    	if (iCap.screenHeight >= 1024){
		    		assertTrue("The category: (Übersicht) didn't change the view / Result: (" + result + ")", result.contains("bersicht"));
		    	} else {
		    		assertTrue("The category: (Übersicht) didn't change the view / Result: (" + result + ")", result.contains("Sortiment"));
		    	}
			}
    	};
    	action.performAction();
    }
}