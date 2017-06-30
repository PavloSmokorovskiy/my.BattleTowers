//package BattleTowers.Model;
//
//import javax.swing.*;
//import java.awt.*;
//
//class GraphicsPanel extends JPanel implements Runnable {
//
//    private Line gorizontLine;
//    private MainBattleTowers.OldModel.Rectangle rectangle;
//    private Circle circle;
//    public static Line gun;
//    private Circle bullet;
//
//
//    public GraphicsPanel() {
//        gorizontLine = new Line(10, 410, 720, 410);
//        rectangle = new MainBattleTowers.OldModel.Rectangle(30, 360, 50, 50);
//        circle = new Circle(630, 30, 70, 70);
//
//        gun = new Line(55, 360, 100, 100);
//
//        bullet = new Circle(gun.getX2(), gun.getY2(), 12, 12);
//
//
//
//
//
//
//
//        (new Thread(this)).start(); // run thread
//
//    }
//
//
//
//    @Override
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        Graphics2D g2 = (Graphics2D) g;
//        ((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC));
//        g2.draw(gorizontLine);
//        g2.draw(rectangle);
//        g2.draw(circle);
//        g2.draw(gun);
//        g2.draw(bullet);
//    }
//
//    @Override
//    public void run() {
//        while (true) {
//            try {
//                bullet.movie();
//                gun.movie();
//                super.repaint();
//                Thread.sleep(30);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//
//}
