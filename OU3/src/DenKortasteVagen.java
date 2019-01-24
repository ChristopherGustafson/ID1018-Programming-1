
public class DenKortasteVagen {
	
	public static int[] mellanStationer(double[] a, double[][] b, double[] c) {
		
		int[] stations = new int[2];
		double minLength = a[0] + b[0][0] + c[0];
		double length;
		
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < c.length; j++) {
				length = a[i] + b[i][j] + c[j];
				
				if(length < minLength) {
					minLength = length;
					stations[0] = i+1;
					stations[1] = j+1;
					
				}	
			}	
		}
		
		return stations;
	}

	public static double langd(double[] a, double[][] b, double[] c) {
		
		int[] stations = new int[2];
		double minLength = a[0] + b[0][0] + c[0];
		double length;
		
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < c.length; j++) {
				
				length = a[i] + b[i][j] + c[j];
				
				if(length < minLength) {
					minLength = length;
					stations[0] = i+1;
					stations[1] = j+1;
				}
			}
		}
		
		return minLength;
	}
}
