import java.util.LinkedList;

public class SimpleHash {
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

    // Method to search for a key in the hash table
    public int search(int key) {
        int index = key % table.length; // Compute the index
        // Check if the key is in the LinkedList at the computed index
        if (table[index].contains(key)) {
            return index; // Key found, return the index
        } else {
            return -1; // Key not found, return -1
        }
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

    // Main method to test the hash table with collision handling and search
    public static void main(String[] args) {
        SimpleHashTable hashTable = new SimpleHashTable(10);
        
        // Insert some values into the hash table
        hashTable.insert(12); // This will go to index 2
        hashTable.insert(22); // This will also go to index 2 (collision)
        hashTable.insert(32); // This will also go to index 2 (collision)
        hashTable.insert(15); // This will go to index 5
        
        // Display the table and its contents
        hashTable.display();
        
        // Test the search method
        int searchResult = hashTable.search(22);
        if (searchResult != -1) {
            System.out.println("Key 22 found at index: " + searchResult);
        } else {
            System.out.println("Key 22 not found.");
        }

        // Test searching for a key that doesn't exist
        searchResult = hashTable.search(100);
        if (searchResult != -1) {
            System.out.println("Key 100 found at index: " + searchResult);
        } else {
            System.out.println("Key 100 not found.");
        }
    }
}
