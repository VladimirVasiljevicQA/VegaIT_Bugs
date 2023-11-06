package stepDefinitions;

import java.io.File;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;
import resources.Base;

public class AfterHooks extends Base{
	
	public AfterHooks(WebDriver driver) {
        this.driver = driver;
    }
	
public void screenshot(Scenario scenario) {
	
	// Capture a screenshot and attach it to the scenario if it fails.
    if (scenario.isFailed()) {
        try {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            String screenshotPath= System.getProperty("user.dir")+"\\screenshots\\"+screenshotName+".png";
            Files.write(new File(screenshotPath).toPath(), screenshot);
            scenario.attach(screenshot, "image/png", "screenshot");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
public void close() {
	 // Close the WebDriver after each scenario.
    driver.quit();
}
}
