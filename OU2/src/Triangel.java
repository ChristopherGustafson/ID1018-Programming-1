import java.util.Scanner;

public class Triangel {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Mata in triangelns sidor");
		
		double sideA = sc.nextDouble();
		double sideB = sc.nextDouble();
		double sideC = sc.nextDouble();
		
		System.out.println("Mat in triangelns vinklar");
		
		double angleA = sc.nextDouble();
		double angleB = sc.nextDouble();
		double angleC = sc.nextDouble();
		
		//Tillkalla de uträkningar som efterfrågas
		
		
	}
	
	//Räknar ut arean av en triangel genom att ta in två värden, triangelns bas och höjd
	
	static double calculateArea(double width, double height) {
		double a;
		a = (width*height)/2;
		return a;
	}
	
	//Räknar ut omkretsen av en triangel genom att ta in tre värden, triangelns tre sidor
	
	static double calculateCircumference(double a, double b, double c) {
		double circum;
		circum = a+b+c;
		return circum;
	}
	
	//Räknar ut en triangels tre bisektriser i form av en vektor genom att ta in sex värden, triangelns sidor och vinklar
	
	static double[] calculateAllBisectors(double sideA, double sideB, double sideC,
										double angleA, double angleB, double angleC) {
		
		double[] bisectors = new double[3];
		
		bisectors[0] = calculateBisector(angleA, sideA, sideC);
		bisectors[1] = calculateBisector(angleB, sideA, sideB);
		bisectors[2] = calculateBisector(angleC, sideC, sideB);
		
		return bisectors;
	}	
	
	//Räknar ut bisektrisen av en triangel, genom att ta in en vinkel och de två intillligande sidorna
	
	static double calculateBisector(double alfa, double b, double c) {
		double bisector;
		bisector = (2*b*c*Math.cos(alfa/2))/(b+c);
		return bisector;
	}

}
