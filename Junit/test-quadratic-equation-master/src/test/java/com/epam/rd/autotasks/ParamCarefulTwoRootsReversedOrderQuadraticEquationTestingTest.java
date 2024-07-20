package com.epam.rd.autotasks;

import com.epam.rd.autotasks.paramcareful.tworootsreversed.ParamCarefulTwoRootsReversedOrderQuadraticEquationNoRootsCasesTesting;
import com.epam.rd.autotasks.paramcareful.tworootsreversed.ParamCarefulTwoRootsReversedOrderQuadraticEquationSingleRootCasesTesting;
import com.epam.rd.autotasks.paramcareful.tworootsreversed.ParamCarefulTwoRootsReversedOrderQuadraticEquationTwoRootsCasesTesting;
import com.epam.rd.autotasks.paramcareful.tworootsreversed.ParamCarefulTwoRootsReversedOrderQuadraticEquationZeroACasesTesting;
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


public class ParamCarefulTwoRootsReversedOrderQuadraticEquationTestingTest {


    @Test
    public void testParamCarefulTwoRootsReversedOrderQuadraticEquationNoRootsCasesTesting() {
        Launcher launcher = LauncherFactory.create();
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        LauncherDiscoveryRequest launcherDiscoveryRequest =
                LauncherDiscoveryRequestBuilder.request()
                        .selectors(selectClass(
                                ParamCarefulTwoRootsReversedOrderQuadraticEquationNoRootsCasesTesting.class))
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
    public void testParamCarefulTwoRootsReversedOrderQuadraticEquationSingleRootCasesTesting() {
        Launcher launcher = LauncherFactory.create();
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        LauncherDiscoveryRequest launcherDiscoveryRequest =
                LauncherDiscoveryRequestBuilder.request()
                        .selectors(selectClass(
                                ParamCarefulTwoRootsReversedOrderQuadraticEquationSingleRootCasesTesting.class))
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
    public void testParamCarefulTwoRootsReversedOrderQuadraticEquationTwoRootsCasesTesting() {
        Launcher launcher = LauncherFactory.create();
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        LauncherDiscoveryRequest launcherDiscoveryRequest =
                LauncherDiscoveryRequestBuilder.request()
                        .selectors(selectClass(
                                ParamCarefulTwoRootsReversedOrderQuadraticEquationTwoRootsCasesTesting.class)).build();
        launcher.execute(launcherDiscoveryRequest, listener);
        TestExecutionSummary summary = listener.getSummary();
        Assertions.assertTrue(summary.getTestsFoundCount() >= 4,
                "There must be at least 4 cases for parametrized tests");
        Assertions.assertEquals(0, summary.getTestsFailedCount());
    }

    @Test
    public void testParamCarefulTwoRootsReversedOrderQuadraticEquationZeroACasesTesting() {
        Launcher launcher = LauncherFactory.create();
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        LauncherDiscoveryRequest launcherDiscoveryRequest =
                LauncherDiscoveryRequestBuilder.request()
                        .selectors(
                                selectClass(ParamCarefulTwoRootsReversedOrderQuadraticEquationZeroACasesTesting.class))
                        .build();
        launcher.execute(launcherDiscoveryRequest, listener);
        TestExecutionSummary summary = listener.getSummary();
        Assertions.assertTrue(summary.getTestsFoundCount() >= 4,
                "There must be at least 4 cases for parametrized tests");
        Assertions.assertEquals(0, summary.getTestsFailedCount());
    }

}
