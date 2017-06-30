package my.BattleTowers.MVC;

import javax.swing.*;

public class MvcMain extends JFrame {

    public MvcMain() {
        MvcModel mvcModel = new MvcModel();
        MvcView mvcView = new MvcView(mvcModel);
        MvcController mvcController = new MvcController(mvcModel, mvcView);
    }

    public static void main(String[] args) {
        new MvcMain();


    }
}