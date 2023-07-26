package com.nhnacademy;

import java.awt.Color;

public class MovableBall extends Ball{
    private int dx=0;
    private int dy=0;

    public MovableBall(int x, int y, int radius, Color color){
        super(x, y, radius, color);
    }
    public MovableBall(int x, int y, int radius){
        super(x, y, radius);
    }

    public int getDx() {
        return dx;
    }
    public int getDy() {
        return dy;
    }
    public void setDx(int dx) {
        this.dx = dx;
    }
    public void setDy(int dy) {
        this.dy = dy;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }

    public void move() {
        setX(getX()+getDx());
        setY(getY()+getDy());
    }
    public void moveTo(int x, int y){
        setX(x);
        setY(y);
    }
}
