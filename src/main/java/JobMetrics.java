import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobId;
import com.google.cloud.resourcemanager.v3.Project;
import com.google.cloud.resourcemanager.v3.ProjectName;
import com.google.cloud.resourcemanager.v3.ProjectsClient;
import com.google.cloud.bigquery.BigQuery;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.google.cloud.bigquery.BigQueryOptions;

public class JobMetrics {

    public Job getJobMetrics() throws Exception {
        String projectId = "unravel-test-337406"; // Give your projectId
        String location = "US";
        // job Id should be replaced with your job
        Job job =  getBigQuery(projectId, location).getJob(JobId.newBuilder().setJob("bquxjob_4f17b6aa_17eba0af9fa").
                setLocation(location).setProject(projectId).build());
//        try {
//            FileOutputStream fileOut =
//                    new FileOutputStream("./Job.ser");
//            ObjectOutputStream out = new ObjectOutputStream(fileOut);
//            out.writeObject(job);
//            out.close();
//            fileOut.close();
//        } catch (IOException i) {
//            i.printStackTrace();
//        }
        return job;
    }


    private BigQuery getBigQuery(String projectId, String location) throws IOException {
        // path to your credentials file
        String credentialsPath = "src/main/resources/unravel-test-337406-6379ab83d333.json";
        BigQuery bigQuery;

        bigQuery = BigQueryOptions.newBuilder().setProjectId(projectId).setLocation(location)
                .setCredentials(GoogleCredentials.fromStream(new FileInputStream(credentialsPath))).build()
                .getService();
        return bigQuery;
    }
}


