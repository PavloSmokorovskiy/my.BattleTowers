package my.BattleTowers.OldTrash.OldController;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ball {

    public double x;
    public double y;
    //    int time;        //время прошедшее с начала полета
//    double bulletX[] = new double[100];   //x координата снаряда
//    double bulletY[] = new double[100];   //y координата снаряда
//    double startX = 10;      //x координата начала полета
//    double startY = 10;      //y координата начала полета
    double angle = 25;       //угол запуска снаряда
    //    double power = 100;       //сила запуска снаряда
//    double speed = 0.001;       //коэффициент скорости полета снаряда
//    double gravity = 10;     //сила гравитации
//    double group = 1;       //коэффициент "кучности" точек
    double vx, vy;
    Ellipse2D ball;

    // Ускорение свободного падения:
    double g = 9.8;
    // Число "пи":
    double pi = 3.141592;
    // Угол к горизонту (в градусах):
    double alpha = 10;
    // Масса тела (в килограммах):
    double m = 0.9;
    // Коэффициент сопротивления воздуха (в Н*с/м):
    double gamma = 0.1;
    // Скорость тела (в м/с):
    double v = 0.92;
    // Время (в секундах):
//    double t = 1.0;
    // Координаты тела (в метрах):
//    double x, y;
// Перевод градусов в радианы:


//    public static void setX(double x) {
//        this.x = x;
//    }
//
//    public static void setY(double y) {
//        this.y = y;
//    }

    public Ball(double x, double y) {
        this.x = x;
        this.y = y;
//        this.vx = vx;
//        this.vy = vy;
        ball = new Ellipse2D.Double(-8, -8, 16, 16); //создает объект снаряда
    }

//    public void launch() {
//
//        for (int i = 0; i < time; i++) {
//            bulletX[i] = startX + Math.cos(angle) * power * speed * (i * group);
//            bulletY[i] = startY + Math.sin(angle) * power * speed * (i * group) + (gravity * speed * Math.pow((i * group), 2)) / 5;
//        }
//
//
//    }

    public void paint(Graphics2D g) {
        g.translate(x, y);
        g.setPaint(Color.RED); // цвет снаряда
        g.fill(ball);          // рисует снаряд
        g.translate(-x, -y);
    }

    public void run(double t) {

//        System.out.println(t);
//        for (int i = 0; i < 100; i++) {
//            x = startX + Math.cos(angle) * power * speed * (i * group);
//            y = startY + Math.sin(angle) * power * speed * (i * group) + (gravity * speed * Math.pow((i * group), 2)) / 2;

//        x = (Math.pow(1 - t, 2) * 80 + 2 * (1 - t) * t * 440 + Math.pow(t, 2) * 810);
//        y = (Math.pow(1 - t, 2) * 440 + 2 * (1 - t) * t * 30 + Math.pow(t, 2) * 660);

//        BodyFlight2.run2(dx, dy, Vx, Vy, dVx, dVy, dt, F);

        alpha /= 180 / pi;

//        x = 50+V * m * Math.cos(alpha) / gamma * (1 - Math.exp(-gamma * t / m));
//        y = 400+m * (V * Math.sin(alpha) * gamma + m * gamma) / gamma / gamma * (1 - Math.exp(-gamma * t / m)) - m * g * t / gamma;


//        x = x + V * Math.cos(angle) * t;
//        y = y + V * Math.sin(angle) * t - Math.pow(g, 2) / 2;


        x = x + v * Math.cos(this.angle * (Math.PI / 180.0));
        y = y + v * Math.sin(this.angle * (Math.PI / 180.0));


//        x += 50+Math.cos(angle) + (m * v * Math.cos(angle) / gamma) * (1 - v*(-gamma * t / m));
//        y += 400+Math.sin(angle) - (m * g * t / gamma)+((m * v * Math.sin(angle) / gamma) + (m*2 * g / (gamma*2))) * (1 - v*(-gamma * t / m));


//        System.out.println(t);
//        System.out.println(y);
////        }
//        System.out.println(bulletX[i]);
//    }

//        TestFlight.main();
//        angle = Math.atan((y - gameView.shotY) / (x - gameView.shotX)); //позиция начальная - координата косания

//        x = (x + speed * Math.cos(angle));
//        y = (y + speed * Math.sin(angle));


//        if (x < 100) x++;
//        else x = 0;
//        y += Math.sin(y) * 1.1;


//        System.out.println(x);
//        System.out.println(y);

//        x += vx;
//        y += vy;
    }
}
