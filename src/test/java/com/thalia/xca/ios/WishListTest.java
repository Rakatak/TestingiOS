package com.thalia.xca.ios;

import static org.junit.Assert.assertTrue;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import com.google.common.annotations.VisibleForTesting;
import com.thalia.xca.ios.prop.AbstractExcAction;
import com.thalia.xca.ios.prop.AppiumSetup;
import com.thalia.xca.ios.prop.IOSCapabilities;

public class WishListTest {
	
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
				Thread.sleep(3000);
				
				eName = "Sortiment";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(3000);

				eName = "Krimis & Thriller";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(4000);
		        
				eName = "First Article";
				element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[1]");
				element.click();
		        Thread.sleep(2000);

		        eName = "ic merkzettel";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(3000);
				
		        eName = "Merkzettel";
				element = wd.findElementByName(eName);
		        Thread.sleep(2000);
		        
				assertTrue("Article not present in Wish List though expected", element.getAttribute("value").equals("1 Objekt"));

			}
    	};
    	action.performAction();
    }
	
	@Test
    public void checkHistory() throws Exception {
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
				element.click();
		        Thread.sleep(4000);
		        
				eName = "First Article";
				element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[1]");
				element.click();
		        Thread.sleep(2000);
				
		        eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
				Thread.sleep(3000);
				
		        eName = "Merkzettel";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(2000);
		        
		        eName = "First Article";
				element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIACollectionView[1]/UIACollectionCell[1]");
		        Thread.sleep(2000);
		        
				assertTrue("Article not present in Wish List History though expected", element.isEnabled());

			}
    	};
    	action.performAction();
    }
    
    @Test
    public void doubleArticleTest() throws Exception {
    	   
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
		        Thread.sleep(3000);

				eName = "Krimis & Thriller";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(3000);
		        
				eName = "First Article";
				element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[1]");
				element.click();
		        Thread.sleep(2000);

				eName = "Article Title";
				element = wd.findElementByXPath(AppiumSetup.articleTitleSmall);
				check = element.getAttribute("name");
		        Thread.sleep(2000);

		        eName = "ic merkzettel";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(3000);
		        
		        eName = "ic merkzettel select";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(3000);		        
		        
		        eName = "Entfernen";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(2000);
		        
				eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(2000);
		        element.click();
		        Thread.sleep(2000);
		        
		        eName = "Merkzettel";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(3000);
		        
		        List<MobileElement> list = new ArrayList<MobileElement>();
				list = wd.findElementsByName(check);

				assertTrue("Article still appears on whishlist after deletion", list.size() == 0);     

			}
    	};
    	action.performAction();
    }
    
    @Test
    public void toShoppingCartTest() throws Exception {
    	   
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
		        Thread.sleep(3000);

				eName = "Krimis & Thriller";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(3000);
		        
				eName = "First Article";
				element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[1]");
				element.click();
		        Thread.sleep(2000);

				eName = "Article Title";
				element = wd.findElementByXPath(AppiumSetup.articleTitleSmall);
				check = element.getAttribute("name");
		        Thread.sleep(2000);

		        eName = "ic merkzettel";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(3000);
		        
				eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(2000);
		        element.click();
		        Thread.sleep(2000);
		        
		        eName = "Merkzettel";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(6000);
		        
		        wd.getPageSource();
		        eName = "ic warenkorb";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(3000);
		        
	            wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		        
		        List<MobileElement> list = new ArrayList<MobileElement>();
				list = wd.findElementsByName(check);

				assertTrue("Article still appears on whishlist after added to shopping cart", list.size() == 0);     

			}
    	};
    	action.performAction();
    }
    
    @Test
    public void deleteArticleTest() throws Exception {
    	   
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
		        Thread.sleep(3000);

				eName = "Krimis & Thriller";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(3000);
		        
				eName = "First Article";
				element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[1]");
				element.click();
		        Thread.sleep(2000);

				eName = "Article Title";
				element = wd.findElementByXPath(AppiumSetup.articleTitleSmall);
				check = element.getAttribute("name");
		        Thread.sleep(2000);

		        eName = "ic merkzettel";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(3000);

				eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(2000);
		        element.click();
		        Thread.sleep(2000);
		        
		        eName = "Merkzettel";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(3000);
		        
		        eName = "ic trash";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(3000);
		        
		        eName = "Entfernen";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(3000);
		        
	            wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	            
		        List<MobileElement> list = new ArrayList<MobileElement>();
				list = wd.findElementsByName(check);

				assertTrue("Article still appears on whishlist after deletion", list.size() == 0);     

			}
    	};
    	action.performAction();
    }
    
    @Test
    public void checkArticleTest() throws Exception {
    	   
    	AbstractExcAction action =  new AbstractExcAction(wd){
			@Override
			public void actionPerformedWithThrows() throws NoSuchElementException, InterruptedException {		
			
				String check;
		        Thread.sleep(3000);

				eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(3000);

				eName = "Sortiment";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(3000);

				eName = "Kalender";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(3000);
		        
				eName = "First Article";
				element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[1]");
				element.click();
		        Thread.sleep(2000);

				eName = "Article Title";
				element = wd.findElementByXPath(AppiumSetup.articleTitleSmall);
				check = element.getAttribute("name");
		        Thread.sleep(2000);
		      
		        eName = "ic merkzettel";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(3000);
		        
				eName = "Mehr";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(2000);
		        element.click();
		        Thread.sleep(2000);
		        
		        eName = "Merkzettel";
				element = wd.findElementByName(eName);
				element.click();
		        Thread.sleep(3000);
		        
		        eName = "Article on list";
				element = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[1]");
				String result = element.getAttribute("name");
				
				assertTrue("Article on Wishlist doesn't match article selected check: " + check +" result: " + result, check.contains(result));     

			}
    	};
    	action.performAction();
    }   
}