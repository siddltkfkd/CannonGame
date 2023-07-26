package com.nhnacademy;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MoveTest {
    public static void main(String[] args) {
        final int MAX_MOVE_COUNT = 100;
        int WIDTH = 400;
        int HEIGHT = 300;

        JFrame frame = new JFrame();
        MovableWorld world = new MovableWorld(MAX_MOVE_COUNT);
        frame.add(world);
        world.setDt(100);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);

        Ball staticBall = new Ball(150, 150, 10, Color.BLACK);
        MovableBall ball = new MovableBall(100, 100, 10, Color.GREEN);
        ball.setDx(10);
        ball.setDy(10);
        MovableBall ball2 = new MovableBall(200, 200, 10, Color.ORANGE);
        ball2.setDx(-10);
        ball2.setDy(10);

        world.add(staticBall);
        world.add(ball);
        world.add(ball2);

        world.run(MAX_MOVE_COUNT);
    }
    
}
