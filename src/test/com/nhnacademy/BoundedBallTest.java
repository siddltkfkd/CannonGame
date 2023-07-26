package com.nhnacademy;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class BoundedBallTest {
    public static void main(String[] args) {
        final int WIDTH = 500;
        final int HEIGHT = 300;
        final int  MAX_MOVE_COUNT = 0;

        JFrame frame = new JFrame();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.setSize(WIDTH, HEIGHT);

        MovableWorld world = new MovableWorld(MAX_MOVE_COUNT);
        frame.add(world);   // world를 add했으니까 자동으로 그려줌
        frame.setVisible(true);
        
        BoundedBall ball = new BoundedBall(100, 100, 50);
        ball.setDx(10);
        ball.setDy(10);
        ball.setBounds(new Rectangle(0, 0, world.getWidth(), world.getHeight()));   // 방법 1   ball의 bound 크기는 윈도우 크기와 같게 -> 그래야 벽에 부딪히면 튕겨나감
        
        BoundedBall ball2 = new BoundedBall(400, 100, 50, Color.GREEN);
        ball2.setDx(-10);
        ball2.setDy(10);
        ball2.setBounds(world.getBounds()); // 방법 2
        
        Ball staticBall = new Ball(250, 100, 50, Color.PINK);
        
        world.add(staticBall);
        world.add(ball2);
        world.add(ball);
        
        world.setDt(100);
        world.run();    //visible 뒤에 쓰면 다 돌아간 후 표시

    }
}
