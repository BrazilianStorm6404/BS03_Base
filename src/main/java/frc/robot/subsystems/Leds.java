/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Leds extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  DigitalOutput fitaVerde;
  DigitalOutput fitaBranca;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public Leds(){
    fitaVerde = new DigitalOutput(RobotMap.GREEN_LED_TAPE);
    fitaBranca = new DigitalOutput(RobotMap.WHITE_LED_TAPE);
  }

  public void GreenTapeOn(){
    fitaVerde.set(true);
  }
  
  public void GreenTapeOff(){
    fitaVerde.set(false);
  }

  public void WhiteTapeOn(){
    fitaBranca.set(true);
  }
  
  public void WhiteTapeOff(){
    fitaBranca.set(false);
  }

}
