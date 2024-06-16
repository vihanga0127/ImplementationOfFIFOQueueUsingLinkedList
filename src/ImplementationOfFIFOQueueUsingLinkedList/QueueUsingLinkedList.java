package ImplementationOfFIFOQueueUsingLinkedList;

public class QueueUsingLinkedList {

    // Node class represents a single element in the queue
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Front and rear of the queue
    private Node front, rear;

    // Constructor to initialize the queue
    public QueueUsingLinkedList() {
        this.front = this.rear = null;
    }

    // Method to add an element to the queue (enqueue)
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    // Method to remove an element from the queue (dequeue)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int dequeuedData = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return dequeuedData;
    }

    // Method to peek at the front element of the queue
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return front.data;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Method to print the contents of the queue
    public void printQueue() {
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method to create a sample queue and test methods
    public static void main(String[] args) {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();

        queue.enqueue(167);
        queue.enqueue(90);
        queue.enqueue(45);

        System.out.println("Queue contents after enqueuing 167, 90, 45: ");
        queue.printQueue();

        System.out.println("Front element is: " + queue.peek());

        System.out.println("Dequeued element is: " + queue.dequeue());

        System.out.println("Queue contents after dequeuing: ");
        queue.printQueue();

        System.out.println("Front element is: " + queue.peek());
    }
}
