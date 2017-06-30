package my.BattleTowers.OldTrash;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class RotateImage extends JFrame{ //очепятка)

    BufferedImage original_img;
    BufferedImage rotated_img;
    int h, w;

    RotateImage(){

        Image img = new ImageIcon("res\\Cannon.50.100.png").getImage();

        h = img.getHeight(null);
        w = img.getWidth(null);

        original_img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        Graphics g = original_img.createGraphics();

        g.drawImage(img, 0, 0, null);

        g.dispose();

        rotated_img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        AffineTransform at = new AffineTransform();

        at.setToRotation(Math.PI, w/2, h/2);
        AffineTransformOp atOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        atOp.filter(original_img, rotated_img);


        this.setSize(2*w + 30, h + 40);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);

        repaint();

    }

    public void paint(Graphics g) {
        g.drawImage(original_img, 15, 30, null);
        g.drawImage(rotated_img, 15 + w, 30, null);
    }

    public static void main(String[] args) {
        new RotateImage();
    }
}