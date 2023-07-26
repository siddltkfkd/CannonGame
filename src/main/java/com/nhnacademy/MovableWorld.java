package com.nhnacademy;

public class MovableWorld extends World {
    int dt=0;
    int maxMoveCount;
    int moveCount;

    public MovableWorld(int maxMoveCount){
        super();
        moveCount = 0;
        this.maxMoveCount = maxMoveCount;
    }

    public void reset(){
        moveCount = 0;
    }
    public int getMoveCount() {
        return moveCount;
    }
    public int getMaxmovecount() {
        return maxMoveCount;
    }
    public void setMaxMoveCount(int maxMoveCount) {
        this.maxMoveCount = maxMoveCount;
    }
    public int getDt() {
        return dt;
    }
    public void setDt(int dt) {
        this.dt = dt;
    }

    public void move(){
        for(int i=0; i<getBallCount(); i++){
            Ball ball = getBall(i);
            if(ball instanceof MovableBall){
                ((MovableBall)ball).move();
                moveCount++;
            }
        }
        repaint();
    }
    
    public void run(){
        for(int i=0; i<maxMoveCount || maxMoveCount==0; i++){
            move();
            try {
                Thread.sleep(getDt());
            } catch(InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
