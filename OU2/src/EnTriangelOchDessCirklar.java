import java.util.Scanner;

public class EnTriangelOchDessCirklar {
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Mata in triangelns tre sidor");
		
		//Läser in tre värden, triangelns tre sidor
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double c = sc.nextDouble();	
		
		//Räknar ut den omskrivna cirkelns radie samt den inskrivna cirkelns radie
		double rOut = calculateOutRadius(a,b,c);
		double rIn = calculateInRadius(a,b,c);
		
		//Ifall att något av värderna blir oändligt eller ickereelt innebär detta triangelns inmatade värden inte kan bilda en triangel
		//Detta händer t.ex. då summan av två sidor inte är större än den tredje sidan (triangelolikheten)
		if(!Double.isFinite(rOut) || !Double.isFinite(rIn) || rOut == 0.0 || rIn == 0.0) {
			System.out.println("Omöjlig triangel");
		}
		else{
			System.out.println("Den omskrivna cirkelns radie är " + rOut);
			System.out.println("Den inskrivna cirkelns radie är " + rIn);
		}
		
	}
	
	//Räknar ut radien av den omskrivna cirkeln med hjälp av tre in-värden, triangelns tre sidor
	//
	
	static double calculateOutRadius(double a, double b, double c){
		double r;
		
		//Använder sidorna för att räkna ut cirkelns halva omkrets
		//Matar in värderna i formeln r = a*b*c / 4 * sqrt( ( s * (s-a)(s-b)(s-c) ) ), där a,b,c är triangelns sidor och s halva omkretsen
		double s = calculateSemiCircumference(a,b,c);
			
		r = (a*b*c)/(4*Math.sqrt(s*(s-a)*(s-b)*(s-c)));
		
		return r;
	}
	
	//Räknar ut radien av den inskrivna cirkeln med hjälp av tre in-värden, triangelns tre sidor
	//Matar in värderna i formeln r = sqrt( ( (s-a)(s-b)(s-c) ) / s), där a,b,c är triangelns sidor och s halva omkretsen
	
	static double calculateInRadius(double a, double b, double c){
		double r;
		double s = calculateSemiCircumference(a,b,c);
		
		r = Math.sqrt(((s-a)*(s-b)*(s-c))/2);
		
		return r;
	}
	
	//Räknar ut halva omkretsen för en triangel med hjälp av tre in-värden, triangelns tre sidor1
	
	static double calculateSemiCircumference(double a, double b, double c) {
		double circum;
		
		circum = (a+b+c)/2;
		
		return circum;
	}

}


