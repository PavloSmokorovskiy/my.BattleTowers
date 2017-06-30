package my.BattleTowers.OldTrash.OldModel;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Shot { //Не знаю как этот класс работает. Нужно здесь реализовать выстрел по параболе
    public int x, y;
    double vx, vy;
    Ellipse2D bullet;

    public Shot(int x, int y, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        bullet = new Ellipse2D.Double(-8, -8, 16, 16); //создает объект снаряда
    }

    public void paint(Graphics2D g) {
        g.translate(x, y);
        g.setPaint(Color.ORANGE); // цвет снаряда
        g.fill(bullet);          // рисует снаряд
        g.translate(-x, -y);
    }

    public void run() {
        x += vx;
        y += vy;
    }
}
