import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.SliderObject;
import io.github.bonigarcia.wdm.WebDriverManager;

@TestInstance(Lifecycle.PER_CLASS)
class JunitSelenium 
{
	public WebDriver driver;
	public SliderObject sliderObj;
	
	@BeforeEach
	public void Test1()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/slider");
		sliderObj =new SliderObject(driver);
	}
	@AfterEach
	public void TearDown()
	{
		driver.quit();
	}

	@Test
	void test()
	{
	 assertEquals("Slider", sliderObj.SliderVerify());
	 sliderObj.SliderPerf();
	 assertEquals("5",sliderObj.VerifySlider());
	}
}
