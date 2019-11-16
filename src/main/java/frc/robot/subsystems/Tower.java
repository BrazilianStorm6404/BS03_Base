/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.MoveTower;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;



public class Tower extends Subsystem {
  
  public VictorSPX tower;
  public DigitalInput limitUp;
  public DigitalInput limitDown;


  public Tower(){
    tower = new VictorSPX(RobotMap.ELEVATOR);

    limitUp = new DigitalInput(RobotMap.LIMIT_TOWER_UP);
    limitDown = new DigitalInput(RobotMap.LIMIT_TOWER_DOWN);
  }

  public void move(double vel){
    tower.set(ControlMode.PercentOutput, vel);
  }
  
  public void stop() {
    tower.set(ControlMode.PercentOutput, 0);
  }


  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new MoveTower()); 
   }
}