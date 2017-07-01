
public class Point2D {

	private double x;
	private double y;
	
	// The constructor with no arguments simply initializes the
	// point to (0,0).
	public Point2D() {
		x = 0.0;
		y = 0.0;
	}
	
	// This constructor takes explicit x and y coordinates for
	// the point.
	public Point2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	// This constructor is a "copy constructor", which creates
	// the new Point2D as a duplicate of the given one.  This
	// helps avoid aliasing (see the Rectangle constructor for
	// an example).
	// Another way to accomplish this same thing is to mark the
	// data as "final", which would make Point2D objects immutable;
	// that is, once created, they can't change.
	public Point2D(Point2D p) {
		x = p.getX();
		y = p.getY();
	}

	///////////////////////////////////////////////
	//
	//	getters and setters
	//

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
}
