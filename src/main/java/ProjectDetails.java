import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.QueryStage;
import com.google.cloud.resourcemanager.ResourceManager;
import com.google.cloud.resourcemanager.ResourceManagerOptions;
import com.google.cloud.resourcemanager.Project;
import com.google.cloud.bigquery.QueryStage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static com.google.common.base.MoreObjects.firstNonNull;

public class ProjectDetails {
    public static void main(String args[]) throws Exception {

        // this credentials path will be your project service account one
        String credentialsPath = "src/main/resources/unravel-test-337406-6379ab83d333.json";
        /**
        ResourceManager resourceManager = ResourceManagerOptions.newBuilder().setProjectId("unravel-test-337406").
                setCredentials(GoogleCredentials.fromStream(new FileInputStream(credentialsPath))).build().getService();
        String projectId = resourceManager.getOptions().getProjectId();
        System.out.println(projectId);
                System.out.println(project.getName() + "\n" + project.getProjectNumber());
        System.out.println(new Date(project.getCreateTimeMillis()).toString());
        Project project = resourceManager.get(projectId);
        System.out.println(project.getName() + "\n" + project.getProjectNumber());
        project.getCreateTimeMillis();
         **/
        JobMetrics jobMetrics = new JobMetrics();
        Job job = jobMetrics.getJobMetrics();
        com.google.cloud.bigquery.JobStatistics.QueryStatistics statistics = job.getStatistics();
        System.out.println(statistics);
        List<QueryStage> queryPlan = firstNonNull(statistics.getQueryPlan(), Collections.emptyList());
        System.out.println(queryPlan);



    }

}
