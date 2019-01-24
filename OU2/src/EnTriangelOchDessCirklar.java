import java.util.Scanner;

public class EnTriangelOchDessCirklar {
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Mata in triangelns tre sidor");
		
		//L�ser in tre v�rden, triangelns tre sidor
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double c = sc.nextDouble();	
		
		//R�knar ut den omskrivna cirkelns radie samt den inskrivna cirkelns radie
		double rOut = calculateOutRadius(a,b,c);
		double rIn = calculateInRadius(a,b,c);
		
		//Ifall att n�got av v�rderna blir o�ndligt eller ickereelt inneb�r detta triangelns inmatade v�rden inte kan bilda en triangel
		//Detta h�nder t.ex. d� summan av tv� sidor inte �r st�rre �n den tredje sidan (triangelolikheten)
		if(!Double.isFinite(rOut) || !Double.isFinite(rIn) || rOut == 0.0 || rIn == 0.0) {
			System.out.println("Om�jlig triangel");
		}
		else{
			System.out.println("Den omskrivna cirkelns radie �r " + rOut);
			System.out.println("Den inskrivna cirkelns radie �r " + rIn);
		}
		
	}
	
	//R�knar ut radien av den omskrivna cirkeln med hj�lp av tre in-v�rden, triangelns tre sidor
	//
	
	static double calculateOutRadius(double a, double b, double c){
		double r;
		
		//Anv�nder sidorna f�r att r�kna ut cirkelns halva omkrets
		//Matar in v�rderna i formeln r = a*b*c / 4 * sqrt( ( s * (s-a)(s-b)(s-c) ) ), d�r a,b,c �r triangelns sidor och s halva omkretsen
		double s = calculateSemiCircumference(a,b,c);
			
		r = (a*b*c)/(4*Math.sqrt(s*(s-a)*(s-b)*(s-c)));
		
		return r;
	}
	
	//R�knar ut radien av den inskrivna cirkeln med hj�lp av tre in-v�rden, triangelns tre sidor
	//Matar in v�rderna i formeln r = sqrt( ( (s-a)(s-b)(s-c) ) / s), d�r a,b,c �r triangelns sidor och s halva omkretsen
	
	static double calculateInRadius(double a, double b, double c){
		double r;
		double s = calculateSemiCircumference(a,b,c);
		
		r = Math.sqrt(((s-a)*(s-b)*(s-c))/2);
		
		return r;
	}
	
	//R�knar ut halva omkretsen f�r en triangel med hj�lp av tre in-v�rden, triangelns tre sidor1
	
	static double calculateSemiCircumference(double a, double b, double c) {
		double circum;
		
		circum = (a+b+c)/2;
		
		return circum;
	}

}


