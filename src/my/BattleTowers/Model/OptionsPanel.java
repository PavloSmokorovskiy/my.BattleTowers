package my.BattleTowers.Model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionsPanel extends JPanel implements ActionListener {

    protected JTextField velocityField, angleField, windField, massField, gravityField, deltaTimeField;
//    private double velocity, angle, wind, mass, gravity, deltaTime;
    private boolean startGame = false;

    public OptionsPanel() {
        JButton start = new JButton("Пуск");
        start.setActionCommand("Start");
        start.addActionListener(this);
        this.add(start);

        JButton stop = new JButton("Стоп");
        stop.setActionCommand("Stop");
        stop.addActionListener(this);
        this.add(stop);

        JLabel velocityLabel = new JLabel("Сила");
        velocityField = new JTextField(3);
        velocityField.setText("90");
//        velocity = Double.parseDouble(velocityField.getText());
        this.add(velocityLabel);
        this.add(velocityField);

        JLabel angleLabel = new JLabel("Угол");
        angleField = new JTextField(3);
        angleField.setText("60");
//        angle = Double.parseDouble(angleField.getText());
        this.add(angleLabel);
        this.add(angleField);

        JLabel windLabel = new JLabel("Ветер");
        windField = new JTextField(3);
        windField.setText("0");
//        wind = Double.parseDouble(windField.getText());
        this.add(windLabel);
        this.add(windField);

        JLabel massLabel = new JLabel("Масса");
        massField = new JTextField(3);
        massField.setText("1.3");
//        mass = Double.parseDouble(massField.getText());
        this.add(massLabel);
        this.add(massField);

        JLabel gravityLabel = new JLabel("Гравитация");
        gravityField = new JTextField(3);
        gravityField.setText("9.8");
//        gravity = Double.parseDouble(gravityField.getText());
        this.add(gravityLabel);
        this.add(gravityField);

        JLabel deltaTimeLabel = new JLabel("Прирост времени");
        deltaTimeField = new JTextField(3);
        deltaTimeField.setText("0.07");
//        deltaTime = Double.parseDouble(deltaTimeField.getText());
        this.add(deltaTimeLabel);
        this.add(deltaTimeField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Start")) {
            startGame = true;
        }
        if (command.equals("Stop")) {
            startGame = false;
        }
    } //Слушатель событий

    public boolean isStartGame() {
        return startGame;
    }

    public void setStartGame(boolean startGame) {
        this.startGame = startGame;
    }

    public double getAngle() {
        return Double.parseDouble(angleField.getText());
    }

    public double getDeltaTime() {
        return Double.parseDouble(deltaTimeField.getText());
    }

    public double getGravity() {
        return Double.parseDouble(gravityField.getText());
    }

    public double getMass() {
        return Double.parseDouble(massField.getText());
    }

    public double getVelocity() {
        return Double.parseDouble(velocityField.getText());
    }

    public double getWind() {
        return Double.parseDouble(windField.getText());
    }

}
