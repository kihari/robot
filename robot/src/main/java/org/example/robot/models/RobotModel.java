package org.example.robot.models;

public class RobotModel {
    private int x;
    private int y;
    private Direction direction;

    public RobotModel(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "RobotModel{" +
                "x=" + x +
                ", y=" + y +
                ", direction=" + direction +
                '}';
    }
}

