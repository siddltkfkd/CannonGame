package com.nhnacademy;
import java.awt.Color;
import java.awt.Graphics;

public class Ball {
    int x;
    int y;
    int radius;
    Color color;
    static final Color DEFAULT_COLOR = Color.BLUE;

    public Ball(int x, int y, int radius, Color color){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }
    public Ball(int x, int y, int radius){
        this(x, y, radius, DEFAULT_COLOR);
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getRadius() {
        return radius;
    }
    public Color getColor() {
        return color;
    }
    public void paint(Graphics graphics) {
        Color oldColor = graphics.getColor();
        graphics.setColor(getColor());
        graphics.fillOval(getX()-getRadius(), getY()-getRadius(), 2*getRadius(), 2*getRadius());
        graphics.setColor(oldColor);
    }
}
