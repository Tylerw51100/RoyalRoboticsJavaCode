package org.usfirst.frc.team3359.robot;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3359.robot.Shooter;

public class EnableShooter extends Command {

	private Shooter shooter;
	
	public EnableShooter(Shooter shooterSubsystem) {
		shooter = shooterSubsystem;
	}
	
	@Override
	protected void initialize() {
		
	}
	
	/** This command must set the shooter angle and bring the shooter motor
	 * up to speed in parallel, once both are complete it must open the 
	 * pneumatic piston gate to allow fuel to flow into the shooter.
	 */
	@Override
	protected void execute() {
//		shooter.setShooterAngle(shooter.getAngle(distance, objHeight));
		shooter.enable();
		
	}
	
	@Override 
	public boolean isFinished() {
		if ( shooter.isUpToSpeed() && shooter.isAngleSet()) {
			shooter.openGate();
			return true;
		}
		return false;
	}
}
