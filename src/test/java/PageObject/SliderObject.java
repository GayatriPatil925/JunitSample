package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SliderObject 
{
	public WebDriver driver;
     
    public SliderObject(WebDriver driver)
    {
    	this.driver=driver;
    }
    //pageObject 
    By sliderVerification = By.xpath("//h1[contains(text(),'Slider')]");
    
    public String SliderVerify()
    {
    	return driver.findElement(sliderVerification).getText();
    }
     
    By slider= By.xpath("//input[@class='range-slider range-slider--primary']");
    
    public void SliderPerf()
    {
    	 int SliderValue = 5;
         boolean con = false;
         while (!con)
         {
             if (SliderValue > 25)
             {
                 driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
             }
             else
             {
                 driver.findElement(slider).sendKeys(Keys.ARROW_LEFT);
             }
             //System.out.println(driver.findElement(slider).getAttribute("value"));
             System.out.println(String.valueOf(SliderValue));
             if (driver.findElement(slider).getAttribute("value") == String.valueOf(SliderValue))
             {
                 con = true;
             }
         }
    }
    
    public String VerifySlider()
    {
    	return driver.findElement(By.id("sliderValue")).getAttribute("value");
    }
}
