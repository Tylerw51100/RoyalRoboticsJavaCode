package org.usfirst.frc.team3359.robot;

public abstract class Parameters {
	
	/** Percentage of power to use when lifting the robot... 1.0 = 100% */
	public static final double LIFT_POWER = 1.0;
	
	public static final double LIFT_VOLTAGE_RAMP_RATE = 12.0;
		
	public enum CanId {
		
		/** CAN ID of the Talon SRX for the left-side master CAN Talon */
		DRIVE_LEFT_MASTER(1, true),
		
		/** CAN ID of the Talon SRX for the right-side master CAN Talon*/
		DRIVE_RIGHT_MASTER(2, false),
		
		/** CAN ID of the Talon SRX for the left-side master CAN Talon */
		DRIVE_LEFT_FOLLOWER(3, true),
		
		/** CAN ID of the Talon SRX for the right-side follower CAN Talon */
		DRIVE_RIGHT_FOLLOWER(4, false),
		
		/** CAN ID of the Talon SRX for the lift master CAN Talon */
		LIFT_MASTER_MOTOR(5, false),
		
		/** CAN ID of the Talon SRX for the lift follower CAN Talon */
		LIFT_FOLLOWER_MOTOR(6, false),
		
		/** CAN ID of the Talon SRX for the shooter angle CAN Talon */
		SHOOTER_ANGLE_MOTOR(7, false),
		
		/** CAN ID of the Talon SRX for the shooter speed CAN Talon */
		SHOOTER_SPEED_MOTOR(8, false);
		
		private int canId;
		
		private boolean reversed;
		
		private CanId(int id, boolean rev) {
			canId = id;
			reversed = rev;
		}
		
		public int getId() {
			return canId;
		}
		
		public boolean isReversed() {
			return reversed;
		}
	}
	
	public enum Button {
		
		/** Button used to enable the shooter.  This will be the trigger button on
		 * the right joystick.
		 */
		SHOOTER_BUTTON(1),
		
		/** Button used to enable the lift. */
		LIFT_BUTTON(4);
		
		private int button;
		
		private Button(int buttonNum) {
			button = buttonNum;
		}
		
		public int getButton() {
			return button;
		}
	}
}
