package my.BattleTowers.Model;

public class Model {

    private OptionsPanel optionsPanel;
    private GamePanel gamePanel;

    public Model() {

        optionsPanel = new OptionsPanel();
        gamePanel = new GamePanel(optionsPanel);

    }

    public OptionsPanel getOptionsPanel() {
        return optionsPanel;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

}
