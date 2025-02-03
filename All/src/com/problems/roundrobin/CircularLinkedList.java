package src.com.problems.roundrobin;

class CircularLinkedList {
    private Node head;
    private Node tail;

    // Node class for circular linked list
    class Node {
        Process process;
        Node next;

        public Node(Process process) {
            this.process = process;
            this.next = null;
        }
    }

    // Add a process to the end of the circular list
    public void addProcess(Process process) {
        Node newNode = new Node(process);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;  // Circular link
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;  // Circular link
        }
    }

    // Remove a process by processId
    public void removeProcess(int processId) {
        if (head == null) return; // List is empty

        Node current = head;
        Node previous = null;

        do {
            if (current.process.processId == processId) {
                if (previous == null) { // Node to remove is the head
                    head = head.next;
                    tail.next = head; // Update tail's next reference
                } else {
                    previous.next = current.next;
                    if (current == tail) {
                        tail = previous; // Update tail if last node is removed
                    }
                }
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head); // Loop through circular list
    }

    // Get the head (first process)
    public Node getHead() {
        return head;
    }

    // Get the next process in the list
    public Node getNext(Node current) {
        return current.next;
    }
}
