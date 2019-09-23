package frc.robot;

/**
 * This class is used to declare sensors, controllers and the shuffleboard.
 * Don't ask about the shuffleboard. Seriously, just don't.
 */
public class RobotMap {

  
  /**
   * Joystick port.
  */

  public static final int XBOX_CONTROL_MECHANISM = 1;

  public static final int XBOX_CONTROL_DRIVER = 0;

  
  /**
   * Drivetrain controllers ports.
   */
  public static final int MOTOR_FRONT_LEFT = 3;

  public static final int MOTOR_BACK_LEFT = 2;

  public static final int MOTOR_FRONT_RIGHT = 1;

  public static final int MOTOR_BACK_RIGHT = 0;

  /**
   * VictorSPX port (cargo deployment).
   */
  public static final int CLAW_CARGO = 14;
	
  /**
   * VictorSPX port (claw mode).
   */
  public static final int CLAW_CONTROL = 4;
  
  public static final int ELEVATOR = 12;

  /**
   * Tower limit's
   */
  /*
  public static final int LIMIT_TOWER_UP = 8;

  public static final int LIMIT_TOWER_DOWN = 9;
  */

  /**
   * Claw limit's
   */
  public static final int LIMIT_CLAW_DOWN = 1;

  public static final int LIMIT_CLAW_UP = 0;

}
