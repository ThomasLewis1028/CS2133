/**
 * Created by thoma on 9/26/2016.
 */
public class PongModel {
    private double ball_x;
    private double ball_y;
    private double vx;
    private double vy;
    private double paddle;

    public PongModel(){
        ball_x = 0.5;
        ball_y = 0.5;
        paddle = 0.5;
        vx = 0.01;
        vy = 0.005;
    }

    public void timeStep(){
        if(ball_y <= 0.0 || ball_y >= 1.0){
            vy = -vy;
        }

        if(ball_x >= 1.0){
            vx = -vx;
        }

        if(ball_x <= 0.0){
            ball_x = ball_y = 0.5;
        }
        ball_x += vx;
        ball_y += vy;
    }

    public void movePaddle(double y){
        paddle = y;
    }

    public double getBall_x(){
        return ball_x;
    }

    public double getBall_y(){
        return ball_y;
    }

    public double getPaddle(){
        return paddle;
    }
}
