package frc.robot;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.commands.AutonomousRoutine;
import frc.robot.subsystems.*;


public class Robot extends TimedRobot {

  public static Drivetrain m_drive;
  public static OI m_oi;
  public static Leds m_Leds;
  public static CommandGroup routine;
  public static Claw m_claw;
  public static Tower m_tower;
  public static ShuffleboardTab tab_autonomo;
  public static NetworkTableEntry entryAngulo, entryDistance, entryTolerance;
  @Override
  public void robotInit() {
    
    m_drive = new Drivetrain();
    m_claw = new Claw();
    m_Leds = new Leds();
    m_tower = new Tower();
    
    //Deve sempre ser o último, possível problema de inicialização
    m_oi = new OI();
    routine = new AutonomousRoutine();

    tab_autonomo = Shuffleboard.getTab("Autonomo");
    entryAngulo = tab_autonomo.add("Angulo", 0).getEntry();
    entryDistance = tab_autonomo.add("Distance", 0).getEntry();
    entryTolerance = tab_autonomo.add("Tolerance", 0).getEntry();
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    routine.start();
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    routine.cancel();
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testInit(){
    Robot.m_drive.navX.reset();
  }

  @Override
  public void testPeriodic() {
  }
}