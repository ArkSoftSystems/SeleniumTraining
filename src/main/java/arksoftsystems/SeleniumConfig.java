package arksoftsystems;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import arksoftsystems.utils.ConfigurationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumConfig {

	private static Properties configurationProperties = new Properties();
	public WebDriverManager webDriverManager = WebDriverManager.getInstance();
	private ConfigurationUtils configurationUtils = new ConfigurationUtils();

	public SeleniumConfig() {
		initConfiguration();
		setEnviroment();
	}

	public WebDriver getWebDriver() {
		return setBrowser();
	}

	private void initConfiguration() {
		try {
			configurationProperties
					.load(new FileInputStream(configurationUtils.getFileFromResource("configuration.properties")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("static-access")
	private void setEnviroment() {
		String architecture = configurationProperties.getProperty(SeleniumPropertiesEnum.ARCHITECTURE.value);
		switch (architecture) {
		case "64":
			webDriverManager.getInstance().arch64();
			break;
		case "32":
			webDriverManager.getInstance().arch32();
			break;
		case "arm":
			webDriverManager.getInstance().arm64();
			break;
		default:
			break;
		}
	}

	@SuppressWarnings("static-access")
	private WebDriver setBrowser() {
		String browser = configurationProperties.getProperty(SeleniumPropertiesEnum.WEBDRIVER_BROWSER_NAME.value);
		switch (browser) {
		case "chrome":
			return webDriverManager.chromedriver().create();
		case "firefox":
			return webDriverManager.firefoxdriver().create();
		case "edge":
			return webDriverManager.edgedriver().create();
		default:
			return webDriverManager.chromedriver().create();
		}
	}

}
