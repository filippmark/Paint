package Figures;

import java.awt.*;
import java.util.ArrayList;

public class Circle extends Ellipse {
    int topX, topY;


    public Circle(){

    }

    public Circle(Point center, int radius){
        super(new Point(center.x - radius, center.y - radius), radius*2, radius*2);
    }

    @Override
    public void draw(Graphics g){
        g.setColor(getColor());

        int width = getBottomRight().x - getTopLeft().x;
        int height = getBottomRight().y - getTopLeft().y;
        int d = Math.min(width, height);

        Point fixedPoint = getFixedPoint();
        topX = fixedPoint.x + d * (int)Math.signum(getTopLeft().x - fixedPoint.x);
        topY = fixedPoint.y + d * (int)Math.signum(getTopLeft().y - fixedPoint.y);

        g.drawOval(topX, topY, d, d);
    }

    public ArrayList<Point> getPoints() {
        ArrayList<Point> points = new ArrayList<Point>();
        points.add(new Point(topX, topY));
        return points;
    }
}

