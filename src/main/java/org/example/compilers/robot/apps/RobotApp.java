package org.example.compilers.robot.apps;

import org.example.compilers.robot.controllers.RobotController;
import org.example.compilers.robot.models.RobotModel;
import org.example.compilers.robot.models.service.RobotService;
import org.example.compilers.robot.views.RobotView;

import java.rmi.NotBoundException;

public class RobotApp {

    private static RobotController robotController;
    public static void run() {
        robotController = new RobotController(
                new RobotView(System.in),
                new RobotService(RobotModel.getStartingRobot())
        );

        while (true) {
              try {
                  robotController.parseCommands();
                  robotController.sendResult();
              } catch (IllegalArgumentException e) {
                  System.out.println("ERROR: Unexpected symbol");
              } catch (NotBoundException e) {
                  System.out.println("ERROR: No terminating symbol");
              }
        }
    }
}
