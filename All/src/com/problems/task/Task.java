package src.com.problems.task;
//  TODO : will be update --> 


// // create a class TaskNode with head
// class Task {
//     private TaskNode head,tail;

//     Task() {
//         this.head = null;
//         this.tail = null;
//     }

//     // addBegning
//     void addBegning(TaskNode t1) {

//         TaskNode newTask = new TaskNode(t1.TaskId, t1.taskName, t1.Priority, t1.dueDate);
//         if (head == null) {
//             head = newTask;
//             tail = newTask;
//         } else {
//             tail.next = newTask;
//             newTask.next = head;
//             tail = newTask;
//         }
//     }
//     // addEnding
//     void addEnding(TaskNode t1) {
//         TaskNode newTask = new TaskNode(t1.TaskId, t1.taskName, t1.Priority, t1.dueDate);
//         if (head == null) {
//             head = newTask;
//             tail = newTask;
//         } else {
//             TaskNode curr = head;
//             while (curr.next != null) {
//                 curr = curr.next;
//             }
//             curr.next = newTask;
//             newTask.next = head;
//             tail = newTask;
//         }
//     }

//     // print all Tasks record
//     void displayTasks() {
//         TaskNode curr = head;
//         while (curr != tail) {
//             System.out.println("TaskId: " + curr.TaskId + "\n" + " taskName: " + curr.taskName + "\n" + " Priority: "
//                     + curr.Priority + "\n" + " dueDate: " + curr.dueDate);
//             System.out.println("-------------------------------------------------------------------------");
//             curr = curr.next;
//         }
//         System.out.println("TaskId: " + curr.TaskId + "\n" + " taskName: " + curr.taskName + "\n" + " Priority: "
//                 + curr.Priority + "\n" + " dueDate: " + curr.dueDate);
//         System.out.println("-------------------------------------------------------------------------");
//     }

// }

// for temp code -- >


class Task {
    private TaskNode head = null;
    private TaskNode tail = null;

    // Add a task at the end (addEnding)
    public void addEnding(TaskNode t1) {
        TaskNode newTask = new TaskNode(t1.TaskId, t1.taskName, t1.Priority, t1.dueDate);
        if (head == null) {
            head = newTask;
            tail = newTask;
            newTask.next = head; // Circular link
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head; // Maintain the circular structure
        }
    }

    // Add a task at the beginning (addBeginning)
    public void addBeginning(TaskNode t1) {
        TaskNode newTask = new TaskNode(t1.TaskId, t1.taskName, t1.Priority, t1.dueDate);
        if (head == null) {
            head = newTask;
            tail = newTask;
            newTask.next = head; // Circular link
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head; // Maintain the circular structure
        }
    }

    // Add a task at a specific position (addAtPosition)
    public void addAtPosition(TaskNode t1, int position) {
        TaskNode newTask = new TaskNode(t1.TaskId, t1.taskName, t1.Priority, t1.dueDate);
        if (position == 0) {
            addBeginning(t1);
            return;
        }

        TaskNode curr = head;
        int count = 0;
        while (curr != null && count < position - 1) {
            curr = curr.next;
            count++;
            if (curr == head) break;
        }
        
        if (curr != null) {
            newTask.next = curr.next;
            curr.next = newTask;
            if (curr == tail) {
                tail = newTask;  // Update tail if new node is added at the end
            }
        }
    }

    // Remove a task by Task ID (removeTaskById)
    public void removeTaskById(String taskId) {
        if (head == null) {
            return; // Empty list
        }

        TaskNode curr = head;
        TaskNode prev = null;
        
        do {
            if (curr.TaskId.equals(String.valueOf(taskId))) {
                if (prev == null) {
                    // Removing the head
                    head = head.next;
                    tail.next = head;  // Maintain circularity
                } else {
                    prev.next = curr.next;
                    if (curr == tail) {
                        tail = prev;  // Update tail if we remove the last node
                    }
                }
                return;  // Task removed
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    // View current task and move to the next task (moveNext)
    public void moveNext() {
        if (head != null) {
            head = head.next; // Move to next task
        }
    }

    // Display all tasks
    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        TaskNode curr = head;
        do {
            System.out.println("Task ID: " + curr.TaskId + ", Task Name: " + curr.taskName + 
                               ", Priority: " + curr.Priority + ", Due Date: " + curr.dueDate);
            curr = curr.next;
        } while (curr != head);
    }

    // Search tasks by Priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        TaskNode curr = head;
        boolean found = false;
        do {
            if (curr.Priority == priority) {
                System.out.println("Task ID: " + curr.TaskId + ", Task Name: " + curr.taskName +
                                   ", Priority: " + curr.Priority + ", Due Date: " + curr.dueDate);
                found = true;
            }
            curr = curr.next;
        } while (curr != head);

        if (!found) {
            System.out.println("No tasks found with Priority " + priority);
        }
    }
}
