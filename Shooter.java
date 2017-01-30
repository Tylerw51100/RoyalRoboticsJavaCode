package org.usfirst.frc.team3359.robot;

import java.lang.Math;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 * Class used to enable shooter and find location and speed.
 * @author tylerwetherington
 *
 */
public class Shooter extends Subsystem {
	//possible use of ultrasonic range finder to change shooter power and location.
	
	public Shooter(){

	}
	
	/** This method calculates the shooter ramp angle given the distance
	 * to the base of the boiler and the height of...
	 * 
	 * @param distance
	 * @param objHeight
	 * 
	 * @return double - Angle setpoint for the CAN Talon ramp motor
	 */
	public double getAngle(double distance, double objHeight){
	  rampAngle = Math.atan(objHeight / distance);
	  return rampAngle;
	}
	
	double rampAngle = 0;

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public boolean isUpToSpeed() {
		// TODO method stub
		return false;
	}
	
	public boolean isAngleSet() {
		// TODO method stub;
		return false;
	}
	
	public void openGate() {
		// TODO method stub;
	}
	
	public void closeGate() {
		// TODO method stub;
	}
	
	/** Sets the PID setpoint for the CAN Talon ramp motor.  The CAN Talon 
	 * will vary the power to the motor until its sensor reads the setpoint
	 * value
	 * 
	 * @param angle
	 */
	public void setShooterAngle(double angle) {
		// TODO method stub
	}
	
	/** Sets the PID setpoint for the CAN Talon speed motor.  The CAN Talon
	 * will vary the power to the motor until its sensor reads the setpoint
	 * value
	 * 
	 * @param speed
	 */
	public void setShooterSpeed(double speed) {
		// TODO method stub
	}
	
	/** this method will turn on the shooter motor, and the shooter angle is at the 
	 * angle setpoint for the shooter angle, but will not open the gate
	 */
	public void enable() {
		// TODO method stub
	}
	
	public void disable() {
		// TODO method stub;
	}
}