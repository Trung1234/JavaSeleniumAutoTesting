package com.example.factory;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class  FirefoxOptionsFactory  implements BrowserOptionsFactory  {

	public Object createOptions() {
		 // Set FirefoxOptions
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");  // Example option for headless mode

        // Create DesiredCapabilities and merge with FirefoxOptions
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);

        // Combine FirefoxOptions and DesiredCapabilities
        options.merge(capabilities);
        // Add any additional Firefox options here
        return options;
	}

}
