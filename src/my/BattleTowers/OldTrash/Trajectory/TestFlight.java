package my.BattleTowers.OldTrash.Trajectory;

/**
 * Created by kostik on 20/02/16.
 */
public class TestFlight {

    static double m = 100.0;
    static double x = 0;
    static double y = 0;
    static double v = 150;
    static double alpha = 30;
    static double t = 1.2;


    public static void main(String[] args) {

//        double[] params = {100.0, 0, 0, 150, 30, 1.2};
//        double[] params = {m, x, y, v, alpha, t};
//        new BodyFlight(params);



        new BodyFlight2(m, x, y, v, alpha, t);
    }


    public static void main() {

        new BodyFlight2(m, x, y, v, alpha, t);


    }
}
