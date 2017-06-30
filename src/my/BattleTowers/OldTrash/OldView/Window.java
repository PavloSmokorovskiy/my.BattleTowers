package my.BattleTowers.OldTrash.OldView;

import my.BattleTowers.OldTrash.OldController.GameController;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Window extends JPanel {

    GameController gameController; // сюда присваевается ссылка на екземпляр, который приходит через конструктор
//    Line2D gorizontLine, gun;
    Rectangle2D backgroundRectangle, groundRectangle, tower1Rectangle, tower2Rectangle; // поля квадратов
    GradientPaint backgroundGradient, groundGradient, towerGradient; // поля фонов

    public static final int HEIGHT = 160;
    public static final int WIDTH = HEIGHT * 16 / 9;
    public static final int SCALE = 4;

    OptionsPanel optionsPanel = new OptionsPanel();
    GamePanel gamePanel = new GamePanel(optionsPanel);

    long reportedFramerate;
    long framerate = 1000 / 60;
    // time the frame began
    long frameStart;
    // number of frames counted this second
    long frameCount = 0;
    // time elapsed during one frame
    long elapsedTime;
    // accumulates elapsed time over multiple frames
    long totalElapsedTime = 0;
    // the actual calculated framerate reported

    public Window(JFrame frame) {
        frame.setVisible(true);     // окно видимое
        frame.setTitle("Battle towers"); // название окна
        frame.setLocation(150, 150); // расположение окна
        frame.setResizable(true); // окно с изменяемым размером
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // действие по нажатию кнопки закрыть
        frame.setAlwaysOnTop(true); // всегда поверх окон
        frame.setIconImage(new ImageIcon("res/java.png").getImage()); // иконка окна
        frame.setSize(new Dimension ( WIDTH * SCALE, HEIGHT * SCALE ));

        frame.add(optionsPanel, BorderLayout.SOUTH);
        optionsPanel.setBackground(Color.GRAY);

        frame.add(gamePanel, BorderLayout.CENTER);
//
        gamePanel.run();
        run();
//
//        while(true) {
//            if (optionsPanel.startGame) {
//                gamePanel.run();
//            }
//
////            elapsedTime = System.currentTimeMillis() - frameStart;
//
//            try {
//                // make sure framerate milliseconds have passed this frame
//                if (elapsedTime < framerate) {
//                    Thread.sleep(framerate - elapsedTime);
//                } else {
//                    // don't starve the garbage collector
//                    Thread.sleep(5);
//                }
//            } catch (InterruptedException e) {
//                break;
//            }
//        }
    } //основные настройки окна

    public Window(GameController gameController) {
        this.gameController = gameController;
        setPreferredSize(new Dimension(750, 500)); // размер окна
        backgroundRectangle = new Rectangle2D.Double(0, 0, 750, 470); // Прямоугольник фона. (Х, У, ширина, высота)
        groundRectangle = new Rectangle2D.Double(0, 470, 750, 30);    // Прямоугольник земли.
        backgroundGradient = new GradientPaint(0, 0, new Color(50, 200, 255), 0, 400, Color.BLUE); // фон горизонта
        groundGradient = new GradientPaint(0, 100, new Color(150, 255, 150), 0, 500, new Color(50, 200, 50)); //фон земли
        tower1Rectangle = new Rectangle2D.Double(40, 420, 50, 50); // создается башня1.
        tower2Rectangle = new Rectangle2D.Double(660, 420, 50, 50);// создается башня2.
        towerGradient = new GradientPaint(0, 0, new Color(50, 200, 255), 0, 400, Color.ORANGE);
//        gorizontLine = new Line2D.Double(20, 470, 710, 470);
//        gun = new Line2D.Double(45, 420, 70, 370);

        /*
        public static void main(String[] args) {

        JFrame frame = new JFrame(); //экземпляр окна
        new View(frame); //передается для прорисовки
        new GameController(frame); //добавляется игровой процесс
        }
         */

//        gamePanel.run();
//        run();
    }

    public void run(){

        while(true) {
            frameStart = System.currentTimeMillis();

            if(optionsPanel.startGame) {
                gamePanel.run();
            }
//            else {
//                gamePanel.reset();
//            }

            // calculate the time it took to render the frame
            elapsedTime = System.currentTimeMillis() - frameStart;
            // sync the framerate
            try {
                // make sure framerate milliseconds have passed this frame
                if (elapsedTime < framerate) {
                    Thread.sleep(framerate - elapsedTime);
                } else {
                    // don't starve the garbage collector
                    Thread.sleep(5);
                }
            } catch (InterruptedException e) {
                break;
            }
            ++frameCount;
            totalElapsedTime += (System.currentTimeMillis() - frameStart);
            if (totalElapsedTime > 1000) {
                reportedFramerate = (long) ((double) frameCount
                        / (double) totalElapsedTime * 1000.0);
                // show the framerate in the applet status window
                //System.out.println("fps: " + reportedFramerate);
                // repaint();
                frameCount = 0;
                totalElapsedTime = 0;

                //System.out.println(reportedFramerate);
            }
        }

    }


    public void paint(Graphics g) {
        update(g); // пишут, что такая структура прорисовки через AWT, минимально использует рессурсы
    }   //Переопределенный метод для прорисовки объектов

    public void update(Graphics g2) {
        Graphics2D g = (Graphics2D) g2;
//        g.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
//        g.draw(gorizontLine);
//        g.draw(gun);
//        g.drawImage(new ImageIcon("res/fond2.png").getImage(), 0, 0, null);

        g.setPaint(backgroundGradient); // фон горизонта
        g.fill(backgroundRectangle);    // квадрат фона горизота
        g.setPaint(groundGradient);     // фон земли
        g.fill(groundRectangle);        // квадрат фона земли
        g.setPaint(towerGradient);      // указывается фон башень
        g.fill(tower1Rectangle);        // первая башня
        g.fill(tower2Rectangle);        // фторая башня


        gameController.gun.paint(g);


//        for (int i = 0; i < 100; i++) {
//            bulletX[i] = startX + Math.cos(angle) * power * speed * (i * group);
//            bulletY[i] = startY + Math.sin(angle) * power * speed * (i * group) + (gravity * speed * Math.pow((i * group), 2)) / 2;
//        }



//        for(int i = 0; i < gameController.shot.size(); i++){
//            gameController.shot.get(i).paint(g);
//        } //

        for(int i = 0; i < gameController.ball.size(); i++){
            gameController.ball.get(i).paint(g);
        }
    }
}
