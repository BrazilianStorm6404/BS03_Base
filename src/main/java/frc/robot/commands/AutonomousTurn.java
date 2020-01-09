/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class AutonomousTurn extends Command {
  double sp;
  public AutonomousTurn(double setpoint) {
    requires(Robot.m_drive);
    sp = setpoint;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.m_drive.navX.reset();
    Robot.m_drive.setSetpoint(sp);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.m_drive.arcadeDrive(0, Robot.m_drive.pidOutput);
  }

  public boolean approximatelyEqual(double desiredValue, float actualValue, float tolerancePercentage) {
    float diff = (float) Math.abs(Math.abs(desiredValue) - Math.abs(actualValue));         
    float tolerance = (float) (tolerancePercentage / 100 * Math.abs(desiredValue));
    return diff < tolerance;                                   
  }
  
  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return approximatelyEqual(sp, Robot.m_drive.getVirtualYaw(), 1);
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    int aux = (int) SmartDashboard.getNumber("fim", 0);
    SmartDashboard.putNumber("fim",aux+1);
    
    Robot.m_drive.setSetpoint(0);
    Robot.m_drive.enc.reset();
    Robot.m_drive.resetVirtualEncoder();
  }
  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
