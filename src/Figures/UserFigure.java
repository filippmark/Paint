package Figures;

import java.awt.*;
import java.util.ArrayList;

public class UserFigure extends BasicFigure{
    private ArrayList<BasicFigure> figures = null;
    private String name = null;

    public UserFigure(){

    }

    public String getName() {
        return name;
    }

    public  UserFigure(ArrayList<BasicFigure> figures, String name){
        ArrayList<BasicFigure> figuresTemp = new ArrayList<BasicFigure>(figures);
        this.figures = new ArrayList<BasicFigure>();
        for(int i = 0; i < figuresTemp.size(); i++){
            BasicFigure figure = figures.get(i);
            name = figure.getClass().getCanonicalName();
            if (!name.equals("Figures.UserFigure")) {
                this.figures.add(figure);
            }else {
                UserFigure userF = (UserFigure) figures.get(i);
                ArrayList<BasicFigure> figs = (ArrayList<BasicFigure>) userF.getFigures().clone();
                for (int j = 0; j < userF.getFigures().size(); j++) {
                    this.getFigures().add(figs.get(j).clone());
                }
            }
        }
        this.name = name;
    }

    @Override
    public void draw(Graphics g) {
        for (int i = 0; i < figures.size(); i++) {
            setColor(Color.RED);
            figures.get(i).draw(g);
        }
    }

    @Override
    public ArrayList<Point> getPoints() {
        return null;
    }

    @Override
    public void setRefrPoint(Point refrPoint) {

    }

    @Override
    public Point getRefrPoint() {
        return null;
    }

    @Override
    public void refreshShape(Point point) {

    }

    public ArrayList<BasicFigure> getFigures(){
        return this.figures;
    }

    public void setFigures(ArrayList<BasicFigure> figures) {
        this.figures = figures;
    }
}
