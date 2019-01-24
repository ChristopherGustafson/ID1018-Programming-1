
public interface Polyline extends java.lang.Iterable<Point>{

	Point[] getCorners();
	String getColor();
	int getWidth();
	double length();
	void setColor(String color);
	void setWidth(int width);
	public void add(Point p);
	void addInFrontOf(Point p, String name);
	void remove(String name);
	
	java.util.Iterator<Point> iterator();
}

/*

public static <T extends Polyline> T min(T[] polyline)

Vilken obejkt typ som helst - T
<T extends Polyline> Begr�nsar vilka objekt detta �r

Enum

Alla konstanter i ett interface �r public static final


*/