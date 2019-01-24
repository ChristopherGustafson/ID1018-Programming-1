
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
<T extends Polyline> Begränsar vilka objekt detta är

Enum

Alla konstanter i ett interface är public static final


*/