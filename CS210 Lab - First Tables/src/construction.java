import java.util.Map;
import java.util.HashMap;

public class construction {
	public static void main(String args[]){
		Database db = new Database();
		Table T1 = new Table();
		Table T2 = new Table();
		Row row1 = new Row();
		Row row2 = new Row();
		Row row3 = new Row();
		
		Row schemaRow = new Row();
		
		Row DemoRow1 = new Row();
		Row DemoRow2 = new Row();
		
		DemoRow1.put("x", null);
		DemoRow2.put("x", null);
		
		T2.put(null, DemoRow1);
		T2.put(null, DemoRow2);
		
		row1.put("A", 3);
		row2.put("A", 7);
		row3.put("A", 5);
		
		row1.put("B", "Cat");
		row2.put("B", "Dog");
		row3.put("B", "Fish");
		
		T1.put(3, row1);
		T1.put(7, row2);
		T1.put(5, row3);
		
		db.put("Example", T1);
		db.put("Demo", T2);
		
		System.out.println(T1);
		System.out.println(T2);
	}
}
