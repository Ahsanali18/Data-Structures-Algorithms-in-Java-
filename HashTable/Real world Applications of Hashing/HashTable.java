package RealWorldApplications;
import java.util.LinkedList;

class BookEntry {
    private String isbn;
    private String bookName;

    public BookEntry(String isbn, String bookName) {
        this.isbn = isbn;
        this.bookName = bookName;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getBookName() {
        return bookName;
    }

    @Override
    public String toString() {
        return "BookEntry{isbn='" + isbn + "', bookName='" + bookName + "'}";
    }
}

public class HashTable {
    private final int DEFAULT_CAPACITY = 5;
    private LinkedList<BookEntry>[] table;

    public HashTable() {
        table = new LinkedList[DEFAULT_CAPACITY];
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public int hashFunction(String key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % DEFAULT_CAPACITY;
    }

    public void add(String bookIsbn, String bookName) {
        int hashValue = hashFunction(bookIsbn);
        BookEntry newEntry = new BookEntry(bookIsbn, bookName);

        for (BookEntry entry : table[hashValue]) {
            if (entry.getIsbn().equals(bookIsbn)) {
                System.out.println("ISBN is already present!");
                return;
            }
        }

        table[hashValue].add(newEntry);
    }

    public void remove(String bookIsbn) {
        int hashValue = hashFunction(bookIsbn);

        for (BookEntry entry : table[hashValue]) {
            if (entry.getIsbn().equals(bookIsbn)) {
                table[hashValue].remove(entry);
                System.out.println("Book removed: " + bookIsbn);
                return;
            }
        }

        System.out.println("ISBN not found!");
    }

    public String get(String bookIsbn) {
        int hashValue = hashFunction(bookIsbn);

        for (BookEntry entry : table[hashValue]) {
            if (entry.getIsbn().equals(bookIsbn)) {
                return entry.getBookName();
            }
        }

        return null;
    }

    public void displayTable() {
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            System.out.println("Bucket Index " + i + " -> " + table[i]);
        }
    }

    public static void main(String[] args) {
        HashTable books = new HashTable();
        books.add("978-0135166307", "Java Programming");
        books.add("978-0134093413", "Data Structures");
        books.add("978-0132130806", "Algorithms");
        books.add("978-0136006633", "Operating Systems");
        books.add("978-0136061694", "Networking");

        books.displayTable();

        System.out.println("Searching for ISBN '978-0134093413': " + books.get("978-0134093413"));
        books.remove("978-0134093413");
        books.displayTable();
    }
}

