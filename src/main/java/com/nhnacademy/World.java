package com.nhnacademy;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class World extends JPanel{
    List<Ball> ballList;

    public World() {
        super();
        ballList = new ArrayList<>();
    }

    public void add(Ball ball){
        ballList.add(ball);
    }
    public void remove(Ball ball){
        ballList.remove(ball);
    }
    public Ball getBall(int index){
        return ballList.get(index);
    }
    public int getBallCount(){
        return ballList.size();
    }
    public void removeBall(int index){
        ballList.remove(index);
    }

    @Override
    public void paint(Graphics graphics){
        super.paint(graphics);
        for (int i=0; i<getBallCount(); i++){
            Ball ball = getBall(i);
            ball.paint(graphics);
        }
    }
}
