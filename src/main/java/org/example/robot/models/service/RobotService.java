package org.example.robot.models.service;
import lombok.RequiredArgsConstructor;
import org.example.robot.models.Direction;
import org.example.robot.models.RobotModel;

import java.util.Hashtable;

public class RobotService {
    private RobotModel robotModel;

    public RobotService(RobotModel robotModel) {
        this.robotModel = robotModel;
    }

    public RobotModel moveForward() {
        switch (robotModel.getDirection()) {
            case NORTH -> robotModel.setY(robotModel.getY() + 1);
            case SOUTH -> robotModel.setY(robotModel.getY() - 1);
            case EAST -> robotModel.setX(robotModel.getX() + 1);
            case WEST -> robotModel.setX(robotModel.getX() - 1);
        }

        return this.robotModel;
    }

    public RobotModel turnRight() {
        switch (robotModel.getDirection()) {
            case NORTH -> robotModel.setDirection(Direction.EAST);
            case EAST -> robotModel.setDirection(Direction.SOUTH);
            case SOUTH -> robotModel.setDirection(Direction.WEST);
            case WEST -> robotModel.setDirection(Direction.NORTH);
        }
        return this.robotModel;
    }

    public RobotModel turnLeft() {
        switch (robotModel.getDirection()) {
            case NORTH -> robotModel.setDirection(Direction.WEST);
            case WEST -> robotModel.setDirection(Direction.SOUTH);
            case SOUTH-> robotModel.setDirection(Direction.EAST);
            case EAST -> robotModel.setDirection(Direction.NORTH);
        }
        return this.robotModel;
    }
}
