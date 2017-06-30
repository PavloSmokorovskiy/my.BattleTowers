package my.BattleTowers.OldTrash.Test;


import javax.swing.*;
import java.awt.*;

public class Test1 extends JFrame {
    public static void main(String[] args) {
        JFrame f = new Test1();
        Component[] comps = f.getComponents();
        for (int i = 0; i < comps.length; i++) {
            if (comps[i] instanceof Container)
                processContainer((Container) comps[i]);
        }
    }

    static void processContainer(Container c) {
        System.out.println(c);
        for (int i = 0; i < c.getComponents().length; i++) {
            if (c.getComponents()[i] instanceof Container)
                processContainer((Container) c.getComponents()[i]);
        }
    }
}


