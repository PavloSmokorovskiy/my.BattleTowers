package my.BattleTowers.OldTrash.Trajectory;

/**
 * Created by kostik on 20/02/16.
 */
public class BodyFlight2 {
    // ускорение свободного падения(сила гравитации)
    private final static double g = 9.8;
    // коэфициент для силы сопротивления воздух
    private final static double gamma = 0.005;
    // кол-во итераций
    private final static int n = 1000;
    // Тело:
    public Body body;
    // момент времени
    private double t;
    // расчёт траэктории тела

    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {

        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    // конструктор класса
    BodyFlight2(double m, double x, double y, double v, double alpha, double t) {
        // масса - превод из граммов в килограммы
        m = m / 1000;
        //координаты x, y
        // угол к горизонту
        alpha = Math.toRadians(alpha);
        // Компоненты скорости:
        double Vx = v * Math.cos(alpha);
        double Vy = v * Math.sin(alpha);
        // Обьект для "тела"
        body = new Body(m, x, y, Vx, Vy);
        // время
        this.t = t;
        // Расчёт положениятела в момент времени t
        calculate();
        // отображение результатов расчётов
        body.show();
    }

    private void calculate() {
        // кординаты (), скорость, приращения
        double x, y, dx, dy, Vx, Vy, dVx, dVy, dt;
        dx = 0;
        dy = 0;
        dVx = 0;
        dVy = 0;
        // Сила:
        Force F = new Force();
        // начальные координаты и начальная скорость
        x = body.x;
        y = body.y;

        Vx = body.Vx;
        Vy = body.Vy;
        // шаг дискретности по времени
        dt = t / n;
        //вычисление координат и скорости
        for (int i = 0; i < n; i++) {
            dx = Vx * dt;
            dy = Vy * dt;

            dVx = F.x(body) * dt / body.m;
            dVy = F.y(body) * dt / body.m;

            x += dx; // вычисление следующей координаты?
            y += dy; // вычисление следующей координаты?

            setX(x);
            setY(y);

            Vx += dVx;
            Vy += dVy;

            body.set(x, y, Vx, Vy);
        }

        for (int i = 0; i < n; i++) {
//            run2(dx, dy, Vx, Vy, dVx, dVy, dt, F);

        }
    }

//    public void run2(double dx, double dy, double Vx, double Vy, double dVx, double dVy, double dt, Force F){
//
//        dx = Vx * dt;
//        dy = Vy * dt;
//
//        dVx = F.x(body) * dt / body.m;
//        dVy = F.y(body) * dt / body.m;
//
//        x += dx; // вычисление следующей координаты?
//        y += dy; // вычисление следующей координаты?
//
//        Ball.x = x;
//        Ball.y = y;
//
//        Vx += dVx;
//        Vy += dVy;
//
//        body.set(x, y, Vx, Vy);
//    }


    // Внутренний класс для "тела"
    class Body {
        // масса
        double m;
        // кооординаты
        double x;
        double y;
        // Компоненты скорости:
        double Vx;
        double Vy;

        // конструктор внутреннего класса
        Body(double m, double x, double y, double Vx, double Vy) {
            this.m = m;
            set(x, y, Vx, Vy);
        }

        // Модуль скорости:
        double V() {
            return Math.sqrt(Vx * Vx + Vy * Vy);
        }

        // метод вычисления угла к горизонту
        double phi() {
            return Math.atan2(Vy, Vx);
        }

        // метод присваивания значений полям
        // парметры - координаты и компоненты скорости
        void set(double x, double y, double Vx, double Vy) {
            this.x = x;
            this.y = y;
            this.Vx = Vx;
            this.Vy = Vy;
        }

        // метод отображения параметров обьекта
        void show() {
            double alpha = Math.round(Math.toDegrees(phi()) * 100) / 100.0;
            System.out.println("During t = " + t);
            System.out.println("Height " + Math.round(y * 100) / 100.0 + " meters");
            System.out.println("Distance from start point = " + Math.round(x * 100) / 100.0 + " meters");
            System.out.println("Speed = " + Math.round(V() * 100) / 100.0 + " meters per second");
            System.out.println("Angle = " + alpha + " degrees");
        }

    }

    // внутренний класс для "силы"
    class Force {
        // проэкция на горизонтальную ось
        double x(Body b) {
            return -gamma * b.Vx;
        }

        // проэкция на вертикальную ось
        double y(Body b) {
            return -g * b.m - gamma * b.Vy;
        }
    }
}
