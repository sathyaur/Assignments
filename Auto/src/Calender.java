import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender {

	public static void main(String[] args) {
		
System.setProperty("webdriver.chrome.driver","F:\\Testleaf_materials\\chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
driver.get("https://www.spicejet.com/");
driver.manage().window().maximize();
driver.findElement(By.xpath("//button[@class='ui-datepicker-trigger']")).click();

System.out.println(driver.findElement(By.xpath("(//div[@class='ui-datepicker-title'])[2]/span")).getText());
while(!driver.findElement(By.xpath("(//div[@class='ui-datepicker-title'])[2]/span")).getText().contains("Oct")) {



	driver.findElement(By.xpath("//a[@title='Next']/span")).click();
//}
	//}
}
int count=driver.findElements(By.xpath("//td[@data-month='9']")).size();
List <WebElement>d=driver.findElements(By.xpath("//td[@data-month='9']"));
System.out.println(d);
for(int i=0;i<count;i++) {
	String day=driver.findElements(By.xpath("//td[@data-month='9']")).get(i).getText();
	System.out.println(day);
	if (day.equalsIgnoreCase("10")) {
		driver.findElements(By.xpath("//td[@data-month='9']")).get(i).click();
	}
	
}
//List<WebElement> days=driver.findElements(By.xpath("(//td[@data-handler='selectDay']/a)[2]"));
//System.out.println(days);

//int count=driver.findElements(By.xpath("//td[@data-handler='selectDay']/a")).size();
//for (int i=1;i<count;i++ ) {
	//String day=driver.findElements(By.xpath("//td[@data-handler='selectDay']/a")).get(i).getText();
	//if(day.contains("10")) {
		//driver.findElements(By.xpath("//td[@data-handler='selectDay']/a")).get(i).click();
	

}}
