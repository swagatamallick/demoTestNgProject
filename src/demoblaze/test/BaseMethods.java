package demoblaze.test;
import org.testng.annotations.Test;
import org.junit.After;
import org.junit.BeforeClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseMethods {

	public WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//browser//geckodriver.exe");
		driver= new FirefoxDriver();	
		//driver.manage().window().maximize();

	}


	public void navigateToUrl() {
		driver.get("https://demoblaze.com/");
	}
	public String signUp() {
		driver.findElement(PageObject.signUpButton).click();
		String UsernamePassword = getAlphaNumericString(10); //keeping both username and password same
		driver.findElement(PageObject.signUpUserName).sendKeys(UsernamePassword);							
		driver.findElement(PageObject.signUpPassword).sendKeys(UsernamePassword);
		driver.findElement(PageObject.signUpConfirmButton).click();
		 WebDriverWait wait = new WebDriverWait(driver, 20);
		 wait.until(ExpectedConditions.alertIsPresent());
		 Alert alert = driver.switchTo().alert();
		 alert.accept();
		 return UsernamePassword;
	}
	public void login(String UsernamePassword) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		 wait.until(ExpectedConditions.elementToBeClickable(PageObject.loginButton));
		driver.findElement(PageObject.loginButton).click();
		driver.findElement(PageObject.loginUserName).sendKeys(UsernamePassword);							
		driver.findElement(PageObject.loginPassword).sendKeys(UsernamePassword);
		driver.findElement(PageObject.loginConfirmButton).click();
	}
	
	
	public void clickOnlaptopMenuButton() {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		 wait.until(ExpectedConditions.elementToBeClickable(PageObject.laptopMenuButton));		
		driver.findElement(PageObject.laptopMenuButton).click();
			}
	public void selectAnyProduct(String product) {
		driver.findElement(By.xpath("//a[text()='"+product+"']")).click();			
	}
	
	public void checkImageIsPresentOrNot(){
		    WebElement ImageFile = driver.findElement(PageObject.productImage);		       
	        Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
	        if (!ImagePresent)
	        {
	             System.out.println("Image not displayed.");
	        }
	        else
	        {
	            System.out.println("Image displayed.");
	        }
		}
	
	public void clickOnAddToCart() {
		driver.findElement(PageObject.addToCart).click();
		 WebDriverWait wait = new WebDriverWait(driver, 20);
		 wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}
	
	// function to generate a random string of length n
	static String getAlphaNumericString(int n)
	{

		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
				+ "0123456789"
				+ "abcdefghijklmnopqrstuvxyz";

		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			int index
			= (int)(AlphaNumericString.length()
					* Math.random());

			sb.append(AlphaNumericString
					.charAt(index));
		}

		return sb.toString();
	}


	@AfterTest
	public void endTest() {
		driver.quit();
	}


}
