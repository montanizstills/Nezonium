package com.vertexinc.returns.test.cloudui.rules;

import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShotOnFailRule extends TestWatcher {

    private final DriverHandler driverHandler;
    private final String outputDir;

//   public FailScreenshot(String outputDir){
//        this.outputDir=outputDir;
//    }

    public ScreenShotOnFailRule(String screenShotOutputDir, DriverHandler driverHandler) {
        this.driverHandler = driverHandler;
        this.outputDir = screenShotOutputDir;
    }


    @Override
    public void failed(Throwable throwable, Description description) {
        System.out.println("This test has failed!");
        System.out.println("Screenshot initiated!");
        String screenShotName = description.getMethodName();
        takeScreenShot(screenShotName);

    }

    private void takeScreenShot(String testName) {
        TakesScreenshot screenshot = (TakesScreenshot) getDriverHandler().getDriver();
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(getOutputDir() + "/" + testName + ".jpg");
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new Error(e);
        }
        //logger.atDebug({},Screenshot successfully captured!)
    }

    @Override
    public void finished(Description description) {
        if (getDriver() != null) {
            getDriver().quit();
        }

    }

    public WebDriver getDriver() {
        return this.driverHandler.getDriver();
    }

    public String getOutputDir() {
        return this.outputDir;
    }

    public DriverHandler getDriverHandler() {
        return driverHandler;
    }

}
