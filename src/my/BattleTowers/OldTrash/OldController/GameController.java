package my.BattleTowers.OldTrash.OldController;

import my.BattleTowers.OldTrash.OldModel.Gun;
import my.BattleTowers.OldTrash.OldModel.Shot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

public class GameController implements KeyListener, MouseListener, MouseMotionListener {

    public Gun gun;
    public Vector<Shot> shot;
    public ArrayList<Ball> ball;
    public Point mouse_pos; //поле координат курсора
    JFrame frame;
    my.BattleTowers.OldTrash.OldView.Window window;
//    Double angle = 0.0;
    double t = 0;

    public GameController(JFrame frame) {
        mouse_pos = new Point(0, 0);
        window = new my.BattleTowers.OldTrash.OldView.Window(this);
        gun = new Gun(this);
        shot = new Vector<Shot>();
        ball = new ArrayList<Ball>();

        this.frame = frame;
        this.frame.getContentPane().add(window, BorderLayout.CENTER); //менеджер управления стелем окна
        this.frame.pack();                           // устанавливает оптимальный размер элементов на окне
        this.frame.addMouseListener(this);           // Добавление слушателей на окно
        this.frame.addMouseMotionListener(this);     // Добавление слушателей на окно
        this.frame.addKeyListener(this);             // Добавление слушателей на окно
        run(); // игровой процесс
    }

    void run() {




        while (true) {


//            for (int i = 0; i < 100; i++) {
//                Ball.setX(i);
//                Ball.setY(i);
//
//            }



            for (int i = 0; i < ball.size(); i++) {

                t += 0.005;
                ball.get(i).run(t);


            } // считывает полет снаряда с ArrayList
//            System.out.println(ball.size());
//            for (int i = 0; i < shot.size(); i++) {
//                shot.get(i).run();
//            } //

            window.repaint(); // перерисовке окна
            try {
                Thread.sleep(20); // задержка милисекунд в прорисовке
            } catch (Exception e) {
            }
        }
    }

    // Ниже все реализованы все методы слушателей KeyListener, MouseListener, MouseMotionListener

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
//        switch (e.getKeyCode()) {
//            case 37:    //left
//                angle -= 0.04;
//                break;
//            case 38:    //up
//                angle -= 0.04;
//                break;
//            case 39:    //right
//                angle += 0.04;
//                break;
//            case 40:    //down
//                angle += 0.04;
//                break;
//            case 32:    //space
//                break;
//        }
//        System.out.println(angle);
    } // Тут должно быть управление пушкой с клавиатуры, но пока не реализовано


    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            int xdiff = mouse_pos.x - gun.x;
            int ydiff = mouse_pos.y - gun.y;
            double length = Math.sqrt(xdiff * xdiff + ydiff * ydiff);
//            shot.add(new Shot(gun.x, gun.y, (int) (xdiff * (5 / length)), (int) (ydiff * (5 / length))));
//            System.out.println();
//            ball.add(new Ball(gun.x, gun.y, (xdiff * (6 / length)),(ydiff * (6 / length))));

//            for (double i = 0; i<10; i+= 0.01) {
                ball.add(new Ball(200, 200));


//            }
        }
    } // Слушатель нажатия мышки. С интерфейса MouseListener

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
//        System.out.println("X = " + e.getX() + " Y = " + e.getY());
        mouse_pos.setLocation(e.getX(), e.getY()); // Меняет положение пушки
    } //Слушатель движения мышки. С интерфейса MouseMotionListener.
}