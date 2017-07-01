import java.util.ArrayList;

public class GraphicsTestA3 {

	public static void main(String[] args) {
		
		Canvas c = new Canvas();
		
		// Create a Rectangle, draw it, modify the point that was
		// used to create it, and draw it again.  This tests to
		// make sure that the point is copied, not aliased.
		Point2D p1 = new Point2D(0.0, 0.0);
		Rectangle r1 = new Rectangle(p1, 1.0, 1.0);
		System.out.println("Before moving p1:");
		r1.draw(c);	
		p1.setX(5.0);
		p1.setY(5.0);
		System.out.println("After moving p1:");
		r1.draw(c);
		System.out.println();

		// Create another rectangle using two points.  Note that p1
		// has already changed to (5,5), so this also test to ensure
		// the constructor computes the lower-left corner.  Then
		// we change both points to ensure that the Rectangle object
		// is not modified.
		Point2D p2 = new Point2D(1.0, 1.0);
		Rectangle r2 = new Rectangle(p1, p2);
		System.out.println("Before moving p1 and p2:");
		r2.draw(c);	
		p1.setX(1.0);
		p1.setY(1.0);
		p2.setX(0.0);
		p2.setY(0.0);
		System.out.println("After moving p1 and p2:");
		r2.draw(c);
		System.out.println();

		// Create a circle, draw it, and then move the original point
		// that specified the center.
		Point2D p3 = new Point2D(2.0, 2.0);
		System.out.println("Before moving p3:");
		Circle c1 = new Circle(p3, 1.0);
		c1.draw(c);
		p3.setX(1.0);
		p3.setY(10.0);
		System.out.println("After moving p3:");
		c1.draw(c);
		System.out.println();
		
		// Create a polyline from an ArrayList.  Then (1) change a
		// point in the original ArrayList to make sure the ctor
		// doesn't just store the original ArrayList, and (2) change
		// one point to make sure the ctor clones the points themselves
		// as well.
		ArrayList<Point2D> pts = new ArrayList<Point2D>(3);
		pts.add(new Point2D(1,1));
		pts.add(new Point2D(2,2));
		pts.add(new Point2D(3,1));
		Polyline poly1 = new Polyline(pts);
		System.out.println("Before being nasty:");
		poly1.draw(c);
		System.out.println();

		pts.set(1, new Point2D(2,3));
		System.out.println("After changing ArrayList[1]");
		poly1.draw(c);
		System.out.println();

		pts.get(1).setY(3);
		System.out.println("After changing ArrayList[1].y:");
		poly1.draw(c);
		System.out.println();
	}
}
