package com.vertexinc.returns.test.cloudui;

import com.vertexinc.returns.test.cloudui.rules.ScreenShotOnFailRule;
import com.vertexinc.returns.test.cloudui.util.Browsers;
import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import com.vertexinc.returns.test.cloudui.util.Page;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

/**
 * This framework aims to reduce future testing labor as tests (class UseCaseTest) implement behaviours of pre-defined pages.
 * The Test Suite is effective when calling upon the 'actions' of pre-defined web/site pages. AIM: Bridges gap between engineers.
 * This use case draws upon the behaviour of the PageInterface.
 * The Page consumes a DriverHandler, who consumes a WebDriver.
 * This architecture aims to alleviate `mistakes` in testing, by enforcing strict type requirements and implicit waiting.
 **/

public class UseCaseTest {

    private DriverHandler driverHandler = new DriverHandler(Browsers.EDGE);
    @Rule public ScreenShotOnFailRule screenShotOnFailRule = new ScreenShotOnFailRule("src/main/resources", getDriverHandler());
    @Rule public TestName testName = new TestName();
    @Test public void shouldPass(){Assert.assertTrue(true);}
    @Test public void shouldFail(){Assert.fail();}

//    @Test
//    public void testChrome() {
//        this.driverHandler = new DriverHandler(Browsers.CHROME);
//        Test_LoadCorporateWebPage(getDriverHandler());
//        Test_LoadCorporateWebPage_Then_Fail(getDriverHandler());
//    }
//
//    @Test
//    public  void testMSEdge(){
//        this.driverHandler=new DriverHandler(Browsers.EDGE);
//        Test_LoadCorporateWebPage_Then_Fail(getDriverHandler());
//        Test_LoadCorporateWebPage(getDriverHandler());
//    }

    private DriverHandler getDriverHandler() {
        return this.driverHandler;
    }


    //    Test that Framework can open webpage. The demo webpage will be Vertex Corporate home page.
    public void Test_LoadCorporateWebPage(DriverHandler driverHandler) {

        //Given:
        String expectedURL = "https://www.vertexinc.com/";
        Page page = new Page(driverHandler);

        //When:
        page.navigateTo(expectedURL);

        //Then:
        String actualURL = page.getCurrentURL();

        Assert.assertEquals(expectedURL, actualURL);

    }//End Test Case

    public void Test_LoadCorporateWebPage_Then_Fail(DriverHandler driverHandler) {

        //Given:
        String expectedURL = "https://www.vertexinc.com/";
        Page page = new Page(driverHandler);

        //When:
        page.navigateTo(expectedURL);

        //Then:
        String actualURL = page.getCurrentURL();

        Assert.fail("Test will fail!");
    }//End Test Case

    public static void main(String[] args) {
    }
}//End MyTestClass


