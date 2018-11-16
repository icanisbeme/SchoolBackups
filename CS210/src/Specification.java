
public interface Specification {

	public int factorial(int n);
	
	public int fibonacci(int n);
	
	public int abs(int n);
	
	public String parity(double n);
	
	public boolean failOnFlase(boolean flag);
	
	public int accumulate(int addend); //stateful (persists in between calls of the method)
	
	public void reset(); // resets the total of the accumalate method
	
}
