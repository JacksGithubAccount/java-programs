import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;


public class main {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) 
	{
		File file = new File("jobs.dat");
		PriorityQueue<JobRequest> jobPool = new PriorityQueue<JobRequest>();
		Scanner scanner;
		int[] usage = {0, 0, 0, 0};
		try {
			scanner = new Scanner(file);
			while(scanner.hasNext())
			{
				jobPool.add(readJob(scanner));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(jobPool.peek() != null)
		{
			JobRequest jobRequest = jobPool.poll();
			usage[jobRequest.getJobStatusValue()] += jobRequest.getJobTime();
			System.out.println(jobRequest);			
		}
		System.out.println("\n\nUsage" + "\nPresident: " + usage[3] + "\nDirector: " + usage[2] + "\nManager: " + usage[1] + "\nClerk: " + usage[0]);

		
	}
	
	private static JobRequest readJob(Scanner scanner) 
	{
		String jobStatusString = scanner.next();
		int jobId = scanner.nextInt();
		int jobTime = scanner.nextInt();
		JobRequest jobRequest = new JobRequest(JobStatus.valueOf(jobStatusString.toUpperCase()), jobId, jobTime);
		return jobRequest;
	}

}
