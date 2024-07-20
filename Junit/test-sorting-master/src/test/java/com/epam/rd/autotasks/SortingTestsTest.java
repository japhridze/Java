package com.epam.rd.autotasks;

import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.descriptor.MethodSource;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

public class SortingTestsTest {

    @Test
    public void testDefaultSorting() {
        Launcher launcher = LauncherFactory.create();
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        LauncherDiscoveryRequest launcherDiscoveryRequest =
                LauncherDiscoveryRequestBuilder.request()
                        .selectors(selectClass(
                                SortingTest.class))
                        .build();
        launcher.execute(launcherDiscoveryRequest, listener);
        TestExecutionSummary summary = listener.getSummary();
        assertEquals(0, summary.getTestsFailedCount());
        assertEquals(5, summary.getTestsStartedCount());
    }

    @Test
    public void testLazySorting() {
        Launcher launcher = LauncherFactory.create();
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        LauncherDiscoveryRequest launcherDiscoveryRequest =
                LauncherDiscoveryRequestBuilder.request()
                        .selectors(selectClass(
                                LazySortingTestExtension.class))
                        .build();
        launcher.execute(launcherDiscoveryRequest, listener);
        TestExecutionSummary summary = listener.getSummary();
        assertEquals(2, summary.getTestsFailedCount());
        assertEquals(5, summary.getTestsStartedCount());


        TestExecutionSummary.Failure nullCaseFailure = null;
        TestExecutionSummary.Failure otherCasesFailure = null;
        for (TestExecutionSummary.Failure failure : summary.getFailures()) {
            MethodSource methodSource = (MethodSource) failure.getTestIdentifier().getSource().get();
            if ("com.epam.rd.autotasks.LazySortingTestExtension".equals(methodSource.getClassName()) &&
                    "testNullCase".equals(methodSource.getMethodName())) {
                nullCaseFailure = failure;
            }
            if ("com.epam.rd.autotasks.LazySortingTestExtension".equals(methodSource.getClassName()) &&
                    "testOtherCases".equals(methodSource.getMethodName())) {
                otherCasesFailure = failure;
            }
        }

        assertNotNull(nullCaseFailure);
        assertNotNull(otherCasesFailure);

        assertThat(nullCaseFailure.getException(), instanceOf(AssertionError.class));
        assertThat(otherCasesFailure.getException(), instanceOf(AssertionError.class));
    }

    @Test
    public void testNullCarelessSorting() {
        Launcher launcher = LauncherFactory.create();
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        LauncherDiscoveryRequest launcherDiscoveryRequest =
                LauncherDiscoveryRequestBuilder.request()
                        .selectors(selectClass(
                                NullCarelessSortingTestExtension.class))
                        .build();
        launcher.execute(launcherDiscoveryRequest, listener);
        TestExecutionSummary summary = listener.getSummary();
        assertEquals(1, summary.getTestsFailedCount());
        assertEquals(5, summary.getTestsStartedCount());


        TestExecutionSummary.Failure nullCaseFailure = null;
        for (TestExecutionSummary.Failure failure : summary.getFailures()) {
            MethodSource methodSource = (MethodSource) failure.getTestIdentifier().getSource().get();
            if ("com.epam.rd.autotasks.NullCarelessSortingTestExtension".equals(methodSource.getClassName()) &&
                    "testNullCase".equals(methodSource.getMethodName())) {
                nullCaseFailure = failure;
            }
        }
        assertNotNull(nullCaseFailure);
        assertThat(nullCaseFailure.getException(), instanceOf(Throwable.class));
        assertTrue(nullCaseFailure.getException().getMessage().startsWith("Unexpected exception"));
    }

    @Test
    public void testTrickySorting() {
        Launcher launcher = LauncherFactory.create();
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        LauncherDiscoveryRequest launcherDiscoveryRequest =
                LauncherDiscoveryRequestBuilder.request()
                        .selectors(selectClass(
                                TrickySortingTestExtension.class))
                        .build();
        launcher.execute(launcherDiscoveryRequest, listener);
        TestExecutionSummary summary = listener.getSummary();
        assertEquals(4, summary.getTestsFailedCount());
        assertEquals(5, summary.getTestsStartedCount());


        TestExecutionSummary.Failure emptyCaseFailure = null;
        TestExecutionSummary.Failure singleCaseFailure = null;
        TestExecutionSummary.Failure sortedCaseFailure = null;
        TestExecutionSummary.Failure otherCasesFailure = null;
        for (TestExecutionSummary.Failure failure : summary.getFailures()) {
            MethodSource methodSource = (MethodSource) failure.getTestIdentifier().getSource().get();
            if ("com.epam.rd.autotasks.TrickySortingTestExtension".equals(methodSource.getClassName()) &&
                    "testSingleElementArrayCase".equals(methodSource.getMethodName())) {
                singleCaseFailure = failure;
            }
            if ("com.epam.rd.autotasks.TrickySortingTestExtension".equals(methodSource.getClassName()) &&
                    "testOtherCases".equals(methodSource.getMethodName())) {
                otherCasesFailure = failure;
            }
            if ("com.epam.rd.autotasks.TrickySortingTestExtension".equals(methodSource.getClassName()) &&
                    "testSortedArraysCase".equals(methodSource.getMethodName())) {
                sortedCaseFailure = failure;
            }
            if ("com.epam.rd.autotasks.TrickySortingTestExtension".equals(methodSource.getClassName()) &&
                    "testEmptyCase".equals(methodSource.getMethodName())) {
                emptyCaseFailure = failure;
            }
        }

        assertNotNull(emptyCaseFailure);
        assertNotNull(singleCaseFailure);
        assertNotNull(sortedCaseFailure);
        assertNotNull(otherCasesFailure);

        assertThat(emptyCaseFailure.getException(), instanceOf(ArrayIndexOutOfBoundsException.class));
        assertThat(singleCaseFailure.getException(), instanceOf(AssertionError.class));
        assertThat(sortedCaseFailure.getException(), instanceOf(AssertionError.class));
        assertThat(otherCasesFailure.getException(), instanceOf(AssertionError.class));
    }

}