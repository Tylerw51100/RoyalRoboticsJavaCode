package org.usfirst.frc.team3359.robot;

import com.ctre.CANTalon;


/**
 * Class used to enable lift
 * @author tylerwetherington
 *
 */
public class Lift{
  
  //Motor CH.
  public final static int LIFT_MOTOR = 4;
  
  /**
   * This holds the liftMotor CANTalon object.
   */
  private static CANTalon liftMotor = new CANTalon(LIFT_MOTOR);
  
	public Lift(){
		
	}
	
	public void enableLift(boolean isEnabled){
	  if(isEnabled == true){
	    liftMotor.set(1.0)
	  }
	}
}