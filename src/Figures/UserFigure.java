package Figures;

import java.awt.*;
import java.util.ArrayList;

public class UserFigure extends BasicFigure{
    private ArrayList<BasicFigure> figures = null;
    private String name = null;

    public  UserFigure(ArrayList<BasicFigure> figures, String name){
        this.figures = (ArrayList) figures.clone();
        this.name = name;
    }

    @Override
    public void draw(Graphics g) {
        for (int i = 0; i < figures.size(); i++) {
            setColor(Color.RED);
            figures.get(i).draw(g);
        }
    }

    public ArrayList<BasicFigure> getFigures(){
        return this.figures;
    }
}
