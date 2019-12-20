package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;
/**
 * <p> the  {@link OI} is used to map the joystic to the controller </p>
 */
public class OI {

    public final Joystick driverController = new Joystick(RobotMap.XBOX_CONTROL_DRIVER);

    // We named the variables based on the xbox controller buttons
    Button buttonA = new JoystickButton(driverController, 1);
    Button buttonB = new JoystickButton(driverController, 2);
    Button buttonY = new JoystickButton(driverController, 4);
    Button buttonLB = new JoystickButton(driverController, 6);
    Button buttonRB = new JoystickButton(driverController, 5);

    //publico não é o padrão, alterar 
    public Button buttonX = new JoystickButton(driverController, 3);

    public OI(){
        buttonB.whileActive(new ShooterShoot());      
    }
}
