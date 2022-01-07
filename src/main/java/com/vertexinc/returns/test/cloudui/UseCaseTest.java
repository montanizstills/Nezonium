package com.vertexinc.returns.test.cloudui;

import com.vertexinc.returns.test.cloudui.util.Browsers;
import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import com.vertexinc.returns.test.cloudui.util.Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;


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
    //Pass set of rules to each test.
    //Unpack rule chain or dynamic test?
    //Chrome is a test class?
//    @Browser(webdriver=Browsers.CHROME)
    @ParameterizedTest
    @EnumSource(value = Browsers.class, mode = EnumSource.Mode.EXCLUDE, names = {"SAFARI", "OPERA", "INTERNET_EXPLORER"})
    public void Test_LoadCorporateWebPage(Browsers browser) {
        //Given:
        String expectedURL = "https://www.vertexinc.com/";
        Page page = new Page(new DriverHandler(browser));
        //When:
        page.navigateTo(expectedURL);
        //Then:
        String actualURL = page.getCurrentURL();
        Assertions.assertEquals(expectedURL, actualURL);
    }

//    @RegisterExtension
//    ScreenShotOnFailRule screenShotOnFailRule = new ScreenShotOnFailRule("src/main/resources/chrome", driverHandler = new DriverHandler(Browsers.CHROME));
//
//    @RegisterExtension

//    LoggingRule LoggingRule = new LoggingRule();



//
//    @Nested
//    @DisplayName("Test Chrome Suite")
//    class TestChrome {
//
//        @Test
//        public void Test_shouldPass() {
//            Assertions.assertTrue(true);
//        }
//
//        @Disabled("shouldFail(), skipped!, Expecting: AssertionError.")
//        @Test
//        public void Test_shouldFail() {
//            //Given:
//            AssertionError assertionError;
//            String assertionErrorMessage = "Assertion error thrown in Chrome Suite - Test: shouldFail()..";
//            //When:
//            assertionError = Assertions.assertThrows(AssertionError.class, Assertions::fail, assertionErrorMessage);
//            //Then:
//            Assertions.assertEquals(assertionErrorMessage, assertionError.getMessage());
//        }
//        //        @Test
//
//        @Test
//        public void Test_LoadCorporateWebPage_Then_AssertFail() {
//            //Given:
//            String expectedURL = "https://www.vertexinc.com/";
//            Page page = new Page(getDriverHandler());
//            //When:
//            page.navigateTo(expectedURL);
//            //Then:
//            //String actualURL = page.getCurrentURL();
//            Assertions.fail("Test has failed!");
//        } //^^ Test not tearing down**********
//
//        @Test
//        public void Test_LoadCorporateWebPage_Then_CompareToNullURL() {
//            //Given:
//            Page page = new Page(getDriverHandler());
//            //When:
//            page.navigateTo("https://www.vertexinc.com/");
//            //Then:
//            String actualURL = page.getCurrentURL();
//            Assertions.assertNull(actualURL);
//        }
//        private DriverHandler getDriverHandler() {
//            return this.driverHandler;
//        }
//
//        //                @AfterEach  - Update method to tear down properly after test failure
//        public void tearDown() {
//            if (getDriverHandler().getDriver() != null) {
//                System.out.println("Driver not destroyed after rule `ScreenShotOnFailRule`, destroying manually - via JUnit @After");
//                getDriverHandler().destroyDriver();
//            } else {
//                System.out.println("Driver successfully destroyed by rule.");
//            }
//        }
//
//    }//End TestChrome
//

///////////////////////////////////////////////END TEST CHROME//////////////////////////////////////////////////
//
//    @Nested
//    @DisplayName("Test Edge Suite")
//    class TestEdge {
//
//        @RegisterExtension
//        ScreenShotOnFailRule screenShotOnFailRule = new ScreenShotOnFailRule("src/main/resources/edge", driverHandler = new DriverHandler(Browsers.EDGE));
//
//        @Test
//        public void Test_shouldPass() {
//            Assertions.assertTrue(true);
//        }
//
//        @Disabled("shouldFail(), skipped!, Expecting: AssertionError.")
//        @Test
//        public void Test_shouldFail() {
//            //Given:
//            AssertionError assertionError;
//            String assertionErrorMessage = "Assertion error thrown in Edge Suite - Test: shouldFail()..";
//            //When:
//            assertionError = Assertions.assertThrows(AssertionError.class, Assertions::fail, assertionErrorMessage);
//            //Then:
//            Assertions.assertEquals(assertionErrorMessage, assertionError.getMessage());
//        }//^^Test not tearing down..
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
//        //        @AfterEach  - Update method to tear down properly after test failure
//        public void tearDown() {
//            if (getDriverHandler().getDriver() != null) {
//                System.out.println("Driver not destroyed after rule `ScreenShotOnFailRule`, destroying manually - via JUnit @After");
//                getDriverHandler().destroyDriver();
//            } else {
//                System.out.println("Driver successfully destroyed by rule.");
//            }
//        }
//
//    }//End Test Edge
//    /////////////////////////////////////////////END TEST EDGE/////////////////////////////////////////////

    public static void main(String[] args) {
    }

}//End UseCaseTest Class


