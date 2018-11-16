import java.util.Scanner; 

public class LengthSwitch {
	public static void main ( String [] args){
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please input the length in inches: ");
		int lengthIn = in.nextInt();
		
		System.out.println("1. Feet (1 inch = 0.083333 Feet.)");
		System.out.println("2. Meters (1 inch = 0.0254 Meters.)");
		System.out.println("3. Yards (1 inch = 0.0277778 Yards.)");
		
		System.out.println("Which metric would you like to convert to?");
		int metric = in.nextInt();
		
		switch(metric){
		case 1: System.out.println(lengthIn + " inches is equal to " + (lengthIn * 0.08333333)
				+ " feet."); break;
		case 2: System.out.println(lengthIn + " inches is equal to " + (lengthIn * 0.0254)
				+ " meters."); break;
		case 3: System.out.println(lengthIn + " inches is queal to " + (lengthIn * 0.0277778)
				+ " yards."); break;
		default: System.out.println("Invalid choice.");
		}
	}
}