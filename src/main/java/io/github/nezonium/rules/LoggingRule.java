package io.github.nezonium.rules;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import java.util.logging.Logger;

@Deprecated
@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class LoggingRule {
    private static final Logger logger = Logger.getLogger(LoggingRule.class.getName());

    @BeforeAll
    void beforeAllTests() {
        logger.info("Preparing testing environment");
    }

    @AfterAll
    void afterAllTest(){
        logger.info("All test have been executed!");
    }
}
