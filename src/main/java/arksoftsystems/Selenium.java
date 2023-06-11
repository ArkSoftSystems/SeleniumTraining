package arksoftsystems;

import org.openqa.selenium.WebDriver;

public class Selenium {

	public static void main(String[] args) throws InterruptedException {
		SeleniumConfig seleniumConfig = new SeleniumConfig();
		WebDriver webDriver = seleniumConfig.getWebDriver();

		webDriver.navigate().to("https://www.google.com");
	}

}
