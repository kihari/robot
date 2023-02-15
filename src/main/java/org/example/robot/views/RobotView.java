package org.example.robot.views;

import lombok.RequiredArgsConstructor;

import java.io.InputStream;
import java.util.Scanner;

@RequiredArgsConstructor
public class RobotView {

    private final InputStream source;

    public Scanner scanCommands() {
        return new Scanner(this.source);
    }

    public void outputResult() {

    }
}
