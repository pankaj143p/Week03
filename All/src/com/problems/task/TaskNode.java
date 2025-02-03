package src.com.problems.task;
// create a class Student with rollNumber, name, age, grade, next, prev
class TaskNode {
    String TaskId;
    String taskName;
    int Priority;
    String dueDate;
    TaskNode next;

    TaskNode(String TaskId, String taskName, int Priority, String dueDate) {
        this.TaskId = TaskId;
        this.taskName = taskName;
        this.Priority = Priority;
        this.dueDate = dueDate;
        this.next = null;
    }

   
}