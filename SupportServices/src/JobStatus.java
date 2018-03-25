    enum JobStatus
    {
        CLERK(0),
        MANAGER(1),
        DIRECTOR(2),
        PRESIDENT(3);

        int jobStatus;

        JobStatus(int jobStatus)
        {
            this.jobStatus = jobStatus;
        }

        public int getJobStatus()
        {
            return jobStatus;
        }
}