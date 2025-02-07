package googlepixeldevice;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;

import static java.time.Duration.ofSeconds;

public class FunctionalTest extends Base 
	{

		public void Preferences() throws MalformedURLException 
			{
				AndroidDriver<AndroidElement> driver= Capabilities();
			
			
				driver.findElementByXPath("//android.widget.TextView[@text = 'Preference']").click();
				driver.findElementByXPath("//android.widget.TextView[@text = '3. Preference dependencies']").click();
				driver.findElementByXPath("//android.widget.CheckBox[@resource-id = 'android:id/checkbox']").click();
				driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
				driver.findElementByClassName("android.widget.EditText").sendKeys("Ashwa");
				driver.findElementsByClassName("android.widget.Button").get(1).click();
				driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
				driver.findElementsByClassName("android.widget.Button").get(0).click();
	
			}
	
		public void Views1() throws MalformedURLException, InterruptedException 
			{
				AndroidDriver<AndroidElement> driver= Capabilities();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
				//Using UIautomator on Properties
/*1*/			int items = driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size();
				System.out.println(items);
				
				// touch Action Methods Implemented
/*2*/			TouchAction touch = new TouchAction(driver);
				WebElement expandlist = driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")");
				//Every end of touch action we need to use Perform operation
				touch.tap(tapOptions().withElement(element(expandlist))).perform();
				driver.findElementByXPath("//android.widget.TextView[@text = '1. Custom Adapter']").click();
				
/*3*/			WebElement name = driver.findElementByXPath("//android.widget.TextView[@text = 'People Names']");
				//Long Press and hold it for duration
				touch.longPress(longPressOptions().withElement(element(name)).withDuration(ofSeconds(2))).release().perform();
				Thread.sleep(2000);
				
				if( driver.findElementById("android:id/title").isDisplayed()) 
					{
						System.out.println("Test Case Passed");
					}
				else 
					{
						System.out.println("Test Case Failed");
					}
			
			}
		public void View2() throws MalformedURLException, InterruptedException 
			{
				AndroidDriver<AndroidElement> driver = Capabilities();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementByXPath("//android.widget.TextView[@text ='Views']").click();
				driver.findElementByXPath("//android.widget.TextView[@text ='Expandable Lists']").click();
				driver.findElementByXPath("//android.widget.TextView[@text = '1. Custom Adapter']").click();
			
				WebElement name = driver.findElementByXPath("//android.widget.TextView[@text = 'Dog Names']");
				TouchAction touch = new TouchAction(driver);
				touch.longPress(longPressOptions().withElement(element(name)).withDuration(ofSeconds(2))).release().perform();
				Thread.sleep(2000);
			
				if( driver.findElementById("android:id/title").isDisplayed()) 
					{
						System.out.println("Test Case Passed");
					}
				else 
					{
						System.out.println("Test Case Failed");
					}
			
			
			}
		
		public void View3() throws MalformedURLException, InterruptedException 
			{
				AndroidDriver<AndroidElement> driver = Capabilities();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
				driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
				driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")").click();
				driver.findElementByXPath("//android.widget.TextView[@text = '1. Custom Adapter']").click();
				WebElement name = driver.findElementByAndroidUIAutomator("text(\"Cat Names\")");
				TouchAction action = new TouchAction(driver);
				action.longPress(longPressOptions().withElement(element(name)).withDuration(ofSeconds(2))).release().perform();
				Thread.sleep(2000);
				if (driver.findElementById("android:id/title").isDisplayed())
					{
						System.out.println("Test Case Passed");
					}
			else
					{
						System.out.println("Test Case Failed");
					}
		
			
			}
		
		public void Viewswipe() throws MalformedURLException, InterruptedException 
			{
				AndroidDriver<AndroidElement> driver = Capabilities();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
				driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
				driver.findElementByAndroidUIAutomator("text(\"Date Widgets\")").click();
				driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
				driver.findElementByXPath("//*[@content-desc= '9']").click();
				
				// Now swiping through the clock sticks in 180 degree
				// long press //on element//2 sec//move to another element and you release
				WebElement oneTime = driver.findElementByXPath("//*[@content-desc= '15']");
				WebElement anotherTime = driver.findElementByXPath("//*[@content-desc= '45']");
				TouchAction touch = new TouchAction(driver);
				touch.longPress(longPressOptions().withElement(element(oneTime)).withDuration(ofSeconds(3))).moveTo(element(anotherTime)).release().perform();
			}
		
				//Change time script validation
		
		public void changeTime() throws MalformedURLException, InterruptedException 
			{
				AndroidDriver<AndroidElement> driver = Capabilities();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
				driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
				driver.findElementByAndroidUIAutomator("text(\"Date Widgets\")").click();
				driver.findElementByAndroidUIAutomator("text(\"1. Dialog\")").click();
				driver.findElementByAndroidUIAutomator("text(\"CHANGE THE TIME\")").click();
				WebElement hour = driver.findElementByXPath("//*[@content-desc= '9']");
				hour.click();
				Thread.sleep(2000);
				WebElement setTime= driver.findElementByXPath("//*[@content-desc= '0']");
				TouchAction touch = new TouchAction(driver);
				touch.tap(tapOptions().withElement(element(setTime))).perform();
				//touch.longPress(longPressOptions().withElement(set))
			
				WebElement oneTime = driver.findElementByXPath("//*[@content-desc= '0']");
				WebElement anotherTime = driver.findElementByXPath("//*[@content-desc= '45']");
			
				touch.longPress(longPressOptions().withElement(element(oneTime)).withDuration(ofSeconds(3))).moveTo(element(anotherTime)).release().perform();
				Thread.sleep(2000);
				driver.findElementByAndroidUIAutomator("text(\"AM\")").click();
				driver.findElementByAndroidUIAutomator("text(\"OK\")").click();
			
			}
		
		public void scrollDown() throws MalformedURLException
			{
				AndroidDriver<AndroidElement> driver = Capabilities();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
				driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Hover Events\"))").click();
				driver.navigate().back();
				driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Seek Bar\"))").click();
			
			}
		public void dragAndDrop() throws MalformedURLException 
			{
				AndroidDriver<AndroidElement> driver = Capabilities();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
				driver.findElementByXPath("//android.widget.TextView[@text = 'Drag and Drop']").click();;
				WebElement srcobj = driver.findElementsByClassName("android.view.View").get(0);
				WebElement destobj = driver.findElementsByClassName("android.view.View").get(1);
				
				TouchAction action = new TouchAction(driver);
				action.longPress(element(srcobj)).moveTo(element(destobj)).release().perform();
				
				
				
			}
		
		
		
		

	}
