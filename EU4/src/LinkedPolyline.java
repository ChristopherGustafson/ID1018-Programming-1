import java.util.Iterator;

public class LinkedPolyline implements Polyline{
	
	private static class Node{
		public Point corner;
		public Node nextNode;
		
		public Node(Point corner) {
			this.corner = corner;
			nextNode = null;
		}
	}
	
	private Node corner;
	private String color = "black";
	private int width = 1;
	
	public LinkedPolyline() {
		this.corner = null;
	}
	
	public LinkedPolyline(Point[] corners) {
		if(corners.length > 0) {
			Node n = new Node(new Point (corners[0]));
			this.corner = n;
			int pos = 1;
			
			while(pos < corners.length) {
				n.nextNode = new Node(corners[pos++]);
				n = n.nextNode;	
			}	
		}
	}
	
	public String toString() {
		String s = "[";
		Node n = corner;
		
		while(n != null) {
			s += n.corner + ", ";
			n = n.nextNode;
		}
		
		s = s + ", " + this.color + " , " + this.width + " ]";
		
		return s;
	}

	@Override
	public Point[] getCorners() {
		
		if(corner.corner != null) {
			Point[] p = {corner.corner};
			Node n = corner.nextNode;
			Point[] pTemp;
			while(n != null) {
				pTemp = new Point[p.length+1];
				
				int i = 0;
				while(i < p.length) {
					pTemp[i] = p[i++];
				}
				pTemp[i] = n.corner;
				p = pTemp;
				n = n.nextNode;
			}
			
			return p;
		}
		else {
			return null;
		}
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public double length() {
		double l = 0;
		Node n = corner;
		
		while(n.nextNode != null) {
			l += n.corner.dist(n.nextNode.corner);
			n = n.nextNode;
		}
		
		return l;
	}

	@Override
	public void setColor(String color) {
		this.color = color;
		
	}

	@Override
	public void setWidth(int width) {
		this.width = width;
		
	}

	public void add(Point p) {
		Node n = corner;
		if(corner == null) {
			corner = new Node(new Point(p));
		}
		else {
			while(n.nextNode != null) {
				n = n.nextNode;
			}
			n.nextNode = new Node(new Point(p));
		}
	}

	public void addInFrontOf(Point p, String name) {
		Node n = corner;
		
		if(n.corner.getName().equals(name)) {
			corner = new Node(p);
			corner.nextNode = n;
		}
		else {
			
			while(n != null) {
				if(n.nextNode.corner.getName().equals(name)) {
					Node newN = new Node(p);
					newN.nextNode = n.nextNode;
					n.nextNode = newN;
					break;
				}
				n = n.nextNode;
				
			}
		}
	}

	public void remove(String name) {
		Node n = corner;
		
		if(n.corner.getName().equals(name)) {
			corner = n.nextNode;
		}
		else {
			while(n != null) {
				if(n.nextNode.corner.getName().equals(name)) {
					n.nextNode = n.nextNode.nextNode;
				}
			}
		}
		
	}

	@Override
	public Iterator<Point> iterator() {
		Iterator<Point> it = new Iterator<Point>() {

			Node current = corner;
			@Override
			public boolean hasNext() {
				
				if(current.nextNode != null) {
					return true;
				}
				else {
					return false;
				}
			}

			@Override
			public Point next() {
				current = corner.nextNode;
				return current.corner;
			}
			
		};
		return it;
	}
	
	

}
