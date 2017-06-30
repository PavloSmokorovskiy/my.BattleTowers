//package BattleTowers.Model;
//
//import java.awt.geom.Ellipse2D;
//import java.awt.geom.Rectangle2D;
//
//public class Circle extends Ellipse2D {
//
//    private Point point;
//    private double width;
//    private double height;
//
//    private double x0 = 50;
//    private double y0 = 300;
//
//    {
//        point = new Point();
//    }
//
//    public Circle() {
//
//    }
//
//    public Circle(double x, double y, double width, double height) {
//        point.setLocation(x, y);
//        this.width = width;
//        this.height = height;
//    }
//
//    @Override
//    public double getX() {
//        return point.getX();
//    }
//
//    @Override
//    public double getY() {
//        return point.getY();
//    }
//
//    @Override
//    public double getWidth() {
//        return width;
//    }
//
//    @Override
//    public double getHeight() {
//        return height;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return false;
//    }
//
//    @Override
//    public void setFrame(double x, double y, double width, double height) {
//        point.setLocation(x, y);
//        this.width = width;
//        this.height = height;
//    }
//
//    @Override
//    public Rectangle2D getBounds2D() {
//        return null;
//    }
//
//    public void movie() {
//
//        double newX = x0++;
//        double newY = y0 -= 0.4;
//        setFrame(newX, newY, 12, 12);
//    }
//
//}
