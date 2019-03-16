package Figures;

import java.awt.*;

public abstract class BasicFigure {
    private Color color = Color.GREEN;

    public Color getColor(){
        return this.color;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public abstract void draw(Graphics g);
}
