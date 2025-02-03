package src.com.problems.roundrobin;
import java.util.*;

public class RoundRobinScheduler {
    private CircularLinkedList processList;
    private int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.processList = new CircularLinkedList();
        this.timeQuantum = timeQuantum;
    }

    // Add process to the scheduler
    public void addProcess(int processId, int burstTime, int priority) {
        Process process = new Process(processId, burstTime, priority);
        processList.addProcess(process);
    }

    // Simulate round robin scheduling
    public void schedule() {
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int completedProcesses = 0;
        CircularLinkedList.Node currentNode = processList.getHead();

        while (currentNode != null && currentNode != processList.getHead()) {
            Process currentProcess = currentNode.process;
            if (currentProcess.remainingTime > 0) {
                // Execute process for time quantum or remaining time
                int executionTime = Math.min(currentProcess.remainingTime, timeQuantum);
                currentProcess.remainingTime -= executionTime;

                // Calculate waiting and turnaround times
                int waitingTime = completedProcesses == 0 ? 0 : totalWaitingTime / completedProcesses;
                int turnaroundTime = completedProcesses == 0 ? executionTime : totalTurnaroundTime / completedProcesses;
                totalWaitingTime += waitingTime;
                totalTurnaroundTime += turnaroundTime;

                // If process finished execution, remove from the list
                if (currentProcess.remainingTime == 0) {
                    processList.removeProcess(currentProcess.processId);
                    completedProcesses++;
                }
            }

            // Move to next process
            currentNode = processList.getNext(currentNode);
            if (currentNode == processList.getHead()) {
                break; // Stop if the list is back to the beginning
            }
        }

        // Display the average waiting and turnaround times
        if (completedProcesses > 0) {
            System.out.println("Average Waiting Time: " + (double) totalWaitingTime / completedProcesses);
            System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / completedProcesses);
        } else {
            System.out.println("No processes to execute.");
        }
    }

    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler(4); // Time quantum of 4 units
        scheduler.addProcess(1, 1, 1);
        scheduler.addProcess(2, 5, 1);
        scheduler.addProcess(3, 8, 2);

        scheduler.schedule();
    }
}
