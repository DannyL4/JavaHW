
public class Rectangle {

	// This is the representation we decided on in class.  We'll
	// represent a Rectangle by keeping the lower left corner,
	// and a width and height.
	private Point2D lowerLeft;
	private double	width;
	private double	height;
	
	// This constructor takes the lower left corner, width,
	// and height, and simply stores them.
	public Rectangle(Point2D ll, double w, double h) {
		// Note that we store a copy of the point.  Otherwise,
		// the caller could change the point after creating
		// the rectangle, and inadvertantly move the rectangle.
		lowerLeft = new Point2D(ll);
		width = w;
		height = h;
	}
	
	// This constructor takes the x and y coordinates of two points
	// that define the Rectangle.  Note that we have no guarantee which
	// of x1 or x2 is to the left, or which of y1 or y2 is the lower
	// one, so we have to use Math.min() and Math.abs() to ensure
	// that we actually store the lower left corner, and have positive
	// values for the width and height.
	public Rectangle(double x1, double y1, double x2, double y2) {
		lowerLeft = new Point2D(Math.min(x1, x2), Math.min(y1,  y2));
		width = Math.abs(x2-x1);
		height = Math.abs(y2-y1);
	}

	// This constructor takes two points.  Since we don't know which
	// corners of the rectangle these points represent, we need to
	// perform the same logic as the above constructor.  The best
	// way to do that is to call that constructor from this one.
	// Note the use of "this" to call the other constructor.
	public Rectangle(Point2D p1, Point2D p2) {
		// Calling one constructor from another is perfectly legit,
		// so long as it's the first line of code in the constructor.
		this(p1.getX(), p1.getY(), p2.getX(), p2.getY());
	}

	//////////////////////////////////////
	//
	//	getters and setters
	//

	public Point2D getLowerLeft() {
		return lowerLeft;
	}

	public void setLowerLeft(Point2D lowerLeft) {
		// As with the first constructor, we create a copy of
		// the point rather than storing an alias to the one
		// we're given here.  Otherwise, the caller could
		// Inadvertently more the Rectangle by modifying the
		// point we were given here.
		this.lowerLeft = new Point2D(lowerLeft);
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	// Draw this rectangle on the given Canvas object by calling
	// drawLine 4 times, one for each edge of the Rectangle.
	public void draw(Canvas c) {
		c.drawLine(lowerLeft.getX(),       lowerLeft.getY(),
				   lowerLeft.getX()+width, lowerLeft.getY());
		c.drawLine(lowerLeft.getX()+width, lowerLeft.getY(),
				   lowerLeft.getX()+width, lowerLeft.getY()+height);
		c.drawLine(lowerLeft.getX()+width, lowerLeft.getY()+height,
				   lowerLeft.getX(),       lowerLeft.getY()+height);
		c.drawLine(lowerLeft.getX(),       lowerLeft.getY()+height,
				   lowerLeft.getX(),       lowerLeft.getY());
	}
}
