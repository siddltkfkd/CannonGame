package com.nhnacademy;

import java.awt.Color;
import java.awt.Rectangle;

public class BoundedWorld extends MovableWorld{
    static int MAX_MOVE_COUNT = 100;
    public BoundedWorld(){
        super(MAX_MOVE_COUNT);
    }

    public boolean outOfBounds(Ball ball){
        Rectangle ballBounds = new Rectangle(ball.getX()-ball.getRadius(), ball.getY()-ball.getRadius(), 2*ball.getRadius(), 2*ball.getRadius());
        Rectangle intersection = getBounds().intersection(ballBounds);
        return ballBounds.getWidth() != intersection.getWidth() || ballBounds.getHeight() != intersection.getHeight();
    }

    public void BounceBall(MovableBall ball){
        if (ball.getX()-ball.getRadius() < getBounds().getMinX() || ball.getX()+ball.getRadius() > getBounds().getMaxX()){
            ball.setDx(-ball.getDx());
        }
        if (ball.getY()+ball.getRadius() > getBounds().getMinY() || 
            ball.getY()-ball.getRadius() < getBounds().getMaxY()){
                ball.setDy(ball.getDy());
            }
    }

    @Override
    public void move() {
        super.move();
        for (int i=0; i<getBallCount(); i++){
            Ball ball = getBall(i);
            if(ball instanceof MovableBall && outOfBounds(ball)){
                BounceBall((MovableBall)ball);
            }
        }
    }


}
