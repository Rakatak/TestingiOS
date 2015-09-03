package com.thalia.xca.ios;

import static org.junit.Assert.assertTrue;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import com.google.common.annotations.VisibleForTesting;
import com.thalia.xca.ios.prop.AbstractExcAction;
import com.thalia.xca.ios.prop.AppiumSetup;
import com.thalia.xca.ios.prop.IOSCapabilities;

public class ShoppingCartTest {
	
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
    public void checkIcon() throws Exception {
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
				
				eName = "Krimis & Thriller";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(5000);
		        
		        iCap.tapFirstElement(wd);
		        Thread.sleep(5000);
		        
		        if (iCap.screenHeight < 1024){
		        	wd.swipe(300, (int)(iCap.screenHeight*0.8), 300, (int)(iCap.screenHeight*0.2), 500);
		        }

		        eName = "In den Warenkorb";
		        MobileElement temp = iCap.putInCart(wd, eName);
				temp.click();
		        Thread.sleep(3000);
				
		        eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(1000);
				
		        eName = "Warenkorb";
				element = wd.findElementByName(eName);
		        Thread.sleep(2000);
		        
				assertTrue("Article not present in shopping cart though expected", element.getAttribute("value").equals("1 Objekt") || element.getAttribute("value").equals("1"));

			}
    	};
    	action.performAction();
    }
    
    @Test
    public void checkArticle() throws Exception {
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {

				String check;
				Boolean checker = false;
				
				eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
				
				eName = "Sortiment";
				element = wd.findElementByName(eName);
				element.click();
				
				eName = "Fantasy & Science Fiction";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(5000);
		        
		        iCap.tapFirstElement(wd);
		        Thread.sleep(3000);

		        if (iCap.screenHeight < 1024){
		        	wd.swipe(300, (int)(iCap.screenHeight*0.8), 300, (int)(iCap.screenHeight*0.35), 500);
		        }
		        
		        eName = "In den Warenkorb";
		        MobileElement temp = iCap.putInCart(wd, eName);
		        Thread.sleep(3000);
		        
				wd.getPageSource();
				eName = "Article Title";
				element = wd.findElementByXPath(AppiumSetup.articleTitleSmall);
				check = element.getAttribute("name");
		        Thread.sleep(2000);
		        
				temp.click();
		        Thread.sleep(3000);
		        
		        eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(2000);
				
		        eName = "Warenkorb";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(5000);
		        
				List<MobileElement> temps;
		        wd.getPageSource();
		        temps = wd.findElementsByClassName("UIAStaticText");
		        
		        for (MobileElement el: temps){
		        	if (check.contains(el.getAttribute("name"))){
		        		checker =  true;
		        		break;
		        	}
		        }

				assertTrue("Article not present in Shopping Cart though expected. check: " + check + " result: " , checker == true);
			}
    	};
    	action.performAction();
    }
    
    @Test
    public void deleteArticle() throws Exception {
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
				
				eName = "Krimis & Thriller";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(5000);
		        
		        iCap.tapFirstElement(wd);
		        Thread.sleep(5000);
		        
		        if (iCap.screenHeight < 1024){
		        	wd.swipe(300, (int)(iCap.screenHeight*0.8), 300, (int)(iCap.screenHeight*0.2), 500);
		        }

		        eName = "In den Warenkorb";
		        MobileElement temp = iCap.putInCart(wd, eName);
		        temp.click();
		        Thread.sleep(3000);
		        
		        eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(2000);
				
		        eName = "Warenkorb";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(5000);
		        
		        if (iCap.screenHeight < 1024){
					wd.swipe((int)(iCap.screenWidth*0.7), (int)(iCap.screenHeight*0.6), (int)(iCap.screenWidth*0.8), (int)(iCap.screenHeight*0.36), 500);
					Thread.sleep(3000);
			    }
		        
				List<MobileElement> temps;
		        eName = "Artikel Entfernen Link";
		        temps = wd.findElementsByClassName("UIALink");
		        temps.get(3).click();
		    	Thread.sleep(10000);
		        
		        eName = "Warenkorb";
				element = wd.findElementByName(eName);
		        Thread.sleep(2000);
		        
				assertTrue("Article still present in Shopping Cart though expected not", !element.getAttribute("value").equals("1 Objekt"));

			}
    	};
    	action.performAction();
    }
    
    @Test
    public void toWishListArticle() throws Exception {
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {

				String check;
				
				eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
				
				eName = "Sortiment";
				element = wd.findElementByName(eName);
				element.click();
				
				eName = "Fantasy & Science Fiction";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(4000);
		        
		        iCap.tapFirstElement(wd);
		        Thread.sleep(3000);

		        if (iCap.screenHeight < 1024){
		        	wd.swipe(300, (int)(iCap.screenHeight*0.7), 300, (int)(iCap.screenHeight*0.4), 500);
		        }
		        
				eName = "In den Warenkorb";
		        MobileElement temp = iCap.putInCart(wd, eName);
		        Thread.sleep(3000);
		        
				wd.getPageSource();
				eName = "Article Title";
				element = wd.findElementByXPath(AppiumSetup.articleTitleSmall);
				check = element.getAttribute("name");
		        Thread.sleep(2000);
		        
		        temp.click();
		        Thread.sleep(3000);
		        
		        eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(2000);
				
		        eName = "Warenkorb";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(15000);
		        
				List<MobileElement> temps;
		        eName = "Artikel zum Merkzettel";
		        temps = wd.findElementsByClassName("UIALink");
		        temps.get(2).click();
		        Thread.sleep(6000);
		        
		        eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(2000);
		        
		        eName = "Merkzettel";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(3000);
		        
		        if (iCap.screenHeight < 1024){
		        	eName = "Article on wishlist";
					element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIACollectionView[1]/UIACollectionCell[1]");
					element.click();
			        Thread.sleep(2000);
		        	
		        }
		        temps = wd.findElementsByName(check); 
		        
				assertTrue("Article not present in Wish List though expected", temps.size() != 0);

			}
    	};
    	action.performAction();
    }
}