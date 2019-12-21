package frc.robot;

/**
 * This class is used to declare sensors and controller ports.
 * Essa classe é usada para declarar portas de sensores e controladores.
 */
public class RobotMap {

  /**
   * Joystick port.
   * Portas de joystick. 
  */
  public static final int XBOX_CONTROL_DRIVER = 0;

  
  public static final int MOTOR_FRONTAL_DIREITO = 3;
  public static final int MOTOR_FRONTAL_ESQUERDO = 0;
  public static final int MOTOR_TRASEIRO_DIREITO = 4;

  // controlador arduino
  public static final int MOTOR_TRASEIRO_ESQUERDO_A = 6; // porta pwm para frente
  public static final int MOTOR_TRASEIRO_ESQUERDO_B = 7; // porta pwm para tras

  //pinos
  public static final int PINO_DA = 2;
  public static final int PINO_DB = 3; 

  //
  public static final int SHOOTER_ALFA = 1;

  public static final int SHOOTER_BETA = 0;

  public static final int SPARK_BOOSTER = 5;

}
