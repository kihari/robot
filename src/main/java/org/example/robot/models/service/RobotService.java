package org.example.robot.models.service;
import org.example.robot.models.Direction;
import org.example.robot.models.RobotModel;

import java.util.Hashtable;

public class RobotService {


    public RobotModel moveForward(RobotModel robotModel, Direction direction, int length) {

        if (direction == Direction.NORTH || direction == Direction.SOUTH) {
            robotModel.setY(robotModel.getY() + length);
        } else {
            robotModel.setX(robotModel.getX() + length);
        }
        return robotModel;
    }

   /* public RobotModel move(int dX, int dY) {
        robotModel.setX(dX);
        robotModel.setDirection();
    }*/

    public void move(int dX, int dY, RobotModel robotModel) {

        int finalX = robotModel.getX() + dX;
        int finalY = robotModel.getY() + dY;

        switch (robotModel.getDirection()) {

            case NORTH:
                if (finalY <= robotModel.getY()) {
                    if (finalX < robotModel.getX()) robotModel.setDirection(Direction.WEST);
                    else if (finalX == robotModel.getX()) robotModel.setDirection(Direction.SOUTH);
                    else robotModel.setDirection(Direction.EAST);
                }
            case EAST:
                //
            case SOUTH:
                //
            case WEST:
            default:
        }

    }
}
