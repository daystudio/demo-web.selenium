package stepdefs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefs_demo {
	private ChromeOptions options;
	private WebDriver driver;

	@Given("I launch Chrome browser")
	public void i_launch_Chrome_browser() {
		System.out.println("--> Launch Chrome A");
		System.setProperty("webdriver.chrome.driver", "/Users/k/Documents/_projects/demo-web.selenium/lib/chromedriver_80");
		options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.setHeadless(true);
	}

	@When("I open demo.reactjs")
	public void i_open_Google_Homepage() {
		System.out.println("--> Open demo.reactjs");
		driver = new ChromeDriver(options);
		driver.get("http://demo.reactjs.ckchan.hk/");
		System.out.println("--> Page title is - " + driver.getTitle());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("I check list count on demo.reactjs")
	public void i_search_selenium_webdriver_on_Google() {
		System.out.println("--> Check has list:" + (driver.findElement(By.id("list")).getAttribute("class").length() > 0));
		System.out.println("--> Check list count:" + driver.findElements(By.xpath("//*[@id=\"list\"]/div")).size());
		List<WebElement> lst = driver.findElements(By.xpath("//*[@class=\"MuiTypography-root MuiCardHeader-title MuiTypography-body2 MuiTypography-displayBlock\"]"));
		for (WebElement e : lst) {
			System.out.println("  " + e.getText());
		}
		assert (lst.size() >= 4);

	}

	@Then("check the add function")
	public void check_the_search_result_stats() {
		driver.findElement(By.id("add")).click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("--> has add button:" + (driver.findElement(By.xpath("//*[@class=\"MuiDialog-root\"]")).getLocation() != null));
		assert(driver.findElement(By.xpath("//*[@class=\"MuiDialog-root\"]")).getLocation() != null);
		driver.close();
	}

}
