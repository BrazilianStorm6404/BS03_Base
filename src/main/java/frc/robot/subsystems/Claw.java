/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;


public class Claw extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private VictorSPX victorCargo;
  private Spark victorControl;
  public DigitalInput limitUp;
  public DigitalInput limitDown;
  private final double cargoForce = 0.85;


  @Override
  public void initDefaultCommand() {

  }

  public Claw() { 
    victorCargo = new VictorSPX(RobotMap.CLAW_CARGO);    
    victorControl = new Spark(RobotMap.CLAW_CONTROL);

    limitUp = new DigitalInput(RobotMap.LIMIT_CLAW_UP);
    limitDown = new DigitalInput(RobotMap.LIMIT_CLAW_DOWN);
  }

  public void StopClaw (){
    victorControl.set(0);
  }

  public void ClawUp (){
    if (!limitUp.get()){
      victorControl.set(0.8);
    }
    else StopClaw();
  }

  public void ClawDown (){
    if (!limitDown.get()){
      victorControl.set(-0.45);
    }
    else StopClaw();
  }
  

  public void pullCargo(){
    victorCargo.set(ControlMode.PercentOutput, cargoForce); 
  }

  public void dropCargo(){
    victorCargo.set(ControlMode.PercentOutput, -cargoForce); 
  }

  public void stopCargo(){
     victorCargo.set(ControlMode.PercentOutput, 0.0); 
  }

}