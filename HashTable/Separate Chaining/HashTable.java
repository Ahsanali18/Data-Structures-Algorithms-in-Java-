package SeparateChaining;
import java.util.LinkedList;

class HashTable {
    private int tableSize;  // Size of the hashFunction table
    private LinkedList<Entry>[] table;
    private int count;  // Number of elements in the table

    // Constructor
    public HashTable(int size) {

        this.tableSize = size;
        this.table = new LinkedList[tableSize];

        for (int i = 0; i < tableSize; i++) {
            table[i] = new LinkedList<>();
        }
        this.count = 0;
    }

    // Entry class for key-value pairs
    private class Entry{
        String key;
        String value;

        public Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    // hashFunction function
    private int hashFunction(String key) {
        return Math.abs(key.hashCode() % tableSize);
    }
   /* private int hashFunctionMultiplication(String key) {
        double A= (Math.sqrt(5)-1)/2;
        double fractionalPart= Math.abs(key.hashCode()*A)%1;

        return (int)(tableSize*fractionalPart);
    }*/

    // Insert a key-value pair
    public void insert(String key, String value) {
        if (getLoadFactor() > 0.7) {
            rehashFunction();
        }

        int index = hashFunction(key);
        LinkedList<Entry> bucket = table[index];

        // Check if the key already exists
        for (Entry Entry : bucket) {
            if (Entry.key.equals(key)) {
                Entry.value = value;  // Update the value
                return;
            }
        }

        // Add a new key-value pair
        bucket.add(new Entry(key, value));
        count++;
    }

    // Search for a key
    public String search(String key) {
        int index = hashFunction(key);
        LinkedList<Entry> bucket = table[index];

        for (Entry Entry : bucket) {
            if (Entry.key.equals(key)) {
                return Entry.value;
            }
        }

        return null;  // Key not found
    }

    // Delete a key
    public void delete(String key) {
        int index = hashFunction(key);
        LinkedList<Entry> bucket = table[index];

        for (Entry Entry : bucket) {
            if (Entry.key.equals(key)) {
                bucket.remove(Entry);
                count--;
                return;
            }
        }
    }

    // Display the hashFunction table
    public void displayTable() {
        for (int i = 0; i < tableSize; i++) {
            System.out.print("Bucket " + i + ": ");
            for (Entry Entry : table[i]) {
                System.out.print("[" + Entry.key + ": " + Entry.value + "] ");
            }
            System.out.println();
        }
    }

    // Get the load factor
    private double getLoadFactor() {
        return (double)(count / tableSize);
    }

    // RehashFunction the table
    private void rehashFunction() {
        System.out.println("RehashFunctioning...");

        int newTableSize = tableSize * 2;
        LinkedList<Entry>[] oldTable = table;

        table = new LinkedList[newTableSize];
        tableSize = newTableSize;
        count=0; 
        
        for (int i = 0; i < tableSize; i++) {
            table[i] = new LinkedList<>();
        }

        for (LinkedList<Entry> bucket : oldTable) {
            for (Entry Entry : bucket) {
                insert(Entry.key, Entry.value);  // Reinsert all elements
            }
        }
    }

    // Main method to test the hashFunction table
    public static void main(String[] args) {
        HashTable ht = new HashTable(5);

        ht.insert("Ahsan", "18");
        ht.insert("Ali", "30");
        ht.insert("Ahmed", "22");
        ht.insert("Sameer", "28");
        ht.insert("Jhazaib", "35");

        ht.displayTable();

        // Inserting more elements to trigger rehashFunctioning
        ht.insert("Mujeeb", "40");
        ht.insert("Zeeshan", "25");

        ht.displayTable();

        System.out.println("Search Ahsan: " + ht.search("Ahsan"));
        System.out.println("Search Zeeshan: " + ht.search("Zeeshan"));

        ht.delete("Ahmed");
        System.out.println("After deleting Ahmed:");
        ht.displayTable();
    }
}
