package googlepixeldevice;

import java.net.MalformedURLException;

public class MainTestClass extends FunctionalTest
{

	public static void main(String[] args) throws MalformedURLException, InterruptedException 
		{
		
			FunctionalTest Test = new FunctionalTest();
			Test.Preferences();
			Test.Views1();
			Test.View2();
			Test.View3();
			Test.Viewswipe();
		}	
}
