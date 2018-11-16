package recursionPractice;
public class recursionDemos {
	public static void main(String[] args){
		System.out.println("test");
		int n = 10;
		System.out.println(factorial(n));
		System.out.println(fibonacci(n));
	}
	
	public static long factorial(int n) { 
	    if (n == 1) return 1; 
	    return n * factorial(n-1); 
	} 
	
	public static long fibonacci(int n) {
	    long[] f = new long[n+1];
	    f[0] = 0;
	    f[1] = 1;
	    for (int i = 2; i <= n; i++)
	    f[i] = f[i-1] + f[i-2];
	    return f[n];
	}
}