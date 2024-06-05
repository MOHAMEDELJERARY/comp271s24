/*
 * In the class below, write two methods:
 * 
 * First, method resize() to expand the existing array data by doubling its size.
 *
 * Second, method contains(String string) that returns true if String string already
 * exists in array data and false otherwise.
 *
 * Your code must have comments explaining what is done and why it is done in the
 * way you do it.
 *
 * DO NOT USE any tools that require to be imported, ie, do not use the import command.
 *
 * To save this assignment, make sure you commit your changes to your GitHub repository,
 * following the instructions in Sakai. IF YOU DO NOT COMMIT THE CHANGES, IT IS POSSIBLE THAT
 * YOUR WORK MAY BE LOST AND YOU MAY HAVE TO START ALL OVER AGAIN.
 */
public class DynamicArray {

    /** The underlying array for this object */
    private String[] data;

    /** Currently available position in array data */
    private int position;

    /** Constant with default size */
    private static final int DEFAULT_SIZE = 10;

    /**
     * Basic constructor for the object
     * @param size initial size of array data
     */
    public DynamicArray(int size) {
        this.data = new String[size];
        this.position = 0;
    } // basic constructor

    /** Default constructor */
    public DynamicArray() {
        this(DEFAULT_SIZE);
    } // default constructor

    /**
     * Adds a new item to array data after ensurig there is 
     * sufficient room by resizing the array if necessary.
     * @param string new item to add to array
     */
    public void add(String string) {
        // Make sure there is room in array data
        if (this.position == this.data.length) {
            resize();
        }
        // Now array has room for more elements.
        this.data[this.position] = string;
        this.position++;
    } // method add

    public void resize() { // We need to increase the size of the array to accomodate for more elements.
        String[] newData = new String[this.data.length * 2]; // This creates an array double the size of what we had before. 
        for (int i = 0; i < this.data.length; i++) { // Add previous array info into this new array using for loop to increment over (each element). 
            newData[i] = this.data[i]; // Add elements from previous array to current object (content of for loop).
        }

        this.data = newData; // This makes sure that this.data calls back to the new array we created.
    }

    public boolean contains(String string) { // Because we're looking for a return of true or false, we have to specify that this type of method will return boolean values. 
        for (int i = 0; i < this.position; i++) { // For loop to run over each element of the array.
            if (this.data[i].equals(string)) { // Conditional statement checking whether the element being looked at matches inputted string. 
                return true; // If there is a match with the inputted string, it will return a true value. 
            }
        }
        return false; // If it can't find a match, false will be returned. 
    }
    
} // class DynamicArray
