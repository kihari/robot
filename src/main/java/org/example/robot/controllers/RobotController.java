package org.example.robot.controllers;

import lombok.RequiredArgsConstructor;
import org.example.robot.models.RobotModel;
import org.example.robot.models.service.RobotService;
import org.example.robot.views.RobotView;

import java.util.LinkedList;
import java.util.List;

@RequiredArgsConstructor
public class RobotController {

    private final RobotView robotView;
    private final RobotService robotService;

    private List<RobotModel> statesList = new LinkedList<>();

    private void addRobotState(RobotModel robotState) {
        RobotModel emptyRobot = RobotModel.getEmptyRobot();

        emptyRobot.setX(robotState.getX());
        emptyRobot.setY(robotState.getY());
        emptyRobot.setDirection(robotState.getDirection());

        statesList.add(emptyRobot);
    }

    public void parseCommands() throws Exception {
        char[] commands = robotView
                .scanCommands()
                .next()
                .toCharArray();

        for (char command : commands) {
            RobotModel robotState;
            switch (command) {
                case 'f' -> {
                    robotState = robotService.moveForward();
                    addRobotState(robotState);
                }
                case 'r' -> {
                    robotState = robotService.turnRight();
                    addRobotState(robotState);
                }
                case 'l' -> {
                    robotState = robotService.turnLeft();
                    addRobotState(robotState);
                }
/*                case ' ' -> { continue;}
                case '.' -> {break;}*/
                default ->
                    throw new Exception();
            }
        }
    }

    public void sendResult() {
        robotView.outputResult(statesList);
    }
}
