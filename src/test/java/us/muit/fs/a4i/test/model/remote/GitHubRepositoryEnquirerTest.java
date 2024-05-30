package us.muit.fs.a4i.test.model.remote;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import us.muit.fs.a4i.exceptions.MetricException;
import us.muit.fs.a4i.model.entities.ReportItemI;
import us.muit.fs.a4i.model.remote.GitHubRepositoryEnquirer;

public class GitHubRepositoryEnquirerTest {
    // MARK: Attributes 
    private static GitHubRepositoryEnquirer gitHubRepositoryEnquirer;
    private static String repositoryID = "MIT-FS/Audit4Improve-API";

    // MARK: Setup
    /**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
        gitHubRepositoryEnquirer = new GitHubRepositoryEnquirer();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

    // MARK: Test helper methods
    @SuppressWarnings("rawtypes")
    ReportItemI testGetMetric(String metricString) {
        ReportItemI reportItem;
        try {
            reportItem = gitHubRepositoryEnquirer.getMetric(metricString, repositoryID);
        } catch (MetricException e) {
            e.printStackTrace();
            fail("Exception thrown while getting conventional commits: " + e.getMessage());
            return null;
        }

        assertNotNull(reportItem, "Getting the metric (" + metricString + ") failed: reportItem is null");
        return reportItem;
    }

    // MARK: Tests
    @Test
    @DisplayName("Test getConventionalCommits")
    @SuppressWarnings("rawtypes")
    void testGetConventionalCommits() {
        ReportItemI reportItem = testGetMetric("conventionalCommits");
        assertNotNull(reportItem, "Getting conventional commits failed: reportItem is null");
        assertNotNull(reportItem.getValue(), "Getting conventional commits failed: value is null");
        // Check that the value is a number between 0 and 1
        double value = (double) reportItem.getValue();
        assertTrue(value >= 0 && value <= 1, "Getting conventional commits failed: value is not between 0 and 1");
    }

    @Test
    @DisplayName("Test issuesWithLabels")
    @SuppressWarnings("rawtypes")
    void testGetIssuesWithLabels() {
        ReportItemI reportItem = testGetMetric("issuesWithLabels");
        assertNotNull(reportItem, "Getting issues with labels failed: reportItem is null");
        assertNotNull(reportItem.getValue(), "Getting issues with labels failed: value is null");
        // Check that the value is a number between 0 and 1
        double value = (double) reportItem.getValue();
        assertTrue(value >= 0 && value <= 1, "Getting issues with labels failed: value is not between 0 and 1");
    }

    @Test
    @DisplayName("Test gitFlowBranches")
    @SuppressWarnings("rawtypes")
    void testGetGitFlowBranches() {
        ReportItemI reportItem = testGetMetric("gitFlowBranches");
        assertNotNull(reportItem, "Getting git flow branches failed: reportItem is null");
        assertNotNull(reportItem.getValue(), "Getting git flow branches failed: value is null");
        // Check that the value is a number between 0 and 1
        double value = (double) reportItem.getValue();
        assertTrue(value >= 0 && value <= 1, "Getting git flow branches failed: value is not between 0 and 1");
    }

    @Test
    @DisplayName("Test commitsWithDescription")
    @SuppressWarnings("rawtypes")
    void testGetCommits() {
        ReportItemI reportItem = testGetMetric("commitsWithDescription");
        assertNotNull(reportItem, "Getting commits with description failed: reportItem is null");
        assertNotNull(reportItem.getValue(), "Getting commits with description failed: value is null");
        // Check that the value is a number between 0 and 1
        double value = (double) reportItem.getValue();
        assertTrue(value >= 0 && value <= 1, "Getting commits with description failed: value is not between 0 and 1");
    }

    @Test
    @DisplayName("Test conventionalPullRequests")
    @SuppressWarnings("rawtypes")
    void testGetRepository() {
        ReportItemI reportItem = testGetMetric("commitsWithDescription");
        assertNotNull(reportItem, "Getting repository failed: reportItem is null");
        assertNotNull(reportItem.getValue(), "Getting repository failed: value is null");
        // Check that the value is a number between 0 and 1
        double value = (double) reportItem.getValue();
        assertTrue(value >= 0 && value <= 1, "Getting repository failed: value is not between 0 and 1");
    }
}
