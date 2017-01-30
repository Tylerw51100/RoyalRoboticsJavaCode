package org.usfirst.frc.team3359.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3359.robot.Parameters;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	final String defaultAuto = "Default";
	final String customAuto = "My Auto";
	String autoSelected;
	SendableChooser<String> chooser = new SendableChooser<>();


	/**
	 * This attribute holds the robot's Driveline object.  It is used
	 * to control the robot's movement on the playing field.
	 */
	private Driveline driveline = null;

  /**
   * This attribute holds the robot's Lift object. It is used to
   * enable the robot's lift.
   */
  private Lift lift = null;
  
	/**
	 * This attribute holds the robot's left joystick object.
	 */
	private Joystick leftStick = null;

	/**
	 * This attribute holds the robot's right joystick object.
	 */
	private Joystick rightStick = null;
	
	/**
	 * This attribute holds the robot's lift button object.
	 */
	private Button shootButton = null;
	
	private Command enableShooter = null;
	
	private Shooter shooter = null;
	
	//Joysticks
	private final static int LEFT_JOYSTICK_PORT = 0;
	private final static int RIGHT_JOYSTICK_PORT = 1;

		
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		chooser.addDefault("Default Auto", defaultAuto);
		chooser.addObject("My Auto", customAuto);
		SmartDashboard.putData("Auto choices", chooser);

		driveline = new Driveline();
		lift = new Lift();
		leftStick = new Joystick(LEFT_JOYSTICK_PORT);
		rightStick = new Joystick(RIGHT_JOYSTICK_PORT);
		shootButton = new JoystickButton(leftStick, Parameters.Button.SHOOTER_BUTTON.getButton());
		shooter = new Shooter();
		enableShooter = new EnableShooter(shooter);
		
		// If joystick fire button pressed, turn on shooter.
//		shootButton.whenPressed(enableShooter);
//		shootButton.whenReleased(disableShooter);			
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the
	 * switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		autoSelected = chooser.getSelected();
		// autoSelected = SmartDashboard.getString("Auto Selector",
		// defaultAuto);
		System.out.println("Auto selected: " + autoSelected);
	}

	/**
	 * This code is executed once when the Field Management System (FMS)
	 * transitions from Autonomous to Teleoperated.
	 */
	@Override
	public void teleopInit() {
		// If joystick fire button pressed, turn on shooter.
//		shootButton.whenPressed(enableShooter);
//		shootButton.whenReleased(disableShooter);		
	}
	
	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {

		// If driving across baseline, control driveline


		switch (autoSelected) {
		case customAuto:
			// Put custom auto code here
			break;
		case defaultAuto:
		default:
			// Put default auto code here
			break;
		}
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		// If joystick was pushed, control driveline.
		driveline.setDrivePower(leftStick.getY(null), rightStick.getY(null));

		// Handle shooter
		shooterPeriodic();
		
		// If joystick lift button pressed, turn on turn on lift.
		if (leftStick.getRawButton(Parameters.Button.LIFT_BUTTON.getButton())) {
			lift.enableLift(true);
		} else {
			lift.enableLift(false);
		}
	}

	/**
	 * This function is called during the use of the shooter.
	 */
	private void shooterPeriodic() {
		if (leftStick.getRawButton(Parameters.Button.SHOOTER_BUTTON.getButton())) {
			shooter.enable();
			if (shooter.isUpToSpeed() && shooter.isAngleSet()) {
				shooter.openGate();
			}
		} else {
			shooter.disable();
		}			
	}
	
	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
	}
}

