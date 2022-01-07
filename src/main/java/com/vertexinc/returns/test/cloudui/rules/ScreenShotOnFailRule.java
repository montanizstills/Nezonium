package com.vertexinc.returns.test.cloudui.rules;

import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShotOnFailRule implements TestWatcher {

    private final DriverHandler driverHandler;
    private final String outputDir;

//   public FailScreenshot(String outputDir){
//        this.outputDir=outputDir;
//    }

    public ScreenShotOnFailRule(String screenShotOutputDir, DriverRule driverRule) {
        this.driverHandler = driverRule.getDriverHandler();
        this.outputDir = screenShotOutputDir;
    }

    public ScreenShotOnFailRule(String screenShotOutputDir, DriverHandler driverHandler) {
        this.driverHandler = driverHandler;
        this.outputDir = screenShotOutputDir;
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        takeScreenShot(context.getDisplayName());
//        TestWatcher.super.testFailed(context);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        System.out.println("Test succeeded! Ignoring screenshot..");
//        TestWatcher.super.testSuccessful(context);
    }


    private void takeScreenShot(String testName) {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) getDriver();
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File(getOutputDir() + "/" + testName + ".jpg");
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new Error(e);
        }
        //logger.atDebug({},Screenshot successfully captured!)
    }

    private WebDriver getDriver() {
        return getDriverHandler().getDriver();
    }

    public String getOutputDir() {
        return this.outputDir;
    }

    private DriverHandler getDriverHandler() {
        return this.driverHandler;
    }


}
