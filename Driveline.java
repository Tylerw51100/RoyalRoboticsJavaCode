package org.usfirst.frc.team3359.robot;

import com.ctre.CANTalon;
import org.usfirst.frc.team3359.robot.Parameters.CanId;

/**
 * Class to control driving and drive motors 
 * @author tylerwetherington
 *
 */
public class Driveline{


	  //Motors
	  private static CANTalon leftMasterMotor = new CANTalon(CanId.DRIVE_LEFT_MASTER.getId());
	  private static CANTalon rightMasterMotor = new CANTalon(CanId.DRIVE_RIGHT_MASTER.getId());
	  private static CANTalon leftFollowerMotor = new CANTalon(CanId.DRIVE_LEFT_FOLLOWER.getId());
	  private static CANTalon rightFollowerMotor = new CANTalon(CanId.DRIVE_RIGHT_FOLLOWER.getId());

	  private final static double RAMP_RATE = 12.0;

	  /**
	   * Initilizes the Driveline object.  Places each follower motor
	   * in follower mode.  
	   */
	  public Driveline() {
		  leftMasterMotor.setInverted(CanId.DRIVE_LEFT_FOLLOWER.isReversed());
		  leftMasterMotor.enableBrakeMode(true);
		  leftMasterMotor.setVoltageRampRate(RAMP_RATE);
		  rightMasterMotor.setInverted(CanId.DRIVE_RIGHT_FOLLOWER.isReversed());
		  rightMasterMotor.enableBrakeMode(true);
		  leftFollowerMotor.changeControlMode(CANTalon.TalonControlMode.Follower);
		  leftFollowerMotor.set(CanId.DRIVE_LEFT_MASTER.getId());
		  rightFollowerMotor.changeControlMode(CANTalon.TalonControlMode.Follower);
		  rightFollowerMotor.set(CanId.DRIVE_RIGHT_MASTER.getId());
	  }
	  
	/**
	 * Sets the power to the driveline's motors.
	 * 
	 * @param leftPower - percentage of power for the left two motors as a
	 * 				percentage in the range -1.0 .. 0 .. 1.0 where a postive
	 * 				value is forward and a negative value is reverse (and
	 * 				zero stops the drive) 
	 * @param rightPower - percentage of power for the right two motors as a
	 * 				percentage in the range -1.0 .. 0 .. 1.0 where a postive
	 * 				value is forward and a negative value is reverse (and
	 * 				zero stops the drive) 
	 */
	public void setDrivePower(double leftPower, double rightPower){
		leftMasterMotor.set(leftPower);
		rightMasterMotor.set(rightPower);
	}
}