package my.BattleTowers.Model;

import my.BattleTowers.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class GamePanel extends JPanel {

    private Controller controller;
    private OptionsPanel optionsPanel;
    private ArrayList<Point2D> points = null;

    private int distance;

    private Rectangle2D tower1Rectangle, tower2Rectangle;

    public GamePanel(OptionsPanel optionsPanel) {
        this.optionsPanel = optionsPanel;
        this.points = new ArrayList<Point2D>();

        tower1Rectangle = new Rectangle2D.Double(20, 370, 50, 50); // создается башня1.
        tower2Rectangle = new Rectangle2D.Double(615, 370, 150, 90);// создается башня2.

    }

    public void run() {
        if (controller == null)
            controller = options(93, 142);
        points.add(controller.getPoint());
        repaint();
    }

    public Controller options(double startX, double startY) {

        return new Controller(startX, startY, optionsPanel.getVelocity(), optionsPanel.getAngle(), optionsPanel.getWind(),
                optionsPanel.getMass(), optionsPanel.getGravity(), optionsPanel.getDeltaTime());

    }


    public void reset() {
        this.points.clear();
        controller = null;
    }

    public boolean collide() {

        return controller.x == 680;
    }

    public int distance() {
//        distance = Math.sqrt((controller.x - tower2Rectangle.getCenterX()));

        return distance;
    }


    public Graphics paintField(Graphics2D g) {


//        g.setColor(Color.RED); // Очистка экрана
//        g.fillRect(0, 0, getWidth(), getHeight()); // Экран очищен


        g.drawImage(new ImageIcon("res\\Background.800.500.jpg").getImage(), 0, 0, null);
        g.drawImage(new ImageIcon("res\\castle-two-towersCroped.160.100.png").getImage(), 25, 360, null);
        g.drawImage(new ImageIcon("res\\castle-two-towersCroped.160.100.png").getImage(), 610, 360, null);
        g.drawImage(new ImageIcon("res\\castle-two-towersCroped.160.100.png").getImage(), 610, 360, null);
        g.drawImage(new ImageIcon("res\\Cannon.40.80.png").getImage(), 85, 310, null);
//        g.rotate(-Math.atan(160));


        g.setColor(Color.ORANGE);
//        g.draw(tower1Rectangle);        // первая башня
        g.draw(tower2Rectangle);        // вторая башня
        return g;
    }

    public void paintComponent(Graphics g2) {
        super.paintComponent(g2);
        Graphics2D g = (Graphics2D) g2;

        paintField(g);

        if (optionsPanel.isStartGame()) {

            paintField(g);

            Point2D point = points.get(points.size() - 1);

            if ((int) point.getY() < 0) {
                optionsPanel.setStartGame(false);
            }
            g.setColor(Color.GRAY);
            for (Point2D p : points) {
                g.drawOval((int) p.getX(), getHeight() - ((int) p.getY()), 20, 20); //хвост
            }
            g.setColor(Color.RED);

            g.fillOval((int) point.getX(), getHeight() - ((int) point.getY()), 20, 20); //снаряд

//            System.out.println(getTower1Rectangle());
//            System.out.println((int) Math.sqrt((controller.x - tower2Rectangle.getCenterX()) + (getHeight() - controller.y - tower2Rectangle.getCenterY())));
            if ((int) Math.sqrt((controller.x - tower2Rectangle.getCenterX()) + (getHeight() - controller.y - tower2Rectangle.getCenterY()) + 100) > 0) {

                g.setColor(Color.RED);
                g.fill(tower2Rectangle);
                optionsPanel.setStartGame(false);
            }

            g.setColor(Color.ORANGE);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("Скорость Y: " + (int) controller.vy, 20, 20);
            g.drawString("Скорость X: " + (int) controller.vx, 20, 40);
            g.drawString("Время: " + (int) controller.time, 200, 20);
            g.drawString("Координаты X: " + (int) controller.x, 320, 20);
            g.drawString("Координаты Y: " + (int) controller.y, 320, 40);

        }


    }

}
