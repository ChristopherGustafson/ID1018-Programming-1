
public class Point {
	
	private String name;
	private double x;
	private double y;
	
	Point(String name, double x, double y){
		this.name = name; 
		this.x = x;
		this.y = y;
	}
	
	Point(Point p){
		this.name = p.name;
		this.x = p.x;
		this.y = p.y;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public double dist(Point p) {
		return (Math.sqrt((p.getX()-this.x)*(p.getX()-this.x)+
						 (p.getY()-this.y)*(p.getY()-this.y)));
	}
	
	public String toString() {
		String s = "(" + this.name + ": " + this.x + ", " + this.y + ")";
		return s;
	}
}
