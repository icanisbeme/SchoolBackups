public class MyStringTester {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyString c1 = new MyString("hello");
		if(c1.isEmpty())
			System.out.println("Check isEmpty() ");
		else
			System.out.println("isEmpty() working !");
		
		if(c1.length() != 5)
			System.out.println("Check length() ");
		else
			System.out.println("length() working !");
		
		MyString c2 = c1.substring(1, 3);		
		char[] temp = {'e', 'l'};
		if( Arrays.equals( c2.charArray , temp  ) )
			System.out.println("substring(start, end) working !");
		else
			System.out.println("Check substring(start, end) ");
		
		MyString c3 = c1.substring(1);		
		char[] temp3 = {'e', 'l', 'l', 'o'};
		if( Arrays.equals( c3.charArray , temp3  ))
			System.out.println("substring(start) working !");
		else
			System.out.println("Check substring(start) ");
		
		if(c1.charAt(2) != 'l')
			System.out.println("Check position() ");
		else
			System.out.println("position() working !");
		
		if(c1.indexOf('l') != 2)
			System.out.println("Check indexOf(char) ");
		else
			System.out.println("indexOf(char) working !");
		
		char[] temp2 = {'h', 'e', 'k', 'k', 'o'};
		if(Arrays.equals(c1.replace('l', 'k').charArray , temp2) )
			System.out.println("replace() working !");
		else
			System.out.println("Check replace()");
	}
}