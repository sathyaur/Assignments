package Corona;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Shop {

	public static void main(String[] args) throws AWTException , InterruptedException{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","F:\\Testleaf_materials\\chromedriver.exe");
		//please set the chrome driver path according to your local path
		WebDriver driver = new  ChromeDriver();
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.shoppersstop.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//li[@id='profileImage']/a")).click();
		driver.findElement(By.id("j_username")).sendKeys("9894985828");
		driver.findElement(By.id("j_password")).sendKeys("abcd@123");
		driver.findElement(By.id("loginajax")).click();
		Robot robot = new Robot();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		Actions act = new Actions(driver);
		selectItem(driver,robot,executor,op,act);
		addCart(driver,executor,act);
				

	}
public static void selectItem(WebDriver driver,Robot robot,JavascriptExecutor executor,ChromeOptions op,Actions act) throws AWTException {
	
	robot.delay(5000);
	robot.keyPress(KeyEvent.VK_TAB);
	robot.keyPress(KeyEvent.VK_ENTER);
	
	act.moveToElement(driver.findElement(By.xpath("//a[@title='WOMEN']"))).perform();
	WebElement h=driver.findElement(By.xpath("//a[text()='Salwar & Churidar Suits']"));
	executor.executeScript("arguments[0].click();",h);
	op.addArguments("--disable-notifications");
	WebElement u=driver.findElement(By.xpath("//a[@data-code='205295921_9508']"));
	executor.executeScript("arguments[0].scrollIntoView();",u);
	executor.executeScript("arguments[0].click();",u);
}
	public static void addCart(WebDriver driver,JavascriptExecutor executor,Actions act) throws InterruptedException {
	WebElement xl=driver.findElement(By.xpath("//button[text()='XXL']"));
	executor.executeScript("arguments[0].scrollIntoView();",xl);
	executor.executeScript("arguments[0].click();",xl);
	
	//WebElement d=driver.findElement(By.xpath("//div[@class='check_available']/input"));
	//executor.executeScript("arguments[0].scrollIntoView();",d);
	//executor.executeScript("argument[0],click();",d);
	//d.sendKeys("400001");
	//WebElement f=driver.findElement(By.xpath("//div[@class='check_available']/input[2]"));
	//executor.executeScript("arguments[0].scrollIntoView();",f);
	//executor.executeScript("argument[0],click();",f);
	
	WebElement r=driver.findElement(By.id("addToCartButton"));
	act.moveToElement(r).click();

	driver.findElement(By.xpath("//a[@data-mini-cart-name='Cart']")).click();
	driver.findElement(By.xpath("//button[@disabled='disabled']")).click();
	String value = driver.findElement(By.xpath("//div[@class='shopping-grand-total border-btm']/ul/li/div[2]")).getText();
	System.out.println(value);
	int val = Integer.parseInt(value);
	if (val==1249) {
		System.out.println("Pass");
	}else {
		System.out.println("Fail");
	}
	
	
	
}
}