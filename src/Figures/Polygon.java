package Figures;

import java.awt.*;

public class Polygon extends Polyline{

    public Polygon(){}

    public void draw(Graphics g){
        g.setColor(getColor());
        g.drawPolygon(getXs(), getYs(), getPoints().size());
    }
}
