
public class Polyline {

	private Point[] corners;
	private String color = "black";
	private int width = 1;
	public PolylineIterator iterator;
	
	public Polyline() {
		this.corners = new Point[0];
		iterator = new PolylineIterator();
	}
	
	public Polyline(Point[] corners) {
		this.corners = new Point[corners.length];
		for(int i = 0; i < corners.length; i++) {
			this.corners[i] = new Point(corners[i]);
		}
		iterator = new PolylineIterator();
	}
	
	public String toString() {
		String s = "[ ";
		
		for(int i = 0; i < this.corners.length; i++) {
			s = s + this.corners[i] + " " ;
		}
		
		s = s + ", " + this.color + " , " + this.width + " ]";
		
		return s;
		
	}
	
	public Point[] getCorners() {
		
		return this.corners.clone();	
	}
	
	public String getColor() {
		return this.color;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public double length() {
		double l = 0;
		int j = 1;
		for(int i = 0; i < this.corners.length-1; i++) {
			l += this.corners[i].dist(corners[j]);
			j++;
		}
		
		return l;
		
	}
	
	public void add(Point corner) {
		Point[] c = new Point[this.corners.length +1];
		int i;
		for(i = 0; i < this.corners.length; i++) {
			c[i] = new Point (this.corners[i]); 
		}
		c[i] = new Point(corner);
		
		this.corners = c;
	}
	
	public void addInFront (Point corner, String name) {
		
		int index = 0;
		for(int i = 0; i < this.corners.length; i++) {
			if (this.corners[i].getName().equals(name)) {
				index = i;
				break;
			}
		}
		
		Point[] c = new Point[this.corners.length + 1];
		
		int newPointPlaced = 0;
		for(int i = 0; i < c.length; i++) {
			if(i == index) {
				c[i] = new Point(corner);
				newPointPlaced = 1;
				continue;
			}
			c[i] = this.corners[i-newPointPlaced];
		}
		
		this.corners = c;
		
	}
	
	public void remove(String name) {
		
		/*
		int index = 0;
		for(int i = 0; i < this.corners.length; i++) {
			if (this.corners[i].getName() == name) {
				index = i;
				break;
			}
		}
		
		Point[] c = new Point[this.corners.length - 1];
		
		for(int i = 0; i < c.length; i++) {
			if(i == index) {
				
			}
			c[i] = this.corners[i];
		}
		
		this.corners = c;
		*/
		
		int i = 0;
		Point[] c = new Point[this.corners.length - 1];
		
		while(this.corners[i].getName() != name) {
			c[i] = this.corners[i];
			i++;
		}
		while(i < c.length) {
			c[i] = this.corners[i+1];
			i++;
		}
		
		this.corners = c;
	}
	
	public class PolylineIterator{
		private int current = -1;
		
		public PolylineIterator() {
			if(Polyline.this.corners.length > 0) {
				current = 0;
			}
		}
		
		public boolean existCorners() {
			return current != -1;
		}
		
		public Point corner() throws java.util.NoSuchElementException{
			if(!this.existCorners()) {
				throw new java.util.NoSuchElementException("End of iteration");
			}
			
			Point corner = Polyline.this.corners[current];
			
			return corner;
		}
		
		public void moveForward() {
			if(current >= 0 && current < Polyline.this.corners.length-1) {
				current++;
			}
			else {
				current = -1;
			}
		}
	}
}
