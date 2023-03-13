package org.example.compilers;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.example.compilers.robot.controllers.RobotController;
import org.example.compilers.robot.models.RobotModel;
import org.example.compilers.robot.views.RobotView;

import java.util.LinkedList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite(RobotController.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void testOutputAsTable() {
        List<RobotModel> list = new LinkedList<>();
        list.add(RobotModel.getStartingRobot());
        RobotView robotView = new RobotView(System.in);

        robotView.outputResultAsTable(list, 9, 9);
    }
}
