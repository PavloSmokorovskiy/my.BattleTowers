package my.BattleTowers.OldTrash.OldView;


import java.awt.geom.Point2D;

public class Controller {

    private double time, deltaTime, x, y, velocity, angle, wind, gravity, vx, vy;

    long reportedFramerate;
    long framerate = 1000 / 60;
    // time the frame began
    long frameStart;
    // number of frames counted this second
    long frameCount = 0;
    // time elapsed during one frame
    long elapsedTime;
    // accumulates elapsed time over multiple frames
    long totalElapsedTime = 0;
    // the actual calculated framerate reported

    public Controller(double velocity, double angle, double wind, double gravity, double deltaTime) {
        this.time = 0.0;
        this.deltaTime = deltaTime;
        this.x = 1.0;
        this.y = 1.0;
        this.velocity = velocity;
        this.gravity = gravity;
        this.angle = angle;
        this.wind = wind;
        this.vx = this.velocity * Math.cos(this.angle * (Math.PI / 180.0));
        this.vy = this.velocity * Math.sin(this.angle * (Math.PI / 180.0));
    }

    public Point2D getPoint() {
        this.time += deltaTime;
        this.x += this.vx * this.deltaTime;
        this.y += this.vy * this.deltaTime;
        this.vx += this.wind * this.deltaTime;
        this.vy += this.gravity * this.deltaTime;
        return new Point2D.Double(x, y);
    }

    public void run(){

    }
}
