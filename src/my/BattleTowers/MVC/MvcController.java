package my.BattleTowers.MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MvcController implements ActionListener {

    private MvcModel mvcModel;
    private MvcView mvcView;


    public MvcController(MvcModel mvcModel, MvcView mvcView) {
        this.mvcModel = mvcModel;
        this.mvcView = mvcView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}