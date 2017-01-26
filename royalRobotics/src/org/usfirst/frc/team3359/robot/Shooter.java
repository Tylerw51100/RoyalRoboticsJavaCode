package org.usfirst.frc.team3359.robot;

import java.lang.Math;

public final static double OBJECT_HEIGHT = 15.5;

double rampAngle = 0;
/**
 * Class used to enable shooter and find location and speed.
 * @author tylerwetherington
 *
 */
public class Shooter{
	//possible use of ultrasonic range finder to change shooter power and location.
	
	public Shooter(){
		
	}
	
	public double getAngle(){
	  rampAngle = atan(OBJECT_HEIGHT / distance);
	  return rampAngle;
	}
}