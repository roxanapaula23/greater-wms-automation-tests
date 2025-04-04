package com.greater.wms.automation.testing.tests;

import org.testng.TestNG;

public class TestNGRunner {
    public static void main(String[] args) {
        //TODO: Fix tests suite
        TestNG testNG = new TestNG();
        testNG.setTestClasses(new Class[] {
                RegisterTests.class,
                BaseInfoTests.class
        });
        testNG.run();
    }
}
