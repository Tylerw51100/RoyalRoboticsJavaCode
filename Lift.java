package org.usfirst.frc.team3359.robot;

import com.ctre.CANTalon;
import org.usfirst.frc.team3359.robot.Parameters;
import org.usfirst.frc.team3359.robot.Parameters.CanId;


/**
 * Class used to enable lift
 * @author tylerwetherington
 *
 */
public class Lift{

	/**
	 * This holds the liftMotor master CANTalon object.
	 */
	private static CANTalon liftMasterMotor = new CANTalon(CanId.LIFT_MASTER_MOTOR.getId());

	/**
	 * This holds the follower liftMotor CANTalon object.
	 */
	private static CANTalon liftFollowerMotor = new CANTalon(CanId.LIFT_FOLLOWER_MOTOR.getId());  
	public Lift() {
		liftMasterMotor.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		liftMasterMotor.setVoltageRampRate(Parameters.LIFT_VOLTAGE_RAMP_RATE);
		liftFollowerMotor.changeControlMode(CANTalon.TalonControlMode.Follower);
		liftFollowerMotor.set(CanId.LIFT_MASTER_MOTOR.getId());
		liftMasterMotor.enable();
		liftFollowerMotor.enable();
	}

	public void enableLift(boolean isEnabled){
		if(isEnabled == true){
			liftMasterMotor.set(Parameters.LIFT_POWER);
		} else {
			liftMasterMotor.set(0.0);
		}
	}
}