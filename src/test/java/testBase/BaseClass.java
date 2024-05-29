package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	static public WebDriver driver;
	public Logger logger;
	public Properties p;

	@BeforeClass(groups = { "regression", "sanity", "master" })
	@Parameters({ "os", "browser" })

	public void setUp(String os, String br) throws IOException {
		// loading properties file
		File f = new File(".//src/test/resources/config.properties");
		FileInputStream fis = new FileInputStream(f);
		p = new Properties();
		p.load(fis);

		// loading log4j file
		logger = LogManager.getLogger(this.getClass());

		// remote
		if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {

			DesiredCapabilities cap = new DesiredCapabilities();
			// os
			if (os.equalsIgnoreCase("windows")) {
				cap.setPlatform(Platform.WINDOWS);
			} else if (os.equalsIgnoreCase("mac")) {
				cap.setPlatform(Platform.MAC);

			} else {
				System.out.println("no matching os");
				return;
			}

			// browser
			switch (br.toLowerCase()) {

			case "chrome":
				cap.setBrowserName("chrome");
				break;
			case "edge":
				cap.setBrowserName("MicrosoftEdge");
				break;
			default:
				System.out.println("no matching browser found");
				return;
			}
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		}

		else if (p.getProperty("execution_env").equalsIgnoreCase("local")) {

			// Launching browser based on condition locally
			switch (br.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("No matching browser...");
				return;
			}
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appUrl"));

	}



	@AfterClass(groups = { "regression", "sanity", "master" })
	public void teardow() {
		driver.quit();
	}

	public String randomString() {

		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;

	}

	public String randomnumber() {
		String generatedString = RandomStringUtils.randomNumeric(10);
		return generatedString;

	}

	public String randomAlphaNumeric() {
		String str = RandomStringUtils.randomAlphabetic(3);
		String num = RandomStringUtils.randomNumeric(3);
		return (str + "@" + num);

	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;

	}

}
