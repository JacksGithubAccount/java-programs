
public class JobRequest implements Comparable<JobRequest>
{
	private JobStatus jobStatus;
	private int jobId;
	private int jobTime;
	
	public JobRequest(JobStatus jobStatus, int jobId, int jobTime)
	{
		this.jobStatus = jobStatus;
		this.jobId = jobId;
		this.jobTime = jobTime;
	}
	public String toString()
	{
		return String.format("Job ID: " + jobId + " Job Time: " + jobTime + " Job Status: " + jobStatus);
	}
	public int compareTo(JobRequest other)
	{
		int compareStatus = other.getJobStatusValue() - this.getJobStatusValue();
		if (compareStatus == 0)
		{
			compareStatus = this.getJobTime() - other.getJobTime();
		}
		return compareStatus;
	}
	public int getJobStatusValue() {
		return jobStatus.getJobStatus();
	}
	public JobStatus getJobStatus() {
		return jobStatus;
	}
	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public int getJobTime() {
		return jobTime;
	}

	public void setJobTime(int jobTime) {
		this.jobTime = jobTime;
	}
}
