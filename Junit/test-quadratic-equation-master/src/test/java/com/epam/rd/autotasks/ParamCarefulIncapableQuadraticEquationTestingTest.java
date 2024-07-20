package com.epam.rd.autotasks;

import com.epam.rd.autotasks.paramcareful.incapable.ParamCarefulIncapableQuadraticEquationNoRootsCasesTesting;
import com.epam.rd.autotasks.paramcareful.incapable.ParamCarefulIncapableQuadraticEquationSingleRootCasesTesting;
import com.epam.rd.autotasks.paramcareful.incapable.ParamCarefulIncapableQuadraticEquationTwoRootsCasesTesting;
import com.epam.rd.autotasks.paramcareful.incapable.ParamCarefulIncapableQuadraticEquationZeroACasesTesting;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

public class ParamCarefulIncapableQuadraticEquationTestingTest {


    @Test
    public void testParamCarefulIncapableQuadraticEquationNoRootsCasesTesting() {
        Launcher launcher = LauncherFactory.create();
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        LauncherDiscoveryRequest launcherDiscoveryRequest =
                LauncherDiscoveryRequestBuilder.request()
                        .selectors(selectClass(ParamCarefulIncapableQuadraticEquationNoRootsCasesTesting.class))
                        .build();
        launcher.execute(launcherDiscoveryRequest, listener);
        TestExecutionSummary summary = listener.getSummary();
        Assertions.assertEquals(0, summary.getTestsFailedCount());
        Assertions.assertTrue(summary.getTestsFoundCount() >= 4,
                "There must be at least 4 cases for parametrized tests");
    }

    @Test
    public void testParamCarefulIncapableQuadraticEquationSingleRootCasesTesting() {
        Launcher launcher = LauncherFactory.create();
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        LauncherDiscoveryRequest launcherDiscoveryRequest =
                LauncherDiscoveryRequestBuilder.request()
                        .selectors(selectClass(ParamCarefulIncapableQuadraticEquationSingleRootCasesTesting.class))
                        .build();
        launcher.execute(launcherDiscoveryRequest, listener);
        TestExecutionSummary summary = listener.getSummary();
        Assertions.assertTrue(summary.getTestsFoundCount() >= 4,
                "There must be at least 4 cases for parametrized tests");
        Assertions.assertEquals(summary.getTestsFoundCount(), summary.getTestsFailedCount(),
                "All the cases must fail on this implementation");
        for (TestExecutionSummary.Failure failure : summary.getFailures()) {
            assertThat(failure.getException(), instanceOf(AssertionError.class));
        }
    }

    @Test
    public void testParamCarefulIncapableQuadraticEquationTwoRootsCasesTesting() {
        Launcher launcher = LauncherFactory.create();
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        LauncherDiscoveryRequest launcherDiscoveryRequest =
                LauncherDiscoveryRequestBuilder.request()
                        .selectors(selectClass(ParamCarefulIncapableQuadraticEquationTwoRootsCasesTesting.class))
                        .build();
        launcher.execute(launcherDiscoveryRequest, listener);
        TestExecutionSummary summary = listener.getSummary();
        Assertions.assertTrue(summary.getTestsFoundCount() >= 4,
                "There must be at least 4 cases for parametrized tests");
        Assertions.assertEquals(summary.getTestsFoundCount(), summary.getTestsFailedCount(),
                "All the cases must fail on this implementation");
        for (TestExecutionSummary.Failure failure : summary.getFailures()) {
            assertThat(failure.getException(), instanceOf(AssertionError.class));
        }
    }

    @Test
    public void testParamCarefulIncapableQuadraticEquationZeroACasesTesting() {
        Launcher launcher = LauncherFactory.create();
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        LauncherDiscoveryRequest launcherDiscoveryRequest =
                LauncherDiscoveryRequestBuilder.request()
                        .selectors(selectClass(ParamCarefulIncapableQuadraticEquationZeroACasesTesting.class)).build();
        launcher.execute(launcherDiscoveryRequest, listener);
        TestExecutionSummary summary = listener.getSummary();
        Assertions.assertTrue(summary.getTestsFoundCount() >= 4,
                "There must be at least 4 cases for parametrized tests");
        Assertions.assertEquals(0, summary.getTestsFailedCount());
    }
}
