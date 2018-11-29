package tests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SignTest {
	
	WebDriver webdriver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "/home/douglas/selenium.setup/geckodriver");
		webdriver = new FirefoxDriver();
		webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		webdriver.get("http://www.juliodelima.com.br/taskit/");
	}
	
	@After
	public void close() {
		webdriver.close();
	}
	
	@Test
	public void testFazerCadastroNoTaskit() {
		
		webdriver.findElement(By.linkText("OK, I WANNA SIGN UP NOW")).click();
		webdriver.findElement(By.name("name")).sendKeys("Douglas");
		webdriver.findElement(By.name("login")).sendKeys("douglaspereiralimaxxxx");
		webdriver.findElement(By.name("password")).sendKeys("1234");
		webdriver.findElement(By.linkText("SAVE")).click();
		
		String message =  webdriver.findElement(By.className("me")).getText();
		
		assertEquals("HI, DouglasLima", message);
	}
	
	@Test
	public void testFazerLoginNoTaskit() {
		
		webdriver.findElement(By.linkText("Sign in")).click();
		webdriver.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys("douglaslimaxx");
		webdriver.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys("123");
		webdriver.findElement(By.linkText("SIGN IN")).click();
		
		String message =  webdriver.findElement(By.className("me")).getText();
		
		assertEquals("Hi, Douglas", message);
	}
	
}
