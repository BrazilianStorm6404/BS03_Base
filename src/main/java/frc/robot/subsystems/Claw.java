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
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.MoveClaw;

/**
 * Add your docs here.
 */
public class Claw extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  /**
   * Motor that controls cargo intake.
   */
  private VictorSP victorCargo;
  private VictorSP victorControl;

  /**
   * Solenoid that controls hatch panel intake.
   */
  //private DoubleSolenoid solenoidHatch; 

  //private DigitalInput limitCargo = RobotMap.Sensors.Claw.CargoLimit;
  //private DigitalInput limitHatchPanel = RobotMap.Sensors.Claw.HatchPanelLimit;

  private boolean hatchIsEnabled = true;
  private boolean cargoIsEnabled;
  
  @Override
  public void initDefaultCommand() {

    setDefaultCommand(new MoveClaw());

  }

  public Claw() { 

    victorCargo = new VictorSP(RobotMap.CLAW_CARGO);    
    //solenoidHatch = RobotMap.Controllers.Claw.solenoidHatch;
    victorControl    = new VictorSP(RobotMap.CLAW_CONTROL);

  }

  public void Move(double value){
    
    updateLimits();
    victorControl.set(value);

    /*s
    if(value < 0 && !cargoIsEnabled){
      victorControl.set(ControlMode.PercentOutput, value);
    }
    else if(value > 0 && !hatchIsEnabled){
      victorControl.set(ControlMode.PercentOutput, value);
    }
    else {
      victorControl.set(ControlMode.PercentOutput, 0);
    }
    */
  }

  public void pullCargo(){
    updateLimits();

     victorCargo.set(0.75); // Anything higher than 0.5 may break our mechanism.
    
  }

  public void dropCargo(){
    updateLimits();

     victorCargo.set(-0.8); // Anything higher than 0.5 may break our mechanism.
    
  }

  public void stopCargo(){
     victorCargo.set(0.0); 
  }

  public void ExtendHatch(){
    //updateLimits();

    //if(hatchIsEnabled){ 
      //solenoidHatch.set(Value.kForward); // This method raises the piston.
    //}
  }

  public void RecallHatch(){
    //updateLimits();

    //if(hatchIsEnabled){
      //solenoidHatch.set(Value.kReverse); // This method descends the piston.
    //}
  }

  private void updateLimits(){
    //hatchIsEnabled = limitHatchPanel.get();
    //cargoIsEnabled = limitCargo.get();
  }

}
