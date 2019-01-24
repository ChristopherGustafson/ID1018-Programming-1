import java.util.Locale;
import java.util.Scanner;

public class Temperaturer {
	
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.US);
		
		//Antalet veckor som ska matas in
		System.out.println("Antalet veckor: ");
		int antalVeckor = sc.nextInt()+1;
		
		//Antalet m�tningar per vecka som ska matas in
		System.out.println("Antalet m�tningar: ");
		int antalMatningar = sc.nextInt()+1;
		
		//D�r temperaturerna lagras
		double[][] temp = new double[antalVeckor][antalMatningar];
		
		
		//Mata in temperaturerna
		for(int vecka = 1; vecka < antalVeckor; vecka++){
			System.out.println("Temperaturer vecka " + vecka);
			
			for(int matning = 1; matning < antalMatningar; matning++){
				temp[vecka][matning] = sc.nextDouble();
			}
		}
		
		double[] minT = new double[antalVeckor];
		double[] maxT = new double[antalVeckor];
		double[] sumT = new double[antalVeckor];
		double[] medelT = new double[antalVeckor];
		
		//R�knar ut den minsta temperaturen varje vecka och sparar dessa i en ny vektor minTemp
		for(int vecka = 1; vecka < antalVeckor; vecka++){
			
			double min = temp[vecka][1];
			
			for(int matning = 2; matning < antalMatningar; matning++){
				
				if(temp[vecka][matning] < min){
					min = temp[vecka][matning];
				}	
			}
			minT[vecka] = min;
		}
		
		//R�knar ut den st�rsta temperaturen varje vecka och sparar dessa i en ny vektor maxTemp
		for(int vecka = 1; vecka < antalVeckor; vecka++){
			
			double max = temp[vecka][1];
			
			for(int matning = 2; matning < antalMatningar; matning++){
				
				if(temp[vecka][matning] > max){
					max = temp[vecka][matning];
				}
			}
			maxT[vecka] = max;
		}
		
		//R�knar ut medel temperaturen varje vecka och sparar dessa i en ny vektor medelTemp
		for(int vecka = 1; vecka < antalVeckor; vecka++){
			
			double sum = 0;
			
			for(int matning = 1; matning < antalMatningar; matning++){
				
				sum += temp[vecka][matning];
			}
			sumT[vecka] = sum;
			medelT[vecka] = sum/(antalMatningar-1);
		}
		
		//Skriver ut h�gsta, l�gsta och medeltemperaturen f�r varje vecka
		for(int vecka = 1; vecka < antalVeckor; vecka++) {
			System.out.println("F�r vecka " + vecka);
			System.out.print("l�gsta temperatur: " + minT[vecka]);
			System.out.print(", h�gsta temperatur: " + maxT[vecka]);
			System.out.print(", summan av temperaturerna: " + sumT[vecka]);
			System.out.println(", medeltemperatur: " + medelT[vecka]);
		}
		
		double minTemp = minT[1];
		double maxTemp = maxT[1];
		double medelTemp = medelT[1];
		
		for(int vecka = 2; vecka < antalVeckor; vecka++) {
			if(minT[vecka] < minTemp) {
				minTemp = minT[vecka];
			}
		}
		
		for(int vecka = 2; vecka < antalVeckor; vecka++) {
			if(maxT[vecka] > maxTemp) {
				maxTemp = maxT[vecka];
			}
		}
		
		double sumTemp = 0;
		
		for(int vecka = 1; vecka < antalVeckor; vecka++) 
			sumTemp += medelT[vecka];
		
		
		medelTemp = sumTemp/(antalVeckor-1);
		
		System.out.println("Den totalt l�gsta temperaturen: " + minTemp);
		System.out.println("Den totalt h�gsta temperaturen: " + maxTemp);
		System.out.println("Den totala medeltemperaturen: " + medelTemp);
		
	}

}
