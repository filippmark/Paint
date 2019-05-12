package MouseListeners;

import Buttons.ShapeDrawer;
import Figures.*;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UserFigureMouseListener extends FigureMouseListener{
    UserFigure userFigure;
    boolean flag = true;

    public UserFigureMouseListener(ShapeDrawer shapeDrawer, UserFigure userFigure) {
        super(shapeDrawer);
        this.userFigure = userFigure;
    }

    public void mousePressed(MouseEvent e) {
        ArrayList<BasicFigure> figures = new ArrayList<BasicFigure>(userFigure.getFigures());
        ArrayList<BasicFigure> newfigs = new ArrayList<BasicFigure>();
        BasicFigure first = figures.get(0);
        Point oldCoords = first.getPoints().get(0);
        String name = null;
        System.out.println("-----------------");
        for (int i = 0; i < figures.size(); i++) {
            BasicFigure figure = figures.get(i);
            Point point = figure.getPoints().get(0);
            name = figure.getClass().getCanonicalName();
            System.out.println(name);
            int deltaX = oldCoords.x  - point.x;
            int deltaY = oldCoords.y - point.y;
            Point newPoint = new Point(e.getX() - deltaX, e.getY() - deltaY);
            switch (name){
                case "Figures.Ellipse":
                    Ellipse ellipse;
                    if ((point.x == oldCoords.x) && (point.y == oldCoords.y)){
                        ellipse = new Ellipse(new Point(e), 2, 1);
                        int distanceX = figure.getRefrPoint().x - oldCoords.x;
                        int distanceY = figure.getRefrPoint().y - oldCoords.y;
                        Point refP = new Point(newPoint.x + distanceX, newPoint.y + distanceY);
                        ellipse.refreshShape(refP);
                        ellipse.setRefrPoint(refP);
                        ellipse.setDistanceX(distanceX);
                        ellipse.setDistanceY(distanceY);
                    }else {
                        ellipse = new Ellipse(newPoint, 2, 1);
                        int distanceX = figure.getRefrPoint().x - point.x;
                        int distanceY = figure.getRefrPoint().y - point.y;
                        Point refP = new Point(newPoint.x + distanceX, newPoint.y + distanceY);
                        ellipse.refreshShape(refP);
                        ellipse.setRefrPoint(refP);
                        ellipse.setDistanceX(distanceX);
                        ellipse.setDistanceY(distanceY);
                    }
                    ellipse.setDeltaX(deltaX);
                    ellipse.setDeltaY(deltaY);
                    newfigs.add(ellipse);
                        break;
                case "Figures.Circle":
                    Circle circle;
                    if ((point.x == oldCoords.x) && (point.y == oldCoords.y)){
                        circle = new Circle(new Point(e), 3);
                        int distanceX = figure.getRefrPoint().x - oldCoords.x;
                        int distanceY = figure.getRefrPoint().y - oldCoords.y;
                        Point refP = new Point(newPoint.x + distanceX, newPoint.y + distanceY);
                        circle.refreshShape(refP);
                        circle.setRefrPoint(refP);
                        circle.setDistanceX(distanceX);
                        circle.setDistanceY(distanceY);
                    } else {
                        circle = new Circle(newPoint, 3);
                        int distanceX = figure.getRefrPoint().x - point.x;
                        int distanceY = figure.getRefrPoint().y - point.y;
                        Point refP = new Point(newPoint.x + distanceX, newPoint.y + distanceY);
                        circle.refreshShape(refP);
                        circle.setRefrPoint(refP);
                        circle.setDistanceX(distanceX);
                        circle.setDistanceY(distanceY);
                    }
                    circle.setDeltaX(deltaX);
                    circle.setDeltaY(deltaY);
                    newfigs.add(circle);
                        break;
                case "Figures.Line":
                    Line line;
                    if ((point.x == oldCoords.x) && (point.y == oldCoords.y)) {
                        line = new Line(new Point(e));
                        int distanceX = figure.getRefrPoint().x - oldCoords.x;
                        int distanceY = figure.getRefrPoint().y - oldCoords.y;
                        Point refP = new Point(newPoint.x + distanceX, newPoint.y + distanceY);
                        line.refreshShape(refP);
                        line.setRefrPoint(refP);
                        line.setDistanceX(distanceX);
                        line.setDistanceY(distanceY);
                    } else {
                        line = new Line(newPoint);
                        int distanceX = figure.getRefrPoint().x - point.x;
                        int distanceY = figure.getRefrPoint().y - point.y;
                        Point refP = new Point(newPoint.x + distanceX, newPoint.y + distanceY);
                        line.refreshShape(refP);
                        line.setRefrPoint(refP);
                        line.setDistanceX(distanceX);
                        line.setDistanceY(distanceY);
                    }
                    line.setDeltaX(deltaX);
                    line.setDeltaY(deltaY);
                    newfigs.add(line);
                    break;
                case "Figures.Square":
                    Square square;
                    if ((point.x == oldCoords.x) && (point.y == oldCoords.y)) {
                        square = new Square(new Point(e), 2);
                        int distanceX = figure.getRefrPoint().x - oldCoords.x;
                        int distanceY = figure.getRefrPoint().y - oldCoords.y;
                        Point refP = new Point(newPoint.x + distanceX, newPoint.y + distanceY);
                        square.refreshShape(refP);
                        square.setRefrPoint(refP);
                        square.setDistanceX(distanceX);
                        square.setDistanceY(distanceY);
                    }else {
                        square = new Square(newPoint, 2);
                        int distanceX = figure.getRefrPoint().x - point.x;
                        int distanceY = figure.getRefrPoint().y - point.y;
                        Point refP = new Point(newPoint.x + distanceX, newPoint.y + distanceY);
                        square.refreshShape(refP);
                        square.setRefrPoint(refP);
                        square.setDistanceX(distanceX);
                        square.setDistanceY(distanceY);
                    }
                    square.setDeltaX(deltaX);
                    square.setDeltaY(deltaY);
                    newfigs.add(square);
                        break;
                case "Figures.Rectangle":
                    Rectangle rectangle;
                    if ((point.x == oldCoords.x) && (point.y == oldCoords.y)) {
                        rectangle = new Rectangle(new Point(e), 2, 1);
                        int distanceX = figure.getRefrPoint().x - oldCoords.x;
                        int distanceY = figure.getRefrPoint().y - oldCoords.y;
                        Point refP = new Point(newPoint.x + distanceX, newPoint.y + distanceY);
                        rectangle.refreshShape(refP);
                        rectangle.setRefrPoint(refP);
                        rectangle.setDistanceX(distanceX);
                        rectangle.setDistanceY(distanceY);
                    } else {
                        rectangle = new Rectangle(newPoint, 2, 1);
                        int distanceX = figure.getRefrPoint().x - point.x;
                        int distanceY = figure.getRefrPoint().y - point.y;
                        Point refP = new Point(newPoint.x + distanceX, newPoint.y + distanceY);
                        rectangle.refreshShape(refP);
                        rectangle.setRefrPoint(refP);
                        rectangle.setDistanceX(distanceX);
                        rectangle.setDistanceY(distanceY);
                    }
                    rectangle.setDeltaX(deltaX);
                    rectangle.setDeltaY(deltaY);
                    newfigs.add(rectangle);
                        break;
                case "Figures.Triangle":
                    Triangle triangle;
                    if ((point.x == oldCoords.x) && (point.y == oldCoords.y)) {
                        triangle = new Triangle(new Point(e), new Point(e));
                        int distanceX = figure.getRefrPoint().x - oldCoords.x;
                        int distanceY = figure.getRefrPoint().y - oldCoords.y;
                        Point refP = new Point(newPoint.x + distanceX, newPoint.y + distanceY);
                        triangle.refreshShape(refP);
                        triangle.setRefrPoint(refP);
                        triangle.setDistanceX(distanceX);
                        triangle.setDistanceY(distanceY);
                    }else{
                        triangle = new Triangle(newPoint, new Point(e));
                        int distanceX = figure.getRefrPoint().x - point.x;
                        int distanceY = figure.getRefrPoint().y - point.y;
                        Point refP = new Point(newPoint.x + distanceX, newPoint.y + distanceY);
                        triangle.refreshShape(refP);
                        triangle.setRefrPoint(refP);
                        triangle.setDistanceX(distanceX);
                        triangle.setDistanceY(distanceY);
                    }
                    triangle.setDeltaX(deltaX);
                    triangle.setDeltaY(deltaY);
                    newfigs.add(triangle);
                        break;
            }
        }
        UserFigure uF = new UserFigure(newfigs, userFigure.getName());
        this.userFigure = uF;
        shapeDrawer.addShape(uF);
    }

    public void mouseDragged(MouseEvent e) {
        System.out.println("draggg--------------------");
        ArrayList<BasicFigure> oldFigures = new ArrayList<BasicFigure>(userFigure.getFigures());
        ArrayList<BasicFigure> newFigs = new ArrayList<BasicFigure>();
        BasicFigure first = oldFigures.get(0);
        int newDistX = Math.abs(e.getX() - first.getPoints().get(0).x);
        int newDistY = Math.abs(e.getY() - first.getPoints().get(0).y);
        float coefficientX = (float) newDistX / first.getDistanceX();
        float coefficientY = (float) newDistY / first.getDistanceY();
        System.out.println(coefficientX);
        System.out.println(coefficientY);
        for (int i = 0; i < oldFigures.size(); i++){
            BasicFigure figure = oldFigures.get(i).clone();
            String name = figure.getClass().getCanonicalName();
            System.out.println(name);
            int newPointX = first.getPoints().get(0).getX() - Math.round(figure.getDeltaX() * coefficientX);
            int newPointY = first.getPoints().get(0).getY() - Math.round(figure.getDeltaY() * coefficientX);
            Point newPoint = new Point(newPointX,  newPointY);
            int refrPointX = newPoint.x + Math.round(figure.getDistanceX() * coefficientX);
            int refrPointY = newPoint.y + Math.round(figure.getDistanceY() * coefficientY);
            Point refrPoint = new Point(refrPointX, refrPointY);
            switch (name){
                case "Figures.Ellipse":
                    Ellipse ellipse = new Ellipse(newPoint, 2, 1);
                    ellipse.refreshShape(refrPoint);
                    newFigs.add(ellipse);
                    break;
                case "Figures.Circle":
                    Circle circle = new Circle(newPoint, 3);
                    circle.refreshShape(refrPoint);
                    newFigs.add(circle);
                    break;
                case "Figures.Line":
                    Line line = new Line(newPoint);
                    line.refreshShape(refrPoint);
                    newFigs.add(line);
                    break;
                case "Figures.Square":
                    Square square = new Square(newPoint, 2);
                    square.refreshShape(refrPoint);
                    newFigs.add(square);
                    break;
                case "Figures.Rectangle":
                    Rectangle rectangle = new Rectangle(newPoint, 2, 1);
                    rectangle.refreshShape(refrPoint);
                    newFigs.add(rectangle);
                    break;
                case "Figures.Triangle":
                    Triangle triangle = new Triangle(newPoint, newPoint);
                    triangle.refreshShape(refrPoint);
                    newFigs.add(triangle);
                    break;
            }
        }
        UserFigure uF = new UserFigure(newFigs, userFigure.getName());
        shapeDrawer.removeLast();
        shapeDrawer.addShape(uF);
    }
}
