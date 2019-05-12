package Figures;

public class Square extends Rectangle {

    public Square(){}

    public Square(Point bottomLeft, int side) {
        super(bottomLeft, side, side);
    }

    @Override
    public void refreshShape(Point point) {
        setRefrPoint(point);

        int height = Math.abs(getPoints().get(0).y - point.y);
        int width = Math.abs(getPoints().get(0).x - point.x);

        if (width < height){
            int deltaY = width * (int)Math.signum(point.y - getPoints().get(0).y);
            super.refreshShape(new Point(point.x, getPoints().get(0).y + deltaY));
        } else {
            int deltaX = height * (int)Math.signum(point.x - getPoints().get(0).x);
            super.refreshShape(new Point(getPoints().get(0).x + deltaX, point.y));
        }
    }

}