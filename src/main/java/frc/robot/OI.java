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
    Button buttonX = new JoystickButton(driverController, 3);
    Button buttonY = new JoystickButton(driverController, 4); 
    
    private static int angle = 45;

    public static void setAngle(int angle) {
        OI.angle = angle;
    } 

    public static int getAngle(){
        return OI.angle;
    }

    /**
     * <p> Sets the {@link Button} Config and what method it activates in what state </p>
     */
    public OI(){

        
        //Garra
        //buttonY.whileHeld(new ForwardRelay());
        //buttonY.whenReleased(new BackwardsRelay());
        
        buttonB.whileHeld(new DropCargo()); 
        buttonB.whenReleased(new StopCargo());

        buttonA.whileHeld(new PullCargo());  
        buttonA.whenReleased(new StopCargo());
    }
}
