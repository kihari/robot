package org.example.robot.controllers;

import lombok.RequiredArgsConstructor;
import org.example.robot.views.RobotView;

@RequiredArgsConstructor
public class RobotController {

    private final RobotView robotView;

    private char[] commands = robotView
            .scanCommands()
            .next()
            .toCharArray();

    public void parseCommands() {
        for (char command : commands) {

        }
    }
}
