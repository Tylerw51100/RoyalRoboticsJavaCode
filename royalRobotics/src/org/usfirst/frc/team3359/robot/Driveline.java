package org.usfirst.frc.team3359.robot;

import com.ctre.CANTalon;


/**
 * Class to control driving and drive motors 
 * @author tylerwetherington
 *
 */
public class Driveline{
	//Motor CH.
	  public final static int LEFT_MASTER_MOTOR = 0;
	  public final static int RIGHT_MASTER_MOTOR = 1;
	  public final static int LEFT_FOLLOWER_MOTOR = 2;
	  public final static int RIGHT_FOLLOWER_MOTOR = 3;
	  
	  public static final boolean LEFT_REVERSED = true;
	  public static final boolean RIGHT_REVERSED = false;

	  //Motors
	  private static CANTalon leftMasterMotor = new CANTalon(RIGHT_MASTER_MOTOR);
	  private static CANTalon rightMasterMotor = new CANTalon(RIGHT_MASTER_MOTOR);
	  private static CANTalon leftFollowerMotor = new CANTalon(LEFT_FOLLOWER_MOTOR);
	  private static CANTalon rightFollowerMotor = new CANTalon(RIGHT_FOLLOWER_MOTOR);

	  private final static double RAMP_RATE = 12.0;

	  /**
	   * Initilizes the Driveline object.  Places each follower motor
	   * in follower mode.  
	   */
	  public Driveline() {
		  leftMasterMotor.setInverted(LEFT_REVERSED);
		  leftMasterMotor.enableBrakeMode(true);
		  leftMasterMotor.setVoltageRampRate(RAMP_RATE);
		  rightMasterMotor.setInverted(RIGHT_REVERSED);
		  rightMasterMotor.enableBrakeMode(true);
		  leftFollowerMotor.changeControlMode(CANTalon.TalonControlMode.Follower);
		  leftFollowerMotor.set(LEFT_MASTER_MOTOR);
		  rightFollowerMotor.changeControlMode(CANTalon.TalonControlMode.Follower);
		  rightFollowerMotor.set(RIGHT_FOLLOWER_MOTOR);
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