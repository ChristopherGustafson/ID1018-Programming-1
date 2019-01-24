import java.util.Random;

public class ChoosePolyline {

	public static final Random r = new Random();
	public static final int AMOUNT_POLYLINES = 10;
	
	public static void main(String[] args) {

		//skapa ett antal slumpmässiga polylinjer
		Polyline[] pl = new Polyline[AMOUNT_POLYLINES];
		
		for(int i = 0; i < AMOUNT_POLYLINES; i++) {
			pl[i] = randomPolyline();
			System.out.println(pl[i]);
			System.out.println(pl[i].length());
		}
		
		//bestäm den kortaste av de gula polylinjerna
		Polyline shortestYellow = pl[0];
		for(int i = 0; i < AMOUNT_POLYLINES; i++) {
			if(pl[i].getColor().equals("Yellow")) {
				if(pl[i].length() < shortestYellow.length()) {
					shortestYellow = pl[i];
				}
			}
		}
		
		//visa den valda plylinjen
		System.out.println("Den kortaste av de gula polylinjerna: " + shortestYellow);
	}
	
	//Returnerar en punkt med ett slumpmässigt namn, siom är en stor bokstav i det
	//engelska alfabetet, och slumpmässiga koordinater
	public static Point randomPoint() {
		
		String n = "" + (char) (65 + r.nextInt(26));
		int x = r.nextInt(11);
		int y = r.nextInt(11);
		
		return new Point(n, x, y);
	}
	
	//Returnerar en slumpmässig polylinje, vars färg antingen är blå, röd eller gul.
	//
	public static Polyline randomPolyline() {
		
		Polyline poly = new Polyline();
		int corners = 2 + r.nextInt(6);
		boolean[] nameChosen = new boolean[26];
		
		for(int i = 0; i < corners; i++) {
			Point p = randomPoint();
			
			while(nameChosen[(int)p.getName().charAt(0)-65]) {
				p = randomPoint();
			}
			
			nameChosen[(int)p.getName().charAt(0)-65] = true;
			poly.add(p);
		}
		
		int i = r.nextInt(3);
		switch(i){
		
			case 0: poly.setColor("Blue");
					break;
			case 1: poly.setColor("Red");
					break;
			case 2: poly.setColor("Yellow");
					break;
		}
		
		return poly;
			
	}
}

