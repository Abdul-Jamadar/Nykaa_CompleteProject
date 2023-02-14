package Nykaa_Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Files;

import Nykaa.PageObjects.a_LoginPage;
import Nykaa.PageObjects.b_HomePage;
import Nykaa.PageObjects.c_ProductsPage;
import Nykaa.PageObjects.d_CartVerification;
import io.github.bonigarcia.wdm.WebDriverManager;

public class _Test_Utility {
	public String userName;
	public String phoneNumber;
	public String homeTab;
	public a_LoginPage login;
	public b_HomePage homepage;
	public d_CartVerification cart;
	public c_ProductsPage prod;
	public Properties prop = new Properties();
	public WebDriver driver;

	public void initializeDriver() throws Exception {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\Nykaa_Project\\Nykaa_resources\\GlobalProperties.properties");
		prop.load(fis);
		userName = prop.getProperty("userName");
		phoneNumber = prop.getProperty("phoneNumber");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("headless");
		String browser = System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browserName");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Nykaa_Project/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browser.contains("headless")) {
			System.setProperty("webdriver.chrome.driver", "./Nykaa_Project/Drivers/chromedriver.exe");
			driver = new ChromeDriver(options);
		}
		
		else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		else if (browser.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
	}

	public void Launch() {
		driver.get("https://www.nykaa.com/");
		homeTab = driver.getWindowHandle();
	}

	public void verifyTitle(String title) {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, title);
	}

	public List<HashMap<String, String>> getJsonDataToMap(String FilePath) throws Exception {
		String jsonContent = FileUtils.readFileToString(new File(FilePath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	public String TakeScreenshotAsLocation(String fileName, WebDriver driver) throws IOException {
		File SS = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(SS, new File(".//Nykaa_Project//Reports//" + fileName + ".png"));
		return "./ScreenShot/" + fileName + ".png";
	}

	@BeforeTest(alwaysRun = true)
	public void Setup() throws Exception {
		initializeDriver();
		login = new a_LoginPage(driver);
		cart = new d_CartVerification(driver);

	}

	@AfterTest(alwaysRun = true)
	public void close() {
		driver.quit();
	}
}
