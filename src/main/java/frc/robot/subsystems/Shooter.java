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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.MoveShooter;

/**
 * Add your docs here.
 */
public class Shooter extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private DigitalOutput alfa;
  private DigitalOutput beta;
  private Spark booster;

  public Shooter(){
    alfa = new DigitalOutput(RobotMap.SHOOTER_ALFA);
    beta = new DigitalOutput(RobotMap.SHOOTER_BETA);
    booster = new Spark(RobotMap.SPARK_BOOSTER);
    
    stop();
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new MoveShooter());
  }
  
  public void moveDown(){
    alfa.set(false);
    beta.set(true);
    SmartDashboard.putBoolean("Subindo", false);
    SmartDashboard.putBoolean("Parado", false);
  } 

  public void moveUp(){
    alfa.set(true);
    beta.set(false);
    SmartDashboard.putBoolean("Subindo", true);
    SmartDashboard.putBoolean("Parado", false);
  }

  public void stop(){
    alfa.set(false);
    beta.set(false);
    SmartDashboard.putBoolean("Parado", true);
  }

  public void shoot(double force){
    booster.set(force);
  }
}
