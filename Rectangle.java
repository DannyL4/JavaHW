/**This class deals with the construction of a rectangle and it's methods.  A single Point2D
 * object is used as the reference point defined as lowerleft. This is where the drawing
   of the rectangle is to begin*/

public class Rectangle implements Shape {

    private Point2D lowerLeft;
    private double width;
    private double height;

    public Rectangle(Point2D lowerLeft, double width, double height) {
        this.lowerLeft = new Point2D(lowerLeft.getX(), lowerLeft.getY());
        this.width = width;
        this.height = height;
    }

    public Rectangle(double x1, double y1, double x2, double y2) {
        lowerLeft = new Point2D(Math.min(x1, x2), Math.min(y1, y2));
        width = Math.abs(x2 - x1);
        height = Math.abs(y2 - y1);
    }

    public Rectangle(Point2D p1, Point2D p2) {
        this(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }

    public void move(double dx, double dy) {
        lowerLeft = new Point2D( dx + lowerLeft.getX(), dy + lowerLeft.getY());
       /* System.out.format("\nOriginal lower left point located at (%.1f, %.1f).", lowerLeft.getX(), lowerLeft.getY());
        System.out.format("\nX coordinate and Y coordinate moved (%.1f, %.1f) respectively." , dx, dy);
        System.out.format("\nAfter move, lower left corner of rectangle  is at (%.1f, %.1f).\n\n" ,
                newLowerLeft.getX(), newLowerLeft.getY());*/

    }
    public void draw(Canvas c) {
        c.drawLine(lowerLeft.getX(), lowerLeft.getY(),
                lowerLeft.getX() + width, lowerLeft.getY());
        c.drawLine(lowerLeft.getX() + width, lowerLeft.getY(),
                lowerLeft.getX() + width, lowerLeft.getY() + height);
        c.drawLine(lowerLeft.getX() + width, lowerLeft.getY() + height,
                lowerLeft.getX(), lowerLeft.getY() + height);
        c.drawLine(lowerLeft.getX(), lowerLeft.getY() + height,
                lowerLeft.getX(), lowerLeft.getY());
    }

    public Point2D getLowerLeft() {
        return lowerLeft;
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

}
