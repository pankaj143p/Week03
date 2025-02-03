package src.com.problems.roundrobin;
class Process {
    int processId;
    int burstTime;
    int remainingTime; // To track remaining burst time during scheduling
    int priority;

    // Constructor to initialize a process
    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
    }
}
