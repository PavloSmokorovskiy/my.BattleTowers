//package BattleTowers.Controller;
//
//public class Coordinates {
//
//    int time;        //время прошедшее с начала полета
//    double bulletX[];   //x координата снаряда
//    double bulletY[];   //y координата снаряда
//    double startX;      //x координата начала полета
//    double startY;      //y координата начала полета
//    double bulletXPower;//сила полета приложенная к оси x
//    double bulletYPower;//сила полета приложенная к оси y
//    double angle;       //угол запуска снаряда
//    double power;       //сила запуска снаряда
//    double speed;       //коэффициент скорости полета снаряда
//    double gravity;     //сила гравитации
//    double group;       //коэффициент "кучности" точек
//
//
//
//    public Coordinates() {
//        bulletXPower = Math.cos(angle) * power;
//        bulletYPower = Math.sin(angle) * power;
//
//
//    }
//
//    public void launch() {
//
//        for (int i = 0; i < time; i++) {
//            bulletX[i] = startX + Math.cos(angle) * power * speed * (i * group);
//            bulletY[i] = startY + Math.sin(angle) * power * speed * (i * group) + (gravity * speed * Math.pow((i * group), 2)) / 2;
//        }
//
//
//    }
//
//
//}
