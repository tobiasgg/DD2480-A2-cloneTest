import crimson.JobRunner;
import karmosin.ContinuousIntegrationJob;

import java.net.URL;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ContinuousIntegrationJobRunnerTest {

    /**
     * A test case where a repo should be successfully cloned
     */
    @Test
    public void validClone() throws InvalidRemoteException, TransportException, GitAPIException, Exception {
        JobRunner jobRunner = new JobRunner();
        ContinuousIntegrationJob continuousIntegrationJob = new ContinuousIntegrationJob();
        String urlString = "www.github.com/something";
        continuousIntegrationJob.repoGitUrl = new URL(urlString);
        continuousIntegrationJob.gitRefs = "refs/head/main";
        String targetLocation = "/cloneValidTest";
        jobRunner.cloneRepo(continuousIntegrationJob, targetLocation);
        // TODO: add assertion
    }
    /**
     * A test case where a repo should be unsuccessfully cloned
     */
    @Test
    public void invalidClone() throws InvalidRemoteException, TransportException, GitAPIException, Exception {
        JobRunner jobRunner = new JobRunner();
        ContinuousIntegrationJob continuousIntegrationJob = new ContinuousIntegrationJob();
        String urlString = "www.github.com/something";
        continuousIntegrationJob.repoGitUrl = new URL(urlString);
        continuousIntegrationJob.gitRefs = "refs/head/main";
        String targetLocation = "/cloneInvalidTest";
        assertThrows(AssertionError.class, () -> jobRunner.cloneRepo(continuousIntegrationJob, targetLocation));
    }

    /**
     * A test case where a repo should be successfully cloned and "gradle check" should succeed
     */
    @Test
    public void validCheck() throws InvalidRemoteException, TransportException, GitAPIException, Exception {
        JobRunner jobRunner = new JobRunner();
        ContinuousIntegrationJob continuousIntegrationJob = new ContinuousIntegrationJob();
        String urlString = "www.github.com/something";
        continuousIntegrationJob.repoGitUrl = new URL(urlString);
        continuousIntegrationJob.gitRefs = "refs/head/main";
        String targetLocation = "/checkValidTest";
        jobRunner.cloneRepo(continuousIntegrationJob, targetLocation);
        jobRunner.runCheck(continuousIntegrationJob, targetLocation);
        assertTrue(continuousIntegrationJob.succeeded);

    }

    /**
     * A test case where a repo should be successfully cloned and "gradle check" should fail
     */
    @Test
    public void invalidCheck() throws InvalidRemoteException, TransportException, GitAPIException, Exception {
        JobRunner jobRunner = new JobRunner();
        ContinuousIntegrationJob continuousIntegrationJob = new ContinuousIntegrationJob();
        String urlString = "www.github.com/something";
        continuousIntegrationJob.repoGitUrl = new URL(urlString);
        continuousIntegrationJob.gitRefs = "refs/head/main";
        String targetLocation = "/checkInvalidTest";
        jobRunner.cloneRepo(continuousIntegrationJob, targetLocation);
        jobRunner.runCheck(continuousIntegrationJob, targetLocation);
        assertFalse(continuousIntegrationJob.succeeded);

    }

    /**
     * A test case where a repo should be successfully cloned and "gradle build" should succeed
     */
    @Test
    public void validBuild() throws InvalidRemoteException, TransportException, GitAPIException, Exception {
        JobRunner jobRunner = new JobRunner();
        ContinuousIntegrationJob continuousIntegrationJob = new ContinuousIntegrationJob();
        String urlString = "www.github.com/something";
        continuousIntegrationJob.repoGitUrl = new URL(urlString);
        continuousIntegrationJob.gitRefs = "refs/head/main";
        String targetLocation = "/buildValidTest";
        jobRunner.cloneRepo(continuousIntegrationJob, targetLocation);
        jobRunner.runBuild(continuousIntegrationJob, targetLocation);
        assertTrue(continuousIntegrationJob.succeeded);

    }

    /**
     * A test case where a repo should be successfully cloned and "gradle build" should fail
     */
    @Test
    public void invalidBuild() throws InvalidRemoteException, TransportException, GitAPIException, Exception {
        JobRunner jobRunner = new JobRunner();
        ContinuousIntegrationJob continuousIntegrationJob = new ContinuousIntegrationJob();
        String urlString = "www.github.com/something";
        continuousIntegrationJob.repoGitUrl = new URL(urlString);
        continuousIntegrationJob.gitRefs = "refs/head/main";
        String targetLocation = "/buildInvalidTest";
        jobRunner.cloneRepo(continuousIntegrationJob, targetLocation);
        jobRunner.runBuild(continuousIntegrationJob, targetLocation);
        assertFalse(continuousIntegrationJob.succeeded);
    }

    /**
     * A test case where a repo should be successfully cloned and "gradle test" should succeed
     */
    @Test
    public void validTest() throws InvalidRemoteException, TransportException, GitAPIException, Exception {
        JobRunner jobRunner = new JobRunner();
        ContinuousIntegrationJob continuousIntegrationJob = new ContinuousIntegrationJob();
        String urlString = "www.github.com/something";
        continuousIntegrationJob.repoGitUrl = new URL(urlString);
        continuousIntegrationJob.gitRefs = "refs/head/main";
        String targetLocation = "/testValidTest";
        jobRunner.cloneRepo(continuousIntegrationJob, targetLocation);
        jobRunner.runTest(continuousIntegrationJob, targetLocation);
        assertTrue(continuousIntegrationJob.succeeded);

    }

    /**
     * A test case where a repo should be successfully cloned and "gradle test" should fail
     */
    @Test
    public void invalidTest() throws InvalidRemoteException, TransportException, GitAPIException, Exception {
        JobRunner jobRunner = new JobRunner();
        ContinuousIntegrationJob continuousIntegrationJob = new ContinuousIntegrationJob();
        String urlString = "www.github.com/something";
        continuousIntegrationJob.repoGitUrl = new URL(urlString);
        continuousIntegrationJob.gitRefs = "refs/head/main";
        String targetLocation = "/testInvalidTest";
        jobRunner.cloneRepo(continuousIntegrationJob, targetLocation);
        jobRunner.runTest(continuousIntegrationJob, targetLocation);
        assertFalse(continuousIntegrationJob.succeeded);
    }


}
