import java.util.Scanner;

public class BestamDenKortasteVagen {
	
public static void main(String[] args){
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Hur m�nga stationer finns i zon 2?");
		int i = sc.nextInt();
		
		System.out.println("Hur m�nga stationer finns i zon 3?");
		int j = sc.nextInt();
		
		System.out.println("Ange l�ngden mellan X och stationerna i zon 2:");
		
		double[] a = new double[i];
		for(int t = 0; t < i; t++){
			a[t] = sc.nextDouble();
		}
		
		System.out.println("Ange l�ngden mellan Y och stationerna i zon 3:");
		
		double[] c = new double[j];
		for(int t = 0; t < j; t++){
			c[t] = sc.nextDouble();
		}
		
		double[][] b = new double[i][j];
		
		for(int t = 0; t < i; t++){
			
			for(int s = 0; s < j; s++){
				System.out.println("Ange avst�ndet mellan U"+(t+1)+" och V"+(s+1));
				b[t][s] = sc.nextDouble();
			}
		}
		
		System.out.println("Den kortaste v�gen �r " + DenKortasteVagen.langd(a, b, c));
		System.out.println("V�gen g�r genom U" + DenKortasteVagen.mellanStationer(a, b, c)[0]
								+ " och V" + DenKortasteVagen.mellanStationer(a, b, c)[1]);
		
	}

}
