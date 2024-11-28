public class HashTable {
    // Method to calculate hash value for a given key
    public static int hashFunction(String key, int tableSize) {
        int hash = 0;
        // Loop through each character in the string
        for (char c : key.toCharArray()) {
            hash += c;  // Add ASCII value of each character to the hash
        }
        return hash % tableSize;  // Return the index based on the table size
    }

    public static void main(String[] args) {
        int tableSize = 10;

        // Test the hash function with "data" and "structure"
        String key1 = "data";
        String key2 = "structure";

        // Calculate and print hash values
        int hashValue1 = hashFunction(key1, tableSize);
        int hashValue2 = hashFunction(key2, tableSize);

        System.out.println("Hash value for 'data': " + hashValue1);
        System.out.println("Hash value for 'structure': " + hashValue2);
    }
}
