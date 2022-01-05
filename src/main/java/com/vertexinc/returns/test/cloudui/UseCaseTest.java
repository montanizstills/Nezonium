package com.vertexinc.returns.test.cloudui;

import com.vertexinc.returns.test.cloudui.rules.*;
import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import com.vertexinc.returns.test.cloudui.util.Page;
import org.junit.Rule;
import org.junit.jupiter.api.*;


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
        @Rule
        LoggingRule loggingRule = new LoggingRule();
        @Rule
        DriverRule useChromeAsDriverRule = new UseChromeAsDriverRule();
        @Rule
        ScreenShotOnFailRule screenShotOnFailRule = new ScreenShotOnFailRule("src/main/resources", useChromeAsDriverRule);

//        @Rule
//        RuleChain ruleChain = RuleChain.emptyRuleChain()
//                .around(loggingRule)
//                .around(useChromeAsDriverRule)
//                .around(new ScreenShotOnFailRule("src/main/resources", useChromeAsDriverRule));

        private final DriverHandler driverHandler = useChromeAsDriverRule.getDriverHandler();

        @Test
        public void Test_shouldPass() {
            Assertions.assertTrue(true);
        }

        @Disabled("shouldFail(), skipped!, Expecting: AssertionError.")
        @Test
        public void Test_shouldFail() {
            //Given:
            AssertionError assertionError;
            String assertionErrorMessage = "Assertion error thrown in Chrome Suite - Test: shouldFail()..";
            //When:
            assertionError = Assertions.assertThrows(AssertionError.class, Assertions::fail, assertionErrorMessage);
            //Then:
            Assertions.assertEquals(assertionErrorMessage,assertionError.getMessage());
        }

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
        }

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
            Page page = new Page(getDriverHandler());
            //When:
            page.navigateTo("https://www.vertexinc.com/");
            //Then:
            String actualURL = page.getCurrentURL();
            Assertions.assertNull(actualURL);
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

    @Nested
    @DisplayName("Test Edge Suite")
    class TestEdge {
        @Rule
        public LoggingRule loggingRule = new LoggingRule();
        @Rule
        public DriverRule useEdgeAsDriverRule = new UseEdgeAsDriverRule();
        @Rule
        public ScreenShotOnFailRule screenShotOnFailRule = new ScreenShotOnFailRule("src/main/resources/chrome", useEdgeAsDriverRule);

        private final DriverHandler driverHandler = useEdgeAsDriverRule.getDriverHandler();


        @Test
        public void Test_shouldPass() {
            Assertions.assertTrue(true);
        }

        @Disabled("shouldFail(), skipped!, Expecting: AssertionError.")
        @Test
        public void Test_shouldFail() {
            //Given:
            AssertionError assertionError;
            String assertionErrorMessage = "Assertion error thrown in Edge Suite - Test: shouldFail()..";
            //When:
            assertionError = Assertions.assertThrows(AssertionError.class, Assertions::fail, assertionErrorMessage);
            //Then:
            Assertions.assertEquals(assertionErrorMessage,assertionError.getMessage());
        }//^^Test not tearing down..

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
        }//End Test Case
        //^^ Test Did not tear down.

        @Test
        public void Test_LoadCorporateWebPage_Then_AssertFail() {
            //Given:
            String expectedURL = "https://www.vertexinc.com/";
            Page page = new Page(getDriverHandler());
            //When:
            page.navigateTo(expectedURL);
            //Then:
            String actualURL = page.getCurrentURL();
            Assertions.fail("Test has failed!");
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

    }//End Test Edge
    /////////////////////////////////////////////END TEST EDGE/////////////////////////////////////////////


    public static void main(String[] args) {
    }

}//End UseCaseTest Class


