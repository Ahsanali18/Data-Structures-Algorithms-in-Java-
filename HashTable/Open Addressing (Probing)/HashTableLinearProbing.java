package AllProbingTechniques;
class HashTableLinearProbing {
    private static final int TABLE_SIZE = 10; // Size of the hash table
    private String[] keys; // Array to store keys
    private String[] values; // Array to store values
    private int count; // Current number of elements in the table

    // Constructor to initialize the hash table
    public HashTableLinearProbing() {
        keys = new String[TABLE_SIZE];
        values = new String[TABLE_SIZE];
        count = 0;
    }

    // Hash function
    private int hash(String key) {
        return Math.abs(key.hashCode()) % TABLE_SIZE;
    }

    // Insert key-value pair into the hash table
    public void insert(String key, String value) {
        if (count >= TABLE_SIZE) {
            System.out.println("Hash table is full! Rehashing required.");
            return;
        }

        int index = hash(key);

        // Find the next available slot
        while (keys[index] != null) {
            // If the key already exists, update the value
            if (keys[index].equals(key)) {
                values[index] = value;
                return;
            }
            index = (index + 1) % TABLE_SIZE; // Linear probing
        }

        // Insert the key-value pair
        keys[index] = key;
        values[index] = value;
        count++;
    }

    // Search for a key in the hash table
    public String search(String key) {
        int index = hash(key);

        // Probe until we find the key or reach an empty slot
        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                return values[index];
            }
            index = (index + 1) % TABLE_SIZE; // Linear probing
        }

        return null; // Key not found
    }

    // Delete a key-value pair from the hash table
    public void delete(String key) {
        int index = hash(key);

        // Probe until we find the key or reach an empty slot
        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                keys[index] = null;
                values[index] = null;
                count--;

                // Rehash elements in the same cluster to avoid breaking the chain
                rehash(index);
                return;
            }
            index = (index + 1) % TABLE_SIZE; // Linear probing
        }

        System.out.println("Key not found: " + key);
    }

    // Rehash elements in the same cluster after deletion
    private void rehash(int start) {
        int index = (start + 1) % TABLE_SIZE;

        while (keys[index] != null) {
            String rehashKey = keys[index];
            String rehashValue = values[index];
            keys[index] = null;
            values[index] = null;
            count--;
            insert(rehashKey, rehashValue); // Reinsert the element
            index = (index + 1) % TABLE_SIZE;
        }
    }

    // Display the hash table
    public void displayTable() {
        System.out.println("Hash Table:");
        for (int i = 0; i < TABLE_SIZE; i++) {
            if (keys[i] != null) {
                System.out.println("Index " + i + ": [" + keys[i] + ", " + values[i]+"]");
            } else {
                System.out.println("Index " + i + ": Empty");
            }
        }
    }

    // Main method to test the hash table
    public static void main(String[] args) {
        HashTableLinearProbing ht = new HashTableLinearProbing();

        ht.insert("Alice", "24");
        ht.insert("Bob", "30");
        ht.insert("Charlie", "29");
        ht.insert("Diana", "35");

        ht.displayTable();

        System.out.println("\nSearch for Alice: " + ht.search("Alice"));
        System.out.println("Search for Bob: " + ht.search("Bob"));

        System.out.println("\nDelete Charlie:");
        ht.delete("Charlie");
        ht.displayTable();

        System.out.println("\nInsert Eve:");
        ht.insert("Eve", "27");
        ht.displayTable();
    }
}
