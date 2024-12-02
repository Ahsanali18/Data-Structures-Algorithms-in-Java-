package AllProbingTechniques;
class QuadraticProbingHashTable {
    private Object[] keys;
    private Object[] values;
    private int size;

    public QuadraticProbingHashTable(int capacity) {
        keys = new Object[capacity];
        values = new Object[capacity];
        size = 0;
    }

    private int hash(Object key) {
        return (key.hashCode() & 0x7fffffff) % keys.length;
    }

    public void put(Object key, Object value) {
        int index = hash(key);
        int i = 0; // Quadratic increment variable

        // Quadratic probing: (index + i^2) % keys.length
        while (keys[(index + i * i) % keys.length] != null) {
            if (keys[(index + i * i) % keys.length].equals(key)) {
                values[(index + i * i) % keys.length] = value; // Update existing value
                return;
            }
            i++;
        }

        // Insert the key and value
        keys[(index + i * i) % keys.length] = key;
        values[(index + i * i) % keys.length] = value;
        size++;
    }

    public Object get(Object key) {
        int index = hash(key);
        int i = 0; // Quadratic increment variable

        // Quadratic probing: (index + i^2) % keys.length
        while (keys[(index + i * i) % keys.length] != null) {
            if (keys[(index + i * i) % keys.length].equals(key)) {
                return values[(index + i * i) % keys.length];
            }
            i++;
        }
        return null;
    }
}
