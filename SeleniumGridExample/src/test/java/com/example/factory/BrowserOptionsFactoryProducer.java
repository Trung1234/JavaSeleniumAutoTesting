package com.example.factory;

public class BrowserOptionsFactoryProducer {
	public static BrowserOptionsFactory getFactory(String browserType) {
        if (browserType.equalsIgnoreCase("chrome")) {
            return new ChromeOptionsFactory();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            return new FirefoxOptionsFactory();
        }
        throw new IllegalArgumentException("Unknown browser type: " + browserType);
    }
}
