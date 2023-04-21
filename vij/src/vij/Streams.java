package vij;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Streams {

	@Test(enabled = false)
	public static void stream1() {
		// TODO Auto-generated method stub
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32");
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		List<WebElement> names = driver.findElements(By.xpath("//div/table[@id='product']/tbody/tr/td[2]"));
		List<String> og = names.stream().map(s -> s.getText()).collect(Collectors.toList());
		long c = og.stream().filter(s -> s.startsWith("E")).count();
		List<String> n = og.stream().filter(s -> s.endsWith("n")).collect(Collectors.toList());
		System.out.println(og);
		System.out.println(c);
		System.out.println(n);
	}

	@Test
	public void stream2() {
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32");
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		//driver.switchTo().newWindow(WindowType.TAB);
//		driver.switchTo().newWindow(WindowType.WINDOW);
//	driver.quit();
		
		List<WebElement> elements = driver.findElements(By.cssSelector("h4.product-name"));
		List<String> available = elements.stream().map(s -> s.getText()).map(s -> s.split(" ")[0]).collect(Collectors.toList());
		System.out.println(available);
		List<String> sorted = available.stream().sorted().collect(Collectors.toList());
		System.out.println(sorted);
		elements.stream().map(s -> s.getText()).map(s -> s.split(" ")[0]).forEach(s-> System.out.println(s));
		driver.close();
		
		//filter(s->s.startswith)
		// List<String> names = elements.stream().map(s ->
		// s.getText()).collect(Collectors.toList());
		// System.out.println(names);
		// names.stream().map(s -> s.split(" ")[0]).forEach(s -> System.out.println(s));



	}

}
