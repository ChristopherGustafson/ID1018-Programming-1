import java.util.Iterator;

public class VPolyline implements Polyline{

	private Point[] corners;
	private String color = "black";
	private int width = 1;
	
	public VPolyline() {
		this.corners = new Point[0];
	}
	
	public VPolyline(Point[] corners) {
		this.corners = new Point[corners.length];
		for(int i = 0; i < corners.length; i++) {
			this.corners[i] = new Point(corners[i]);
		}
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
	
	public double length() {
		double l = 0;
		int j = 1;
		for(int i = 0; i < this.corners.length-1; i++) {
			l += this.corners[i].dist(corners[j]);
			j++;
		}
		
		return l;
	}	
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setWidth(int width) {
		this.width = width;
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
	
	public void addInFrontOf (Point corner, String name) {
		
		int index = 0;
		for(int i = 0; i < this.corners.length; i++) {
			if (this.corners[i].getName() == name) {
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

	public Iterator<Point> iterator() {
		Iterator<Point> it = new Iterator<Point>() {
			
			int current = 0;

			@Override
			public boolean hasNext() {
				if(current+1 < corners.length) {
					return true;
				}
				else {
					return false;
				}
			}

			@Override
			public Point next() {
				Point p = corners[current++];
				return p;
			}
			
		};
		return it;
	}
}