package vij;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Caleneder {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32");
		driver.get("https://www.path2usa.com/travel-companion/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// driver.navigate().refresh();

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement date = driver.findElement(By.cssSelector("input[id='form-field-travel_comp_date']"));
		// wait.until(ExpectedConditions.elementToBeClickable(date));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", date);
		// js.executeScript("window.scrollBy(209,1100");

		Thread.sleep(1000);

		date.click();

		Thread.sleep(1000);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		while (!driver.findElement(By.xpath("//span[@title='Scroll to increment']")).getText().contains("June")) {

			// driver.findElement(By.cssSelector(".flatpickr-next-month")).click();
			// instead of single its getting double click , so give one month extra
			Thread.sleep(1000);

			Actions a = new Actions(driver);
			Thread.sleep(1000);
			a.moveToElement(driver.findElement(By.cssSelector(".flatpickr-next-month"))).click().build().perform();

		}

		Thread.sleep(1000);
		List<WebElement> days = driver.findElements(By.cssSelector("[class='flatpickr-day ']"));
		for (int i = 0; i < days.size(); i++) {
			String day = days.get(i).getText();
			System.out.println(day);
			if (day.equalsIgnoreCase("10")) {
				days.get(i).click();
				break;
			}
		}

		File srcc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// FileUtils.copyDirectory(srcc, new File("C:\\Users\\hariv\\calender.png"));
		FileUtils.copyFile(srcc, new File("C:\\Users\\hariv\\vvvv.png"));

		driver.close();

	}

}
