package com.nhnacademy;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import com.nhnacademy.Ball;
import com.nhnacademy.World;

public class WorldTest {
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

        World world = new World();
        frame.add(world);   // world를 add했으니까 자동으로 그려줌

        Ball ball = new Ball(100, 100, 100);
        world.add(ball);

        frame.setVisible(true);

    }
}
