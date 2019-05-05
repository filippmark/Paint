package Figures;

import java.awt.*;
import java.util.ArrayList;

public class UserFigure extends BasicFigure{
    private ArrayList<BasicFigure> figures = null;
    private String name = null;

    public  UserFigure(ArrayList<BasicFigure> figures, String name){
        this.figures = figures;
        this.name = name;
    }

    @Override
    public void draw(Graphics g) {
        for (BasicFigure figure: figures) {
            figure.draw(g);
        }
    }
}
