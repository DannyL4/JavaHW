/*This class deals with a collection of Point2D objects
 that will be connected in a line. It utilizes both arrays and
 arraylists to construct a polyline object*/

import java.util.*;

public class Polyline implements Shape {

    private final Point2D[] polyPoints;

    public Polyline(ArrayList<Point2D> polyPoints) {
        this.polyPoints = new Point2D[polyPoints.size()];
        for(int i = 0; i < polyPoints.size(); i++)
            this.polyPoints[i] = polyPoints.get(i);
    }

    public Polyline(Point2D[] polyPoints) {
        this.polyPoints = new Point2D[polyPoints.length];
        for(int i = 0; i < polyPoints.length; i++)
            this.polyPoints[i] = polyPoints[i];
    }

    public void move(double dx, double dy) {
        for(int i = 0; i < this.polyPoints.length; i++) {
            this.polyPoints[i] = new Point2D(polyPoints[i].getX() + dx,
                    polyPoints[i].getY() + dy);
        }
    }

    public void draw (Canvas c) {
        for(int i = 0; i < polyPoints.length - 1; i++) {
            c.drawLine(polyPoints[i].getX(), polyPoints[i].getY()
                , polyPoints[i + 1].getX(), polyPoints[i + 1].getY());
        }
    }
}
