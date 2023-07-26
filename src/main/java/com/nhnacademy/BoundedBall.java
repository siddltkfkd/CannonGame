package com.nhnacademy;

import java.awt.Color;
import java.awt.Rectangle;

public class BoundedBall extends MovableBall{
    Rectangle bounds;

    public BoundedBall(int x, int y, int radius, Color color){
        super(x, y, radius, DEFAULT_COLOR);
        Rectangle bounds = new Rectangle(getX()-getRadius(), getY()-getRadius(), 2*getRadius(), 2*getRadius());
    }
    public BoundedBall(int x, int y, int radius){
        super(x, y, radius);
        Rectangle bounds = new Rectangle(getX()-getRadius(), getY()-getRadius(), 2*getRadius(), 2*getRadius());
    }

    public Rectangle getBounds(Ball ball) {
        return bounds;
    }
    public boolean isOutOfBounds() {
        Rectangle region = new Rectangle(getX()-getRadius(), getY()-getRadius(), 2*getRadius(), 2*getRadius());
        Rectangle intersection = bounds.intersection(region);
        return region.getWidth() != intersection.getWidth() || region.getHeight() != intersection.getHeight();
    }
    public void move(){
        if(isOutOfBounds()){
            bounce();
        }
    }
    public void bounce(){
        if(isOutOfBounds()){
            setDx(-getDx());
            setDy(-getDy());
        }
    }
}
