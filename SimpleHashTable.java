import java.util.LinkedList;

public class SimpleHashTable {
    // The hash table is now an array of LinkedLists to handle collisions
    private LinkedList<Integer>[] table;

    // Constructor to initialize the table with the given size
    public SimpleHashTable(int size) {
        table = new LinkedList[size];
        // Initialize each index with an empty LinkedList
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Insert method to handle collisions using separate chaining
    public void insert(int key) {
        int index = key % table.length; // Compute the index
        table[index].add(key); // Add the key to the LinkedList at the computed index
    }

    // Display the table and all its elements
    public void display() {
        for (int i = 0; i < table.length; i++) {
            System.out.print("Index " + i + ": ");
            for (Integer key : table[i]) {
                System.out.print(key + " ");
            }
            System.out.println(); // Move to the next line after printing each index's list
        }
    }

    // Main method to test the hash table with collision handling
    public static void main(String[] args) {
        SimpleHashTable hashTable = new SimpleHashTable(10);
        
        // Insert some values into the hash table
        hashTable.insert(12); // This will go to index 2
        hashTable.insert(22); // This will also go to index 2 (collision)
        hashTable.insert(32); // This will also go to index 2 (collision)
        hashTable.insert(15); // This will go to index 5
        
        // Display the table and its contents
        hashTable.display();
    }
}
