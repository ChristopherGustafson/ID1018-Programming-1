
public class PolylineTest {
	
	public static void main(String[] args) {
		
		Point[] p = {new Point("A", 2, 4),new Point("A2", 1, 1), new Point("B", 6, 6), new Point("C", 10, 8)};
		
		Polyline pl = new Polyline(p);
		System.out.println(pl);
		
		pl.remove("A2");
		System.out.println(pl);
		
		pl.addInFront(new Point("A2", 1, 1), "B");
		System.out.println(pl);
		
		pl.add(new Point("D", 10, 10));
		System.out.println(pl);
		
		
		/*
		Point[] p = {new Point("A", 2, 4), new Point("B", 6, 6), new Point("C", 10, 8)};
		Polyline pl = new Polyline(p);
		
		for(int i = 0; i < pl.getCorners().length; i++) {
			if(pl.iterator.existCorners()){
				System.out.println(pl.iterator.corner());
				pl.iterator.moveForward();
			}
		}
		*/
		
	

	}
}
