package com.epam.rd.autotasks;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

public class DefaultQuadraticEquationTestingTest {

    @Test
    public void testClassesAreParameterized() throws NoSuchMethodException {
        final List<Class<?>> testingClasses = Arrays.asList(
                QuadraticEquationNoRootsCasesTesting.class,
                QuadraticEquationSingleRootCasesTesting.class,
                QuadraticEquationTwoRootsCasesTesting.class,
                QuadraticEquationZeroACasesTesting.class
        );
        for (Class<?> testingClass : testingClasses) {
            Method testMethod = Arrays.stream(testingClass.getMethods())
                    .filter(method -> "testCase".equals(method.getName()))
                    .findFirst()
                    .orElseThrow(() -> new AssertionError(
                            "There is no method 'testCase' in class " + testingClass.getSimpleName()));
            ParameterizedTest parameterizedTest = testMethod.getAnnotation(ParameterizedTest.class);
            assertNotNull(parameterizedTest);
        }
    }

    @Test
    public void testQuadraticEquationNoRootsCasesTesting() {
        Launcher launcher = LauncherFactory.create();
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        LauncherDiscoveryRequest launcherDiscoveryRequest =
                LauncherDiscoveryRequestBuilder.request()
                        .selectors(selectClass(QuadraticEquationNoRootsCasesTesting.class)).build();
        launcher.execute(launcherDiscoveryRequest, listener);
        TestExecutionSummary summary = listener.getSummary();
        assertEquals(0, summary.getTestsFailedCount());
        assertTrue(summary.getTestsFoundCount() >= 4, "There must be at least 4 cases for parametrized tests");
    }

    @Test
    public void testQuadraticEquationSingleRootCasesTesting() {
        Launcher launcher = LauncherFactory.create();
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        LauncherDiscoveryRequest launcherDiscoveryRequest =
                LauncherDiscoveryRequestBuilder.request()
                        .selectors(selectClass(QuadraticEquationSingleRootCasesTesting.class)).build();
        launcher.execute(launcherDiscoveryRequest, listener);
        TestExecutionSummary summary = listener.getSummary();
        assertEquals(0, summary.getTestsFailedCount());
        assertTrue(summary.getTestsFoundCount() >= 4, "There must be at least 4 cases for parametrized tests");
    }

    @Test
    public void testQuadraticEquationTwoRootsCasesTesting() {
        Launcher launcher = LauncherFactory.create();
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        LauncherDiscoveryRequest launcherDiscoveryRequest =
                LauncherDiscoveryRequestBuilder.request()
                        .selectors(selectClass(QuadraticEquationTwoRootsCasesTesting.class)).build();
        launcher.execute(launcherDiscoveryRequest, listener);
        TestExecutionSummary summary = listener.getSummary();
        assertEquals(0, summary.getTestsFailedCount());
        assertTrue(summary.getTestsFoundCount() >= 4, "There must be at least 4 cases for parametrized tests");
    }

    @Test
    public void testQuadraticEquationZeroACasesTesting() {
        Launcher launcher = LauncherFactory.create();
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        LauncherDiscoveryRequest launcherDiscoveryRequest =
                LauncherDiscoveryRequestBuilder.request()
                        .selectors(selectClass(QuadraticEquationZeroACasesTesting.class)).build();
        launcher.execute(launcherDiscoveryRequest, listener);
        TestExecutionSummary summary = listener.getSummary();
        assertEquals(0, summary.getTestsFailedCount());
        assertTrue(summary.getTestsFoundCount() >= 4, "There must be at least 4 cases for parametrized tests");
    }

}
