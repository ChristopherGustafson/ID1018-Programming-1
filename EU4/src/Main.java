import java.util.Random;

public class Main {
	
	public static final Random r = new Random();
	
	public static void main(String[] args) {
		
		Point[] ps = {new Point("A", 1, 2), new Point("B", 3, 4), new Point("C", 5, 6) };
		
		LinkedPolyline p = new LinkedPolyline(ps);
		
		for(Point corner: p) {
			System.out.println(corner);
		}
		
		
		/*
		LinkedPolyline p = new LinkedPolyline(ps);
		
		Point[] c = p.getCorners();
		for(int i = 0; i < c.length; i++) {
			System.out.println(c[i]);
		}
		
		System.out.println(p);
		*/
		
		
		/*
		Polyline pl = null;
		pl = new VPolyline(ps);
		//pl = new LinkedPolyline(ps);
		
		System.out.println(pl);
		
		Point[] p = pl.getCorners();
		for(int i = 0; i < p.length; i++) {
			System.out.println(p[i]);
		}
		
		pl.add(new Point("C2", 10, 10));
		System.out.println("La till C2: " + pl);
		
		pl.addInFrontOf(new Point("B2", 4,  4), "C");
		System.out.println("La till B2 framför C1: " + pl);
		
		pl.remove("A");
		System.out.println("Tog bort A: " + pl);
	*/

		/*
		 
		 
		VPolyline[] vp = new VPolyline[6];
		for(int i = 0; i < vp.length; i++) {
			vp[i] = randomVPolyline();
			System.out.println(vp[i]);
		}
		
		System.out.println("Den kortaste gula polylinjen: " + Polylines.calcShortestYellowPolyline(vp));
		
		LinkedPolyline[] lp = new LinkedPolyline[6];
		for(int i = 0; i < lp.length; i++) {
			lp[i] = randomLinkedPolyline();
			System.out.println(lp[i]);
		}
		
		System.out.println("Den kortaste gula polylinjen: " + Polylines.calcShortestYellowPolyline(lp));
		
		Polyline[] p = new Polyline[6];
		for(int i = 0; i < 3; i++) {
			p[i] = randomVPolyline();
			System.out.println(p[i]);
		}
		for(int i = 3; i < 6; i++) {
			p[i] = randomLinkedPolyline();	
			System.out.println(p[i]);
		}
		
		System.out.println("Den kortaste gula polylinjen: " + Polylines.calcShortestYellowPolyline(p));
		*/
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
		public static LinkedPolyline randomLinkedPolyline() {
			
			LinkedPolyline poly = new LinkedPolyline();
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
		
		public static VPolyline randomVPolyline() {
			
			VPolyline poly = new VPolyline();
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
