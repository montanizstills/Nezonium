package com.vertexinc.returns.test.cloudui;

import com.vertexinc.returns.test.cloudui.annotations.ScreenShotOnFail;
import com.vertexinc.returns.test.cloudui.annotations.UseDriver;
import com.vertexinc.returns.test.cloudui.util.Browsers;
import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import com.vertexinc.returns.test.cloudui.util.Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.openqa.selenium.WebDriver;


/**
 * This framework aims to reduce future testing labor as tests (class UseCaseTest) implement behaviours of pre-defined pages.
 * The Test Suite is effective when calling upon the 'actions' of pre-defined web/site pages. AIM: Bridges gap between engineers.
 * This use case draws upon the behaviour of the PageInterface.
 * The Page consumes a DriverHandler, who consumes a WebDriver.
 * This architecture aims to alleviate `mistakes` in testing, by enforcing strict type requirements and implicit waiting.
 **/

//    Test that Framework can open webpage. The demo webpage will be Vertex Corporate home page.
@DisplayName("Load-Page Test Suite")
public class LoadPage_DemoSuite {

//    @RegisterExtension
//    SeleniumJupiter seleniumJupiter = new SeleniumJupiter();
//
//    @BeforeEach
//        //@ScreenShotOnFail(outputDir="",outputFileType="") //@ScreenShot(always=true,outputDir="",outputFileType="")
//    void setupScreenShotRules() {
//        seleniumJupiter.getConfig().setManager(Browsers.FIREFOX.getWebDriverManagerSupplier().get());
//        seleniumJupiter.getConfig().enableScreenshotWhenFailure();
//        seleniumJupiter.getConfig().setScreenshotFormat("png");
//        seleniumJupiter.getConfig().setOutputFolder("src/main/resources");
//    }

//    @ParameterizedTest(name = "Executing Test: {displayName} with {arguments}")
//    @ArgumentsSource(DriverProvider.class)
//    @Test
    @ScreenShotOnFail
    @UseDriver(browser = {Browsers.FIREFOX})
    public void Test_LoadCorporateWebPage(WebDriver driver) {
        //Given:
        String expectedURL = "https://www.vertexinc.com/";
        Page page = new Page(new DriverHandler(driver));
        //When:
        page.navigateTo(expectedURL);
        //Then:
        String actualURL = page.getCurrentURL();
        Assertions.assertEquals(expectedURL, actualURL);
    }
}