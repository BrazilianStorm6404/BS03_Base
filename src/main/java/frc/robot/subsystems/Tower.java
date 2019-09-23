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
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class Tower extends Subsystem {
  

  public Spark spark;
  public DigitalInput limitUp;
  public DigitalInput limitDown;


  public Tower(){
  
    spark = new Spark(RobotMap.ELEVATOR);

    limitUp = new DigitalInput(RobotMap.LIMIT_TOWER_UP);
    limitDown = new DigitalInput(RobotMap.LIMIT_TOWER_DOWN);

  }

  
  public void move(double vel){
    //corrigir
    if (false) { 
      stop();
    } else {
      double potencia = vel;
      spark.set(potencia);
    }
    
  }
  
  public void stop() {
    spark.set(0);
  }


  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new MoveTower()); 
   }
}