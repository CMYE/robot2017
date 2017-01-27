package org.usfirst.frc.team6758.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.TalonSRX;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap  extends IterativeRobot {
	//Motorbinds for the robot for mecanumdrive
	public static int leftfrontmotor = (0);
	public static int rightfrontmotor = (1);
	public static int leftbackmotor = (2);
	public static int rightbackmotor = (3);
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
