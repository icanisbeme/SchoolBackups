
public class FibonnaciExecutionTime {
	public static void main(String[] args){
		long startTime = System.currentTimeMillis();
		fibonacciIterative(45);
		long endTime = System.currentTimeMillis();
		System.out.println(startTime);
		System.out.println(endTime);
	}

	public static int fibonacciRecursive(int n) {
		if (n <= 2) return 1;
		return fibonacciRecursive(n-2) + fibonacciRecursive(n-1);
	}

	public static int fibonacciIterative(int n) {
		int previous = 1;
		int next = 1;
		int current = 1;

		for (int i = 3; i <= n; i++) {
			next = current + previous;
			previous = current;
			current = next;
		}
		return next;
	}
}
