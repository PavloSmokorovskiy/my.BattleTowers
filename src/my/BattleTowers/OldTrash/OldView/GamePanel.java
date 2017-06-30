package my.BattleTowers.OldTrash.OldView;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class GamePanel extends JPanel {

    private Controller controller;
    private OptionsPanel optionsPanel;
    private ArrayList<Point2D> points = null;

    public GamePanel(OptionsPanel optionsPanel) {
        this.optionsPanel = optionsPanel;
        this.points = new ArrayList<Point2D>();

    }


    public void run() {
        if (controller == null)
            controller = optionsPanel.options();
        this.points.add(controller.getPoint());
        repaint();
    }

    public void paintComponent(Graphics g){

        Point2D point = points.get(points.size() - 1);
        g.setColor(Color.GRAY);
        for (Point2D p : points) {
            g.drawOval((int) p.getX(), getHeight() - ((int) p.getY()), 20, 20);
        }
        g.setColor(Color.RED);

        g.fillOval((int) point.getX(), getHeight() - ((int) point.getY()), 20, 20);



    }
}
