package com.thalia.xca.ios;

import static org.junit.Assert.assertTrue;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import com.google.common.annotations.VisibleForTesting;
import com.thalia.xca.ios.prop.AbstractExcAction;
import com.thalia.xca.ios.prop.IOSCapabilities;

public class ShopTest {
	
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
    public void shopCategoryTest() throws Exception {

    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
		   		
				eName = "Mehr";
				element = wd.findElementByName(eName);
		   		element.click();
		   		Thread.sleep(3000);
		   		
		   		eName = "Sortiment";
		   		element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(3000);
				
				eName = "Krimis & Thriller";
				element = wd.findElementByName(eName);
				String check = element.getAttribute("name");
				element.click();
				Thread.sleep(1000);
		        
				eName = "Header Title";
				element =  wd.findElementByXPath("//UIAWindow[1]/UIANavigationBar[1]");
				String result = element.getAttribute("name");
		        
				//Check the total number
				assertTrue("The shop category didn't change the view properly. Expected Header: " + check + " / Result: " + result, check.equals(result));  
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void checkShopOptions() throws Exception {
    	
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
			    
				int checker = 0;
		    	ArrayList<String> checkList = new ArrayList<String>();
		    	checkList.add("Beste Treffer");
		    	checkList.add("Verkaufsrang");
		    	checkList.add("zuletzt erschienen");
		    	checkList.add("Preis: aufsteigend");
		    	checkList.add("Preis: absteigend");
		    	checkList.add("Titel: A–Z");
		    	checkList.add("Titel: Z–A");
		    	
				eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);
				
				eName = "Sortiment";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(3000);
		        
				eName = "Krimis & Thriller";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(3000);
				
		    	if (iCap.screenHeight < 1024){

					eName = "Shop options dropdown menu";
					element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[2]");
					element.click();
					Thread.sleep(2000);
				
		    	} else {
				
//					eName = "BtnSlidingMenu";
//					element = wd.findElementByName(eName);
//					element.click();
//					Thread.sleep(1500);
					
					eName = "Shop options dropdown menu";
					element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[2]");
					element.click();
					Thread.sleep(2000);
	
		    	}	
		    	
		    	//iterate on options and checking
				for (int i = 0; i < checkList.size(); i++){
					eName = checkList.get(i);
					if (wd.findElementByName(eName).isEnabled()){
						checker++;
					}
				}
				
			    //Check the total number
		    	assertTrue("The search options are incomplete: " + checker + " of " + checkList.size(), checker==checkList.size() );
			
		    }
			
    	};
    	action.performAction();
    }
    
    @Test
    public void shopOptionsTest() throws Exception {

    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
		    	//TODO when search is good again 
					MobileElement checkItem = null;
			    	String check = null;
			    	
					Thread.sleep(500);
					eName = "Mehr";
					element = wd.findElementByName(eName);
					element.click();
					Thread.sleep(1000);
					
					eName = "Sortiment";
					element = wd.findElementByName(eName);
					element.click();
			        Thread.sleep(3000);
			        
					eName = "Krimis & Thriller";
					element = wd.findElementByName(eName);
					element.click();
					Thread.sleep(1500);		
				
					if ( iCap.screenHeight < 1024.0){

						eName = "Shop options dropdown menu";
						element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[2]");
						element.click();
						Thread.sleep(1000);
	
						eName = "Verkaufsrang";
						element = wd.findElementByName(eName);
						check = element.getAttribute("name");
						element.click();
						Thread.sleep(4000);	
	
						eName = "Shop options dropdown menu";
						checkItem = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[2]");
					
					} else {
						
//						eName = "BtnSlidingMenu";
//						element = wd.findElementByName(eName);
//						element.click();
//						Thread.sleep(1500);
						
						eName = "Shop options dropdown menu";
						element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[2]");
						element.click();
						Thread.sleep(1000);

						eName = "Verkaufsrang";
						element = wd.findElementByName(eName);
						check = element.getAttribute("name");
						element.click();
						Thread.sleep(4000);	

						eName = "Shop options dropdown menu";
						checkItem = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[2]");
						
					}
					assertTrue("The search option: (" + check + ") wasn't displayed/selected correctly ", checkItem.getAttribute("name").contains(check) );
				
			}
    	};
    	action.performAction();
        
    }
    
    @Test
    public void shopSlideMenu() throws Exception {

    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {		

				eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);
				
				eName = "Sortiment";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(3000);
		        
				eName = "Krimis & Thriller";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1500);		
				
				if ( iCap.screenHeight < 1024){

					eName = "subcategories";
					element = wd.findElementByName(eName);
					element.click();
					Thread.sleep(3000);
					
					eName = "Gehe zu Unterkategorie …";
					element = wd.findElementByName(eName);
					
					assertTrue("Shop SlideMenu doesn't show up",  element.isEnabled() || element.isDisplayed());
					
				} else {
					
//					eName = "BtnSlidingMenu";
//					element = wd.findElementByName(eName);
//					element.click();
//					Thread.sleep(1000);
			        
					eName = "Kategorien";
					element = wd.findElementByName(eName);
					Thread.sleep(1000);
					
					assertTrue("Shop SlideMenu doesn't show up",  element.isEnabled() || element.isDisplayed());
					
				}
			}
    	};
    	action.performAction();
    }
    
    @Test @Ignore
    public void pinShopSlideMenu() throws Exception {

    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
				Thread.sleep(3000);

		    	if (iCap.screenHeight >= 1024){
		            
		    		eName = "Sortiment";
					element = wd.findElementByName(eName);
					element.click();
			        Thread.sleep(3000);
			        
					eName = "Krimis & Thriller";
					element = wd.findElementByName(eName);
					element.click();
					Thread.sleep(1500);		
		    		
//					eName = "BtnSlidingMenu";
//					element = wd.findElementByName(eName);
//					element.click();
//					Thread.sleep(1000);
		    		
					eName = "BtnPinInactive";
		    		element = wd.findElementByName(eName);
		    		element.click();
		    		Thread.sleep(1000);
		    		
		    		eName = "BtnSlidingMenu";
		    		element = wd.findElementByName(eName);
		    		
		    		assertTrue("SlideMenu Pin Button wasn't pushed", element.isDisplayed());
		    	} else {
		    		assertTrue("iPhone/iPod don't require this test", true);
		    	}
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void shopSlideMenuCategory() throws Exception {

    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {
			
				eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);
				
				eName = "Sortiment";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(3000);
		        
				eName = "Krimis & Thriller";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1500);		
				
				if (iCap.screenHeight < 1024){

					eName = "subcategories";
					element = wd.findElementByName(eName);
					element.click();
					Thread.sleep(1000);
			
					eName = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]";
					element = wd.findElementByXPath(eName);
			    	String check = element.getAttribute("name");;
			    	element.click();
			
			    	eName = "//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]";
					element = wd.findElementByXPath(eName);
			    	String result = element.getAttribute("name");
			    	element.click();
			    				
					assertTrue("SlideMenu category was not displayed correctly. Expected: "+ check + "/Result: " + result, check.equals(result));
				
				} else {

//					eName = "BtnSlidingMenu";
//					element = wd.findElementByName(eName);
//					element.click();
//					Thread.sleep(1000);
			    	
			    	eName = "Eine Unterkategorie";
					element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
			    	String check = element.getAttribute("name");
			    	element.click();
			    		
			    	eName = "Page Header";
					element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]");
			    	String result = element.getAttribute("name");
			    	element.click();
			    		
			    	assertTrue("SlideMenu category was not displayed correctly. Expected: " + check + "/Result: " + result, check.equals(result));
			    	
			    }
			}
    	};
    	action.performAction();
        
    }
}