package com.vertexinc.returns.test.cloudui.rules;

import com.vertexinc.returns.test.cloudui.util.Browsers;
import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShotOnFailRule extends TestWatcher {

    private WebDriver driver;
    private final String outputDir;
    private final String testName;

//   public FailScreenshot(String outputDir){
//        this.outputDir=outputDir;
//    }

    public ScreenShotOnFailRule(String screenShotOutputDir, String testName, WebDriver driver) {
        this.driver = driver;
        this.outputDir = screenShotOutputDir;
        this.testName = testName;
    }

    @Override
    public void failed(Throwable throwable, Description description) {
        System.out.println("This test has failed!");
        System.out.println("Screenshot initiated!");
        takeScreenShot(description.getMethodName(),getDriver());

    }

    private void takeScreenShot(String testName, WebDriver webDriver) {
        this.driver = webDriver;
        TakesScreenshot screenshot = (TakesScreenshot) getDriver();
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(getOutputDir()+testName+".jpg");
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new Error(e);
        }
        //logger.atDebug({},Screenshot successfully captured!)
    }

    @Override
    public void finished(Description description) {
        getDriver().quit();
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public String getOutputDir() {
        return this.outputDir;
    }

    private String getTestName() {
        return this.testName;
    }
}
