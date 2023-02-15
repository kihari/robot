package org.example.robot.configs;

import org.example.robot.controllers.RobotController;
import org.example.robot.models.RobotModel;
import org.example.robot.models.service.RobotService;
import org.example.robot.views.RobotView;

public class RobotApp {

    private static RobotController robotController;
    public static void run() {
        while (true) {
            robotController = new RobotController(
                    new RobotView(System.in),
                    new RobotService(RobotModel.getStartingRobot())
            );

              try {
                  robotController.parseCommands();
                  robotController.sendResult();
              } catch (Exception e) {
                  System.out.println("ERROR: Unexpected symbol");
              }
        }
    }
}
