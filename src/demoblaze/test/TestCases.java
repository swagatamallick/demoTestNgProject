package demoblaze.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;


public class TestCases extends BaseMethods {
	
@Test
public void DemoBlazeWorkflow() {
	try {
	navigateToUrl();
	assertEquals("STORE",driver.getTitle());
	String UserNamePassword= signUp();
    login(UserNamePassword);
	Thread.sleep(3000);
	clickOnlaptopMenuButton();
	selectAnyProduct("Sony vaio i5"); //Here it is selecting " Sony vaio i5 "
	Thread.sleep(3000);
	checkImageIsPresentOrNot();
	assertEquals(driver.findElement(PageObject.productNameHeader).getText(), "Sony vaio i5");
	clickOnAddToCart();	
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}
