package org.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Task{
	static WebDriver driver;
	
	@Given("User should be navigated in Undostres homepage")
	public void user_should_be_navigated_in_undostres_homepage() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://prueba.undostres.com.mx/");
	}
	@When("User must gives the valid credentials")
	public void user_must_gives_the_valid_credentials() {
		driver.findElement(By.xpath("//input[@data-qa='celular-mobile']")).sendKeys("8465433546");
		driver.findElement(By.xpath("//input[@data-qa='celular-operator']")).click();
		driver.findElement(By.xpath("//li[@data-name='telcel']")).click();
		driver.findElement(By.cssSelector("input#suggested")).click();
	}
	@When("Select the siguiente option")
	public void select_the_siguiente_option() {
		driver.findElement(By.xpath("//li[@data-show='$10 (Recarga Saldo)']")).click();
		driver.findElement(By.xpath("//button[@data-qa='celular-pay']")).click();
	}
	@Then("The user should navigated to payment page")
	public void the_user_should_navigated_to_payment_page() {
		String tit = driver.getTitle();
		Assert.assertEquals("Verification on page","undostres.com.mx - Recargas en línea Telcel, Movistar, Iusacell, Unefon, Nextel, Virgin, Cierto, Weex, TeleVía, PASE Urbano, IAVE, Viapass",tit);
	}
	@Given("User must be in payment page")
	public void user_must_be_in_payment_page() {
		driver.switchTo().window(driver.getWindowHandle());
		driver.findElement(By.cssSelector("span#cardGly")).click();	
	}
	@When("User must gives the valid card credentials")
	public void user_must_gives_the_valid_card_credentials() {
		driver.findElement(By.xpath("//span[contains(text(),'Usar nueva tarjeta')]")).click();
		driver.findElement(By.xpath("(//input[@data-openpay-card='card_number'])[2]")).sendKeys("4111111111111111");
		driver.findElement(By.xpath("(//input[@data-conekta='card[exp_month]'])[2]")).sendKeys("11");
		driver.findElement(By.xpath("(//input[@data-conekta='card[exp_year]'])[2]")).sendKeys("25");
		driver.findElement(By.xpath("(//input[@data-conekta='card[cvc]'])[2]")).sendKeys("111");
	}
	@When("User proceed the recharge option")
	public void user_proceed_the_recharge_option() {
		driver.findElement(By.xpath("//input[@class='form-control email preventChromeAutofill']")).sendKeys("test@test.com");
		driver.findElement(By.xpath("(//button[@name=\"formsubmit\"])[3]")).click();
	}
	@When("User must provide the login credentials and Click the captcha manually")
	public void user_must_provide_the_login_credentials_and_click_the_captcha_manually() throws InterruptedException{
		driver.findElement(By.cssSelector("input#usrname")).sendKeys("automationUDT1@gmail.com");		
		driver.findElement(By.cssSelector("input#psw")).sendKeys("automationUDT123");
		Thread.sleep(5000);                           // Time for Captcha, click by manual
		driver.findElement(By.cssSelector("button#loginBtn")).click();
	}
	@Then("The user should gets successful message")
	public void the_user_should_gets_successful_message() throws InterruptedException{
		Thread.sleep(10000);
		WebElement err=driver.findElement(By.xpath("//h4[contains(text(),'Falló el pago con tu tarjeta.')]")); 
		String ttt=err.getText();
		Assert.assertEquals("Falló el pago con tu tarjeta.",ttt); 
		driver.quit();
	}}



 
 
