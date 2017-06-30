package my.BattleTowers.OldTrash.OldModel;


import my.BattleTowers.OldTrash.OldController.GameController;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Gun { // Как этот класс работает. Тоже не знаю.
    public int x, y;
    Rectangle2D r1;
    GameController gameController;

    public Gun(GameController gameController) {
        x = 70;
        y = 390;
        this.gameController = gameController;
        r1 = new Rectangle2D.Double(-25, -10, 75, 25);
    }

    public int target(int i) {
        if (i == 0) {
            return gameController.mouse_pos.x;
        } else {
            return gameController.mouse_pos.y;
        }
    }

    public void paint(java.awt.Graphics2D g) {
        int tx = x, ty = y;
        g.translate(tx, ty);
        double xdiff = target(0) - tx;
        double ydiff = target(1) - ty;
        if (ydiff != 0) {
            g.rotate(Math.atan(ydiff / xdiff));
            if (xdiff < 0) {
                g.rotate(Math.PI);
            }
        }
        g.setPaint(Color.GRAY);
        g.fill(r1);
        g.setPaint(Color.BLACK);
        g.draw(r1);
        if (ydiff != 0) {
            g.rotate(-Math.atan(ydiff / xdiff));
            if (xdiff < 0) {
                g.rotate(-Math.PI);
            }
        }
        g.translate(-tx, -ty);
    }
}
