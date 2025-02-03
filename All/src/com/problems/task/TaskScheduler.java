package src.com.problems.task;
class TaskScheduler {
    public static void main(String[] args) {
        Task tn = new Task();
        TaskNode t1=new TaskNode("100CS2", "English Eassay Writing", 2, "21/2/2025");
        TaskNode t2=new TaskNode("100CS2", "Maths Assignment", 3,"21/03/2025");
        TaskNode t3=new TaskNode("100CS2", "Science Project", 4,"23/04/2025");
        TaskNode t4=new TaskNode("100CS2", "History Essay", 5,"25/03/2025");
        
        tn.addBeginning(t3);
        tn.addBeginning(t1);
        // tn.displayTasks();
        tn.addEnding(t4);
        tn.addBeginning(t2);
        tn.displayTasks();
        // tn.displayTasks();

        // Search for tasks by priority
        tn.searchByPriority(2);
        // Remove a task by Task ID
        tn.removeTaskById("100CS2");

        // Display all tasks after removal
        tn.displayTasks();

        // Move to the next task
        tn.moveNext();
        tn.displayTasks();
        
        
    }

}
