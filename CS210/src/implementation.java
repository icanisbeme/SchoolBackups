
public class implementation implements Specification{

	@Override
	public int factorial(int n) {
		if(n <= 1)
			return 1;
		else
			return n * factorial(n-1);
	}

	@Override
	public int fibonacci(int n) {
		if(n <= 1)
			return n;
		else
			return fibonacci(n-1) + fibonacci(n-2);

	}

	@Override
	public int abs(int n) {
		return Math.abs(n);
	}

	@Override //rewrite so it can see if odd or even using modulus
	public String parity(double n) {
		String result = "";
		if( n % 2 == 1){
			result = "odd";
		}
		else if( n % 2 == 0){
			result = "even";
		}
		else{
			result = "neither";
		}
		return result;
	}

	@Override
	public boolean failOnFlase(boolean flag) {
		if (flag)
			return flag;
		else
			throw new IllegalStateException();
	}

	private int total = 0;

	@Override
	public int accumulate(int addend) {
		total += addend;
		return total;
	}

	@Override
	public void reset() {
		total = 0;
	}
}
