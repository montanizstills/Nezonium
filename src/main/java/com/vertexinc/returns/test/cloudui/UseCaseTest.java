package com.vertexinc.returns.test.cloudui;

import com.vertexinc.returns.test.cloudui.rules.DriverRule;
import com.vertexinc.returns.test.cloudui.rules.LoggingRule;
import com.vertexinc.returns.test.cloudui.rules.ScreenShotOnFailRule;
import com.vertexinc.returns.test.cloudui.rules.UseChromeAsDriverRule;
import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import com.vertexinc.returns.test.cloudui.util.Page;
import org.junit.After;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.*;
import org.junit.rules.RuleChain;


/**
 * This framework aims to reduce future testing labor as tests (class UseCaseTest) implement behaviours of pre-defined pages.
 * The Test Suite is effective when calling upon the 'actions' of pre-defined web/site pages. AIM: Bridges gap between engineers.
 * This use case draws upon the behaviour of the PageInterface.
 * The Page consumes a DriverHandler, who consumes a WebDriver.
 * This architecture aims to alleviate `mistakes` in testing, by enforcing strict type requirements and implicit waiting.
 **/

//    Test that Framework can open webpage. The demo webpage will be Vertex Corporate home page.
@DisplayName("Use Case Test Suite")
public class UseCaseTest {

    @Nested
    @DisplayName("Test Chrome Suite")
    class TestChrome {

        LoggingRule loggingRule = new LoggingRule();
        DriverRule useChromeAsDriverRule = new UseChromeAsDriverRule();

        @Rule
        RuleChain ruleChain = RuleChain.emptyRuleChain()
                .around(loggingRule)
                .around(useChromeAsDriverRule)
                .around(new ScreenShotOnFailRule("src/main/resources", useChromeAsDriverRule));

        private final DriverHandler driverHandler = useChromeAsDriverRule.getDriverHandler();

        @Test
        public void Test_shouldPass() {
            Assertions.assertTrue(true);
        }//^^ Test not tearing down**********

//        @Ignore("shouldFail(), skipped!, Expecting: AssertionError.")
//        @Test(expected = AssertionError.class)
//        public void Test_shouldFail() {a
//            Assertions.fail();
//        }

        @Test
        public void Test_LoadCorporateWebPage() {
            //Given:
            String expectedURL = "https://www.vertexinc.com/";
            Page page = new Page(getDriverHandler());
            //When:
            page.navigateTo(expectedURL);

            //Then:
            String actualURL = page.getCurrentURL();
            Assertions.assertEquals(expectedURL, actualURL);

        } //^^ Test not tearing down**********

        @Test
        public void Test_LoadCorporateWebPage_Then_AssertFail() {
            //Given:
            String expectedURL = "https://www.vertexinc.com/";
            Page page = new Page(getDriverHandler());
            //When:
            page.navigateTo(expectedURL);
            //Then:
            //String actualURL = page.getCurrentURL();
            Assertions.fail("Test has failed!");
        } //^^ Test not tearing down**********

        @Test
        public void Test_LoadCorporateWebPage_Then_CompareToNullURL() {
            //Given:
            String expectedURL = "https://www.vertexinc.com/";
            Page page = new Page(getDriverHandler());
            //When:
            page.navigateTo(expectedURL);
            //Then:
            String actualURL = page.getCurrentURL();
            Assertions.assertEquals(null, actualURL);
        }

        public DriverHandler getDriverHandler() {
            return this.driverHandler;
        }

        @AfterEach
        public void tearDown() {
            if (getDriverHandler().getDriver() != null) {
                System.out.println("Driver not destroyed after rule `ScreenShotOnFailRule`, destroying manually - via JUnit @After");
                getDriverHandler().destroyDriver();
            } else {
                System.out.println("Driver successfully destroyed by rule.");
            }


        }


    }//End TestChrome

///////////////////////////////////////////////END TEST CHROME//////////////////////////////////////////////////
//
//    @Nested
//    @DisplayName("Test Edge Suite")
//    class TestEdge {
//        // Order of operations:
//        //1.Specify WebDriver
//        //2. Create Rule(s) that depend on WebDriver;
//        @Rule
//        public LoggingRule loggingRule = new LoggingRule();
//
//        @Rule
//        public ScreenShotOnFailRule screenShotOnFailRule = new ScreenShotOnFailRule("src/main/resources/chrome", driverHandler = new DriverHandler(Browsers.EDGE));
//        //
//
//        @Test
//        public void Test_shouldPass() {
//            Assertions.assertTrue(true);
//        }
//
////        @Ignore("shouldFail(), skipped!, Expecting: AssertionError.")
////        @Test(expected = AssertionError.class)
////        public void Test_shouldFail() {
////            Assertions.fail();
////        }
//
//        @Test
//        public void Test_LoadCorporateWebPage() {
//            //Given:
//            String expectedURL = "https://www.vertexinc.com/";
//            Page page = new Page(getDriverHandler());
//            //When:
//            page.navigateTo(expectedURL);
//            //Then:
//            String actualURL = page.getCurrentURL();
//            Assertions.assertEquals(expectedURL, actualURL);
//        }//End Test Case
//        //^^ Test Did not tear down.
//
//        @Test
//        public void Test_LoadCorporateWebPage_Then_AssertFail() {
//            //Given:
//            String expectedURL = "https://www.vertexinc.com/";
//            Page page = new Page(getDriverHandler());
//            //When:
//            page.navigateTo(expectedURL);
//            //Then:
//            String actualURL = page.getCurrentURL();
//            Assertions.fail("Test has failed!");
//        }
//
//        @After
//        public void tearDown() {
//            if (getDriverHandler().getDriver() != null) {
//                System.out.println("Driver not destroyed after rule, destroying manually - via JUnit @After");
//                getDriverHandler().destroyDriver();
//            } else {
//                System.out.println("Driver successfully destroyed by rule.");
//            }
//        }
//
//    }//End Test Edge
//    /////////////////////////////////////////////END TEST EDGE/////////////////////////////////////////////
//

    public static void main(String[] args) {
    }

}//End UseCaseTest Class


