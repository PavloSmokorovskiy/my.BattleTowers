package my.BattleTowers.OldTrash.OldView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionsPanel extends JPanel implements ActionListener {

    private final JLabel velocityLabel, angleLabel, windLabel, gravityLabel, deltaTimeLabel;
    private final JTextField velocityField, angleField, windField, gravityField, deltaTimeField;
    private final JButton start, stop;
    boolean startGame = false;

    public OptionsPanel() {
        start = new JButton("Старт");
        start.setActionCommand("Start");
        start.addActionListener(this);
        this.add(start);

        stop = new JButton("Стоп");
        stop.setActionCommand("Stop");
        stop.addActionListener(this);
        this.add(stop);

        velocityLabel = new JLabel("Скорость");
        velocityField = new JTextField(3);
        velocityField.setText("60");
        this.add(velocityLabel);
        this.add(velocityField);

        angleLabel = new JLabel("Угол");
        angleField = new JTextField(3);
        angleField.setText("60");
        this.add(angleLabel);
        this.add(angleField);

        windLabel = new JLabel("Ветер");
        windField = new JTextField(3);
        windField.setText("0");
        this.add(windLabel);
        this.add(windField);

        gravityLabel = new JLabel("Гравитация");
        gravityField = new JTextField(3);
        gravityField.setText("-9.8");
        this.add(gravityLabel);
        this.add(gravityField);

        deltaTimeLabel = new JLabel("Прирост времени");
        deltaTimeField = new JTextField(3);
        deltaTimeField.setText("0.05");
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
    }

    public Controller options() {
        return new Controller(Double.parseDouble(velocityField.getText()), Double.parseDouble(angleField.getText()),
                Double.parseDouble(windField.getText()), Double.parseDouble(gravityField.getText()), Double.parseDouble(deltaTimeField.getText()));
    }
}
