package com.nhnacademy;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class BoundedWorldTest {
    public static void main(String[] args) {
        final int WIDTH = 500;
        final int HEIGHT = 300;

        JFrame frame = new JFrame();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.setSize(WIDTH, HEIGHT);

        BoundedWorld world = new BoundedWorld();
        frame.add(world);   // world를 add했으니까 자동으로 그려줌
        frame.setVisible(true);
        
        MovableBall ball = new MovableBall(100, 100, 50);
        ball.setDx(10);
        ball.setDy(10);
        
        MovableBall ball2 = new MovableBall(400, 100, 50, Color.GREEN);
        ball2.setDx(-10);
        ball2.setDy(10);
        
        Ball staticBall = new Ball(250, 100, 50, Color.PINK);
        
        world.add(staticBall);
        world.add(ball2);
        world.add(ball);
        
        world.setDt(100);
        world.run();    //visible 뒤에 쓰면 다 돌아간 후 표시

    }
}
