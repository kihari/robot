package org.example.robot.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class RobotModel {
    private int x;
    private int y;
    private Direction direction;

    public RobotModel(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
}

