
public class Polylines {
	
	public static Polyline calcShortestYellowPolyline(Polyline[] polylines) {
		
		//Hitta den första gula polylinjen
		
		Polyline shortest = null;
		
		for(int i = 0; i < polylines.length; i++) {
			if(polylines[i].getColor().equals("Yellow")) {
				shortest = polylines[i];
				break;
			}
		}
		
		if(shortest != null) {
			
			for(int i = 0; i < polylines.length-1; i++) {
				if(polylines[i].getColor().equals("Yellow") && 
						polylines[i].length() < shortest.length()) {
					shortest = polylines[i];
				}
			}
		}
		
		return shortest;
		
	}
	
	

}
