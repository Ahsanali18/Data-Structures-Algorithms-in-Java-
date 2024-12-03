package recursiveApproach;
public class FibonacciSeries {

    // Method to calculate the nth Fibonacci number using recursion
    public static long fibonacci(int n) {
        if (n == 0) return 0; // Base condition
        if (n == 1) return 1; // Base condition
        return fibonacci(n - 1) + fibonacci(n - 2); // Recursive call
    }

    public static void main(String[] args) {
        // Start time in nanoseconds
        long startTime = System.nanoTime();

        // Print Fibonacci series from 45 to 50
        System.out.println("Fibonacci series from 45 to 50:");
        for (int i = 45; i <= 50; i++) {
            System.out.println("Fib(" + i + ") = " + fibonacci(i));
        }

        // End time in nanoseconds
        long endTime = System.nanoTime();

        // Calculate the time taken in seconds
        double timeElapsed = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("Time taken to generate the series: " + timeElapsed + " seconds");
    }
}
