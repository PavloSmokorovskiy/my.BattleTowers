package my.BattleTowers.Controller;

import my.BattleTowers.Model.Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;

public class Controller  implements ActionListener {

    private Model model;

    public double time;
    public double deltaTime;
    public double x;
    public double y;
    public double velocity;
    public double angle;
    public double mass;
    public double gravity;
    public double wind;
    public double vx;
    public double vy;

    public Controller(Model model) {
        this.model = model;
        run();
    }

    public void run() {

        while (true) {

            if (model.getOptionsPanel().isStartGame()) {
                model.getGamePanel().run();   //запуск снаряда
            } else {
                model.getGamePanel().reset(); //сброс полета снаряда
            }

            try {
                Thread.sleep(15); //слишком маленькая задержка выбрасывает RuntimeException
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public Controller(double startX, double startY, double velocity, double angle, double wind, double mass, double gravity, double deltaTime) {
        this.time = 0.0;
        this.deltaTime = deltaTime;
        this.x = startX;
        this.y = startY;
        this.velocity = velocity;
        this.mass = mass;
        this.gravity = gravity;
        this.angle = angle;
        this.wind = wind;
        this.vx = this.velocity * Math.cos(this.angle * (Math.PI / 180.0));
        this.vy = this.velocity * Math.sin(this.angle * (Math.PI / 180.0));
    }

    public Point2D getPoint() {
        time = time + deltaTime;
        x += vx * deltaTime;
        y += vy * deltaTime;

        vx += wind * deltaTime;
        vy -= gravity * mass * deltaTime;

        return new Point2D.Double(x, y);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Start")) {
            System.out.println("555");
        }
        if (command.equals("Stop")) {
            System.out.printf("ggg");
        }
    }
}