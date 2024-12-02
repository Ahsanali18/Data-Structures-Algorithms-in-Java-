package AllProbingTechniques;
class DoubleHashingHashTable {
    private Object[] keys;
    private Object[] values;
    private int size;

    public DoubleHashingHashTable(int capacity) {
        keys = new Object[capacity];
        values = new Object[capacity];
        size = 0;
    }

    private int hash1(Object key) {
        return (key.hashCode() & 0x7fffffff) % keys.length;
    }

    private int hash2(Object key) {
        // A secondary hash function to determine the step size, ensuring it's non-zero
        return 1 + (key.hashCode() & 0x7fffffff) % (keys.length - 2);
    }

    public void put(Object key, Object value) {
        int index = hash1(key);
        int stepSize = hash2(key);

        // Double hashing: (index + i * stepSize) % keys.length
        int i = 0;
        while (keys[(index + i * stepSize) % keys.length] != null) {
            if (keys[(index + i * stepSize) % keys.length].equals(key)) {
                values[(index + i * stepSize) % keys.length] = value; // Update existing value
                return;
            }
            i++;
        }

        // Insert the key and value
        keys[(index + i * stepSize) % keys.length] = key;
        values[(index + i * stepSize) % keys.length] = value;
        size++;
    }

    public Object get(Object key) {
        int index = hash1(key);
        int stepSize = hash2(key);

        // Double hashing: (index + i * stepSize) % keys.length
        int i = 0;
        while (keys[(index + i * stepSize) % keys.length] != null) {
            if (keys[(index + i * stepSize) % keys.length].equals(key)) {
                return values[(index + i * stepSize) % keys.length];
            }
            i++;
        }
        return null;
    }
}
