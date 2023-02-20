package org.example.robot.controllers;

import lombok.RequiredArgsConstructor;
import org.example.robot.models.RobotModel;
import org.example.robot.models.service.RobotService;
import org.example.robot.views.RobotView;

import java.rmi.NotBoundException;
import java.util.*;

@RequiredArgsConstructor
public class RobotController {

    private final RobotView robotView;
    private final RobotService robotService;

    private List<RobotModel> statesList = new LinkedList<>();

    private Map<Character, RobotModel> statesMap = new HashMap<>();

    private void addRobotState(RobotModel robotState, char command) {
        RobotModel emptyRobot = RobotModel.getEmptyRobot();

        emptyRobot.setX(robotState.getX());
        emptyRobot.setY(robotState.getY());
        emptyRobot.setDirection(robotState.getDirection());

        statesList.add(emptyRobot);
        statesMap.put(command, emptyRobot);
    }

    public void parseCommands() throws NotBoundException,  IllegalArgumentException{
        char[] commands = robotView
                .scanCommands()
                .next()
                .toCharArray();

        RobotModel robotState;

        for (char command : commands) {

            if (commands[commands.length-1] != '.') {
                throw new NotBoundException();
            }

            switch (command) {
                case 'f' -> {
                    robotState = robotService.moveForward();
                    addRobotState(robotState, command);
                }
                case 'r' -> {
                    robotState = robotService.turnRight();
                    addRobotState(robotState, command);
                }
                case 'l' -> {
                    robotState = robotService.turnLeft();
                    addRobotState(robotState, command);
                }
                case ';' -> {continue;}
                case '.' -> {}
                default ->
                    throw new IllegalArgumentException();
            }
        }
    }

    public void sendResult() {
        robotView.outputResultAsStatesList(statesList);

            /*robotView.outputResultAsTable(
                    statesList,
                    robotService.getHeight(),
                    robotService.getWidth()
            );*/

//        robotView.outputResultAsMap(statesMap);
    }
}
