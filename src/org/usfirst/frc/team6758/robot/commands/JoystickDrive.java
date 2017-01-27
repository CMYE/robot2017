package org.usfirst.frc.team6758.robot.commands;

import org.usfirst.frc.team6758.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class  JoystickDrive extends Command{
	public JoystickDrive(){
		requires(Robot.chassis);
	}
protected void initialize(){}
	
	protected void execute()
	{
		Robot.chassis.JoystickDrive(Robot.oi.getStick());
	}
	
	protected boolean isFinished()
	{
		return false;
	}
	
	protected void end()
	{
		//Robot.chassis.driveWithJoystick(0,0);
	}
	
	protected void interrupted()
	{
	}	
	
}