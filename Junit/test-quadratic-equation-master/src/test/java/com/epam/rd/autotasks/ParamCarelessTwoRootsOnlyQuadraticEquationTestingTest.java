package com.epam.rd.autotasks;

import com.epam.rd.autotasks.paramcareless.tworootsonly.ParamCarelessTwoRootsOnlyQuadraticEquationNoRootsCasesTesting;
import com.epam.rd.autotasks.paramcareless.tworootsonly.ParamCarelessTwoRootsOnlyQuadraticEquationSingleRootCasesTesting;
import com.epam.rd.autotasks.paramcareless.tworootsonly.ParamCarelessTwoRootsOnlyQuadraticEquationTwoRootsCasesTesting;
import com.epam.rd.autotasks.paramcareless.tworootsonly.ParamCarelessTwoRootsOnlyQuadraticEquationZeroACasesTesting;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;


public class ParamCarelessTwoRootsOnlyQuadraticEquationTestingTest extends QuadraticEquation {


    @Test
    public void testParamCarelessTwoRootsOnlyQuadraticEquationNoRootsCasesTesting() {
        Launcher launcher = LauncherFactory.create();
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        LauncherDiscoveryRequest launcherDiscoveryRequest =
                LauncherDiscoveryRequestBuilder.request()
                        .selectors(selectClass(
                                ParamCarelessTwoRootsOnlyQuadraticEquationNoRootsCasesTesting.class))
                        .build();
        launcher.execute(launcherDiscoveryRequest, listener);
        TestExecutionSummary summary = listener.getSummary();
        Assertions.assertTrue(summary.getTestsFoundCount() >= 4,
                "There must be at least 4 cases for parametrized tests");
        Assertions.assertEquals(summary.getTestsFoundCount(), summary.getTestsFailedCount(),
                "All the cases must fail on this implementation");
        for (TestExecutionSummary.Failure failure : summary.getFailures()) {
            assertThat(failure.getException(), Matchers.instanceOf(AssertionError.class));
        }
    }

    @Test
    public void testParamCarelessTwoRootsOnlyQuadraticEquationSingleRootCasesTesting() {
        Launcher launcher = LauncherFactory.create();
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        LauncherDiscoveryRequest launcherDiscoveryRequest =
                LauncherDiscoveryRequestBuilder.request()
                        .selectors(selectClass(
                                ParamCarelessTwoRootsOnlyQuadraticEquationSingleRootCasesTesting.class))
                        .build();
        launcher.execute(launcherDiscoveryRequest, listener);
        TestExecutionSummary summary = listener.getSummary();
        Assertions.assertTrue(summary.getTestsFoundCount() >= 4,
                "There must be at least 4 cases for parametrized tests");
        Assertions.assertEquals(summary.getTestsFoundCount(), summary.getTestsFailedCount(),
                "All the cases must fail on this implementation");
        for (TestExecutionSummary.Failure failure : summary.getFailures()) {
            assertThat(failure.getException(), Matchers.instanceOf(AssertionError.class));
        }
    }

    @Test
    public void testParamCarelessTwoRootsOnlyQuadraticEquationTwoRootsCasesTesting() {
        Launcher launcher = LauncherFactory.create();
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        LauncherDiscoveryRequest launcherDiscoveryRequest =
                LauncherDiscoveryRequestBuilder.request()
                        .selectors(selectClass(
                                ParamCarelessTwoRootsOnlyQuadraticEquationTwoRootsCasesTesting.class))
                        .build();
        launcher.execute(launcherDiscoveryRequest, listener);
        TestExecutionSummary summary = listener.getSummary();
        Assertions.assertTrue(summary.getTestsFoundCount() >= 4,
                "There must be at least 4 cases for parametrized tests");
        Assertions.assertEquals(0, summary.getTestsFailedCount());
    }

    @Test
    public void testParamCarelessTwoRootsOnlyQuadraticEquationZeroACasesTesting() {
        Launcher launcher = LauncherFactory.create();
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        LauncherDiscoveryRequest launcherDiscoveryRequest =
                LauncherDiscoveryRequestBuilder.request()
                        .selectors(selectClass(
                                ParamCarelessTwoRootsOnlyQuadraticEquationZeroACasesTesting.class))
                        .build();
        launcher.execute(launcherDiscoveryRequest, listener);
        TestExecutionSummary summary = listener.getSummary();
        Assertions.assertTrue(summary.getTestsFoundCount() >= 4,
                "There must be at least 4 cases for parametrized tests");
        Assertions.assertEquals(summary.getTestsFoundCount(), summary.getTestsFailedCount(),
                "All the cases must fail on this implementation");
        for (TestExecutionSummary.Failure failure : summary.getFailures()) {
            assertThat(failure.getException(), Matchers.instanceOf(AssertionError.class));
        }
    }

}
