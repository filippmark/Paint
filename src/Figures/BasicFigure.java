package Figures;

import java.awt.*;

public class BasicFigure {
    private Color color;

    public void BasicFigure(){
        this.color = Color.RED;
    }

    public Color getColor(){
        return this.color;
    }

    public void setColor(Color color){
        this.color = color;
    }
}
