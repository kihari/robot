package org.example.robot.views;

import lombok.RequiredArgsConstructor;
import org.example.robot.models.RobotModel;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

@RequiredArgsConstructor
public class RobotView {

    private final InputStream source;

    public Scanner scanCommands() {
        return new Scanner(this.source);
    }

    public void outputResult(List<RobotModel> statesList) {
        for (var state : statesList) {
            System.out.println(state);
        }
    }
}
