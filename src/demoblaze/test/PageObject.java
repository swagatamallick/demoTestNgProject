package demoblaze.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObject {
	WebDriver driver;

    static By signUpButton = By.id("signin2");
    static By signUpUserName = By.id("sign-username");
    static By signUpPassword =By.id("sign-password");
    static By signUpConfirmButton = By.xpath("//button[text()='Sign up']");    
    static By loginButton = By.id("login2");
    static By loginUserName = By.id("loginusername");
    static By loginPassword =By.id("loginpassword");
    static By loginConfirmButton = By.xpath("//button[text()='Log in']");
    static By nameofuser =By.id("nameofuser");
    static By laptopMenuButton =By.xpath("//a[text()='Laptops']");
    static By productImage =By.xpath("//img[contains(@src,'imgs/')]");
    static By productNameHeader =By.xpath("//h2");
    static By addToCart= By.xpath("//a[contains(text(),'Add to cart')]");

    



    public PageObject(WebDriver driver){

        this.driver = driver;

    }
}
