package com.thalia.xca.ios.prop;

import static org.junit.Assert.assertTrue;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.SessionNotFoundException;

public abstract class AbstractExcAction {

	protected String eName = null;
	protected MobileElement element = null;
	protected IOSDriver<MobileElement> wd;
	
	public AbstractExcAction(IOSDriver<MobileElement> wd){
		this.wd = wd;
	}
	
	public final void performAction() {
		
		try {
			Thread.sleep(1000);
			actionPerformedWithThrows();
			
		} catch (NoSuchElementException ex) {
    		assertTrue("Element \"" + eName + "\" could not be located : NoSuchElementException", false);
		} catch (InterruptedException e) {
    		assertTrue("Some Thread interrupted: " + e.getStackTrace(), false);
		} catch (ArrayIndexOutOfBoundsException e) {
    		assertTrue("Element \"" + eName + "\" could not be located : ArrayIndexOutOfBoundsException", false);
		} catch (IndexOutOfBoundsException e) {
    		assertTrue("Element \"" + eName + "\" could not be located : IndexOutOfBoundsException", false);
		} catch (SessionNotFoundException e) {
    		assertTrue("Before clicking Element \"" + eName + "\" the app broke down: SessionNotFoundException", false);
		} finally {
			try {
				wd.quit();
			} catch (Exception e) {
	    		assertTrue("Before clicking Element \"" + eName + "\" the app broke down: SessionNotFoundException", false);

			}
		}
	}
	
	public abstract void actionPerformedWithThrows()
			throws NoSuchElementException, InterruptedException;
}
