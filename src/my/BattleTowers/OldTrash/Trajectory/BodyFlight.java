package my.BattleTowers.OldTrash.Trajectory;

/**
 * Created by kostik on 20/02/16.
 */
public class BodyFlight {
    // ускорение свободного падения(сила гравитации)
    private final static double g = 9.8;
    // коэфициент для силы сопротивления воздух
    private final static double gamma = 0.005;
    // кол-во итераций
    private final static int n = 1000;
    // момент времени
    private double t;
    // Тело:
    private Body body;
    // расчёт траэктории тела
    private void calculate() {
        // кординаты (), скорость, приращения
        double x, y, dx, dy, Vx, Vy, dVx, dVy, dt;
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

            x += dx;
            y += dy;

            Vx += dVx;
            Vy += dVy;

            body.set(x, y, Vx, Vy);
        }
    }
    // конструктор класса
        BodyFlight(double[] params) {
            // масса - превод из граммов в килограммы
            double m = params[0]/1000;
            //координаты
            double x = params[1];
            double y = params[2];
            // угол к горизонту
            double alpha = Math.toRadians(params[4]);
            // Компоненты скорости:
            double Vx = params[3] * Math.cos(alpha);
            double Vy = params[3] * Math.sin(alpha);
            // Обьект для "тела"
            body = new Body(m, x, y, Vx, Vy);
            // время
            this.t = params[5];
            // Расчёт положениятела в момент времени t
            calculate();
            // отображение результатов расчётов
            body.show();
        }

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
        // Модуль скорости:
        double V() {
            return Math.sqrt(Vx * Vx + Vy * Vy);
        }
        // метод вычисления угла к горизонту
        double phi() {
            return Math.atan2(Vy, Vx);
        }
        // конструктор внутреннего класса
        Body(double m, double x, double y, double Vx, double Vy) {
            this.m = m;
            set(x, y, Vx, Vy);
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
            System.out.println("Height " + Math.round(y *100) / 100.0 + " meters");
            System.out.println("Distance from start point = " + Math.round(x * 100) / 100.0 + " meters");
            System.out.println("Speed = " + Math.round(V() * 100) /100.0 + " meters per second");
            System.out.println("Angle = " + alpha + " degrees");
        }

    }
    // внутренний класс для "силы"
    class Force{
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
