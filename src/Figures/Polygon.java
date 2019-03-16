package Figures;

import java.awt.*;

public class Polygon extends Polyline{

    public void draw(Graphics g){
        g.setColor(getColor());
        g.drawPolygon(getXs(), getYs(), points.size());
    }
}
