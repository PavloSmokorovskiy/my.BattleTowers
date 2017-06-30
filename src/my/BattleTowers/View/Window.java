package my.BattleTowers.View;

import my.BattleTowers.Model.Model;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window(Model model) {

        JFrame frame = new JFrame();
        frame.setTitle("Битва башен - Castle Wars"); // название окна
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // действие по нажатию кнопки закрыть
        frame.setIconImage(new ImageIcon("res/java.png").getImage()); // иконка окна
        frame.setLocation(150, 150); // расположение окна
        frame.setResizable(true); // окно с изменяемым размером
        frame.setAlwaysOnTop(true); // всегда поверх окон
        frame.setLayout(new BorderLayout()); //менеджер стиля
        frame.setSize(new Dimension(815, 575)); //размер
        frame.add(model.getGamePanel(), BorderLayout.CENTER); //добавление игровой панели
        frame.add(model.getOptionsPanel(), BorderLayout.SOUTH); //добавление панели опций
        frame.setVisible(true); // окно видимое


    }
}
