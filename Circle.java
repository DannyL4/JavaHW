/*This class deals with the construction of a circle and it's
* methods*/
public class Circle implements Shape {

    private Point2D center;
    private double radius;

    public Circle(Point2D center, double radius) {
        this.center = new Point2D(center.getX(), center.getY());
        this.radius = radius;
    }

    public final void move(double dx, double dy) {
        center = new Point2D(dx + center.getX(), dy + center.getY());
    }

    public void draw(Canvas c) {
        c.drawArc(center.getX(), center.getY(),
                getRadius(), 0.00, 360.00);
    }

    public Point2D getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}

