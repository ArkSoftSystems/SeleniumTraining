package arksoftsystems;

public enum SeleniumPropertiesEnum {
	
	ARCHITECTURE("architecture"),
	WEBDRIVER_BROWSER_NAME("browser");
	
	
	public final String value;
	
	private SeleniumPropertiesEnum(String seleniumPropertiesEnum) {
		this.value = seleniumPropertiesEnum;
	}
}
