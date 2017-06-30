package my.BattleTowers;

import my.BattleTowers.Controller.Controller;
import my.BattleTowers.Model.Model;
import my.BattleTowers.View.View;

public class MainBattleTowers {

    public MainBattleTowers() {

        Model model = new Model();
        new View(model);
        new Controller(model);
    }

    public static void main(String[] args) {
        new MainBattleTowers();
    }

}
