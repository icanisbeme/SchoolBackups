public class GeometricSeries {
	public static void main(String[] args){
		System.out.println(calculateGeometricSeriesIteratively(2, 3, 4));
		System.out.println(calculateGeometricSeriesRecursively(2, 3, 4));
	}
	static double calculateGeometricSeriesIteratively(double a, double r, int n){
		double geometricTotal = a;
		for ( int i = 1; i <= n; i++){
			geometricTotal += a*Math.pow(r, i);
		}
		return geometricTotal;
	}
	static double calculateGeometricSeriesRecursively(double a, double r, int n){
		double totalOfSeries = 0;
		if (n == 0){
			return a;
		}
		else {
			return totalOfSeries += Math.pow(r, n) * a + calculateGeometricSeriesRecursively(a, r, n-1);
		}
	}
}