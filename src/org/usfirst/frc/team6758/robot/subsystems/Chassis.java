package org.usfirst.frc.team6758.robot.subsystems;

import org.usfirst.frc.team6758.robot.RobotMap;
import org.usfirst.frc.team6758.robot.commands.JoystickDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

	public class Chassis extends Subsystem
	{
		//Setting chassis motors to CANTalon IDs
		static CANTalon FRMotor = new CANTalon(RobotMap.talonDevIDChassisFrontRight);
		static CANTalon BRMotor = new CANTalon(RobotMap.talonDevIDChassisBackRight);
		
		static CANTalon FLMotor = new CANTalon(RobotMap.talonDevIDChassisFrontLeft);
		static CANTalon BLMotor = new CANTalon(RobotMap.talonDevIDChassisBackLeft);

		// Creates robot drive configuration with four motors
		static RobotDrive chassisDrive = new RobotDrive(motorChassisFrontLeft,motorChassisBackLeft,motorChassisFrontRight,motorChassisBackRight);
		
		public Chassis() {
			
			super();
			//chassisDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
			//chassisDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
			// Set a timeout for the motors (1 seconds)
			chassisDrive.setSafetyEnabled(true);
			chassisDrive.setExpiration(1);
		}
		public void initDefaultCommand () {
			setDefaultCommand(new JoystickDrive());
		}
		
		private void setDefaultCommand(JoystickDrive joystickDrive) {
			// TODO Auto-generated method stub
			
		}
		public void driveWithJoystick(Joystick joystickP0) {
			// Get raw values from joystick controller
			double yAxis = joystickP0.getY();
			double xAxis = joystickP0.getX();
			double twist = joystickP0.getTwist();
			//double fakeYAxis = -twist;
			//double fakeTwist = -yAxis;
			
			// Apply translations to the values from the controller
			//fakeTwist = (RobotMap.pMode) ? ThrottleLookup.calcJoystickCorrection("FakeSlowT", fakeTwist) : ThrottleLookup.calcJoystickCorrection("FakeNormT", fakeTwist);
			//fakeYAxis = (RobotMap.pMode) ? ThrottleLookup.calcJoystickCorrection("FakeSlowY", fakeYAxis) : ThrottleLookup.calcJoystickCorrection("FakeNormY", fakeYAxis); 
			
			
			SmartDashboard.putString("ROBOT MODE", (RobotMap.pMode) ? "Slow" : "Normal");	
					
			SmartDashboard.putNumber("JoystickY", yAxis);
			SmartDashboard.putNumber("JoystickX", xAxis);
			SmartDashboard.putNumber("JoystickTwist", twist);
			SmartDashboard.putBoolean("Precision Mode", RobotMap.pMode);
			//NetworkTable.getTable("SmartDashboard").putNumber("timel", 1);
			
			//left/right, forward/backward, turning, gyro (none)
			//chassisDrive.mecanumDrive_Cartesian(xAxis, fakeYAxis, fakeTwist, 0);
			chassisDrive.arcadeDrive(-yAxis, -twist);
		}
		
		public void DriveStraight(double inputSpeed)
		{
			//motorChassisRight.changeControlMode(ControlMode.Speed);
			//motorChassisLeft.changeControlMode(ControlMode.Speed);
			chassisDrive.arcadeDrive(inputSpeed,0);
		}
		
		public void DriveBackwards(double inputSpeed){		
			//motorChassisRight.changeControlMode(ControlMode.Speed);
			//motorChassisLeft.changeControlMode(ControlMode.Speed);
			chassisDrive.arcadeDrive(inputSpeed,0);
		}
		
		public void DriveStop(){
			chassisDrive.arcadeDrive(0,0);
		}
		
		public void DriveLeft(double inputSpeed){
			//motorChassisRight.changeControlMode(ControlMode.Speed);
			//motorChassisLeft.changeControlMode(ControlMode.Speed);
			chassisDrive.arcadeDrive(0,inputSpeed);
		}
		
		public void DriveRight(double inputSpeed){
		//	motorChassisRight.changeControlMode(ControlMode.Speed);
			//motorChassisLeft.changeControlMode(ControlMode.Speed);
			chassisDrive.arcadeDrive(0,-inputSpeed);
		}
	}