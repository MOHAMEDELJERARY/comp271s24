public class Hash271 {

    /** Default size for foundation array */
    private static final int DEFAULT_SIZE = 4;

    /** Default load factor threshold */
    private static final double DEFAULT_THRESHOLD = 0.75; // Default load factor threshold

    /** Foundation array of node objects */
    Node[] foundation;

    /** Number of nodes in the foundation */
    private int nodeCount; // To keep track of the number of nodes

    /** Load factor threshold for resizing */
    private double threshold;

    /** Basic constructor */
    public Hash271(int size) {
        this.foundation = new Node[size];
        this.nodeCount = 0; // Initialize node count to 0
        this.threshold = threshold; // Set the threshold
    } // basic constructor

    /** Default constructor */
    public Hash271() {
        this(DEFAULT_SIZE, DEFAULT_THRESHOLD); // Use the default size and threshold
    } // default constructor

    /**
     * Map an integer number to one of the positions of the underlying array. This
     * will come handy we need to find the place to chain a node.
     * 
     * @param value int to map to one of the array positions
     * @return int with the integer division remainder between the input value and
     *         the length of the array
     */
    private int computeArrayPosition(int value) {
        return value % this.foundation.length;
    } // method computeArrayPosition

    /**
     * Chain a node to the underlying array
     * 
     * @param node Node to chain to the underlying array
     */
    public void put(Node node) {
        // Operate only is node is not null
        if (node != null) {
            // Use the node's hashcode to determine is position in
            // the underlying array
            int destination = computeArrayPosition(node.hashCode());
            // If the position in the array is occupied by another node,
            // place that node under the new node we wish to insert
            if (this.foundation[destination] != null) {
                node.setNext(this.foundation[destination]);
            }
            // Put the new node to the array position
            this.foundation[destination] = node;
            // Increment the node count
            this.nodeCount++; // Increase node count after adding a node
            // Check if load factor exceeds threshold and rehash if necessary
            if ((double) this.nodeCount / this.foundation.length > this.threshold) {
                this.rehash(); // Rehash if load factor exceeds threshold
            }
        }
    } // method put

    /**
     * Wrapper for put(Node). Accepts a string, creates a Node object and passes it
     * to the put(Node) method.
     * 
     * @param string String to create a node for, then chain that node to the
     *               underlying array.
     */
    public void put(String string) {
        if (string != null && string.length() > 0) {
            Node node = new Node(string);
            this.put(node);
        }
    } // method put

    /**
     * Rehash the structure by doubling the size of the foundation array
     * and re-distributing all nodes.
     */
    private void rehash() {
        // Create a new foundation array with double the size
        Node[] newFoundation = new Node[this.foundation.length * 2]; // Double the array size
        Node[] oldFoundation = this.foundation; // Keep reference to old foundation
        this.foundation = newFoundation; // Replace current foundation with new one
        this.nodeCount = 0; // Reset node count before re-adding nodes

        // Move each node from the old foundation to the new one
        for (Node node : oldFoundation) {
            while (node != null) {
                Node nextNode = node.getNext(); // Save reference to next node
                node.setNext(null); // Clear next node reference before re-inserting
                this.put(node); // Re-insert node into new foundation
                node = nextNode; // Move to next node in the chain
            }
        }
    } // method rehash

    /** String representation of this object */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.foundation.length; i++) {
            sb.append(String.format("[ %03d ]: ", i));
            Node current = this.foundation[i];
            while (current != null) {
                sb.append(String.format("<%s> ", current.toString()));
                current = current.getNext();
            }
            sb.append("\n");
        }
        return sb.toString();
    } // method toString

    /** Driver code */
    public static void main(String[] args) {
        Hash271 h = new Hash271();
        h.put(new Node("Java"));
        h.put(new Node("Python"));
        h.put(new Node("Lisp"));
        h.put(new Node("Fortran"));
        h.put(new Node("Prolog"));
        h.put(new Node("Cobol"));
        h.put(new Node("C++"));
        h.put(new Node("C"));
        h.put(new Node("C#"));
        System.out.println(h);
    }
}
