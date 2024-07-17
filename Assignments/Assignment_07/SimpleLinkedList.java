
/**
 * A basic linked list that offers stack-like and queue-like behavior.
 */
public class SimpleLinkedList implements Stack271<String>, Queue271<String> {

    /** The first node of the linked list */
    private Node head;

    /** The last node of the linked list */
    private Node tail;

    public SimpleLinkedList() { // Constructor to initialize an empty list
        this.head = null; // Head is initially null
        this.tail = null; // Tail is initially null
    }

    // Queue271 methods

    /**
     * Adds a string to the end of the list.
     * 
     * @param e String to add
     * @return true
     */
    @Override
    public boolean add(String e) {
        Node newNode = new Node(e); // Create a new node with the given data
        if (this.tail == null) { // Check if the list is empty
            this.head = newNode; // Set head to new node if list is empty
            this.tail = newNode; // Set tail to new node if list is empty
        } else {
            this.tail.setNext(newNode); // Link the new node to the end of the list
            this.tail = newNode; // Update the tail to the new node
        }
        return true; // Return true as the operation is always successful in linked list
    }

    /**
     * Removes and returns the first element from the list.
     * 
     * @return String at the front of the list or null if the list is empty
     */
    @Override
    public String remove() {
        if (this.head == null) { // Check if the list is empty
            return null; // Return null if the list is empty
        }
        String data = this.head.toString(); // Get data from the head node
        this.head = this.head.getNext(); // Move head to the next node
        if (this.head == null) { // Check if the list is now empty
            this.tail = null; // Set tail to null if the list is empty
        }
        return data; // Return the data of the removed node
    }

    // Stack271 methods

    /**
     * Adds a string to the front of the list.
     * 
     * @param e String to add
     * @return true
     */
    @Override
    public boolean push(String e) {
        Node newNode = new Node(e); // Create a new node with the given data
        if (this.head == null) { // Check if the list is empty
            this.head = newNode; // Set head to new node if list is empty
            this.tail = newNode; // Set tail to new node if list is empty
        } else {
            newNode.setNext(this.head); // Link the new node to the front of the list
            this.head = newNode; // Update the head to the new node
        }
        return true; // Return true as the operation is always successful in linked list
    }

    /**
     * Removes and returns the first element from the list (same as remove).
     * 
     * @return String at the front of the list or null if the list is empty
     */
    @Override
    public String pull() {
        return remove(); // Use the same logic as remove() for stack pull operation
    }

     // Main method for testing
    public static void main(String[] args) {
        SimpleLinkedList demoQueue = new SimpleLinkedList(); // Create a new SimpleLinkedList instance for queue
        SimpleLinkedList demoStack = new SimpleLinkedList(); // Create a new SimpleLinkedList instance for stack

        demoQueue.add("A"); // Add "A" to the queue
        demoQueue.add("B"); // Add "B" to the queue
        demoQueue.add("C"); // Add "C" to the queue

        boolean queueWorks = demoQueue.remove().equals("A") && // Remove and check if the first element is "A"
                demoQueue.remove().equals("B") && // Remove and check if the next element is "B"
                demoQueue.remove().equals("C") && // Remove and check if the next element is "C"
                demoQueue.remove() == null; // Remove and check if the queue is now empty

        demoStack.push("A"); // Push "A" onto the stack
        demoStack.push("B"); // Push "B" onto the stack
        demoStack.push("C"); // Push "C" onto the stack

        boolean stackWorks = demoStack.pull().equals("C") && // Pull and check if the first element is "C"
                demoStack.pull().equals("B") && // Pull and check if the next element is "B"
                demoStack.pull().equals("A") && // Pull and check if the next element is "A"
                demoStack.pull() == null; // Pull and check if the stack is now empty

        System.out.println(queueWorks); // Print the result of the queue test
        System.out.println(stackWorks); // Print the result of the stack test
    }
} // class SimpleLinkedList
