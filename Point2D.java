/*This class deals with the construction of a single 2D point*/

public final class Point2D {

    private final double x;
    private final double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public final Point2D withX(double newX) {
        final Point2D point = new Point2D(newX, getY());
        return point;
    }

    public final Point2D withY(double newY) {
        final Point2D point = new Point2D(getX(), newY);
        return point;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }
}
