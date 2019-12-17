package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.subsystems.*;


public class Robot extends TimedRobot {

  public static Drivetrain m_drive;
  public static Claw m_claw;
  public static Tower m_tower;
  public static OI m_oi;
  public static Leds m_Leds;
  public static ShuffleboardTab tab_autonomo;
  public static NetworkTableEntry entryAngulo, entryDistance, entryTolerance;
  @Override
  public void robotInit() {

    m_drive = new Drivetrain();
    m_tower = new Tower();
    m_claw = new Claw();
    m_Leds = new Leds();    
    //Deve sempre ser o último, possível problema de inicialização
    m_oi = new OI();

    tab_autonomo = Shuffleboard.getTab("Autonomo");
    entryAngulo = tab_autonomo.add("Angulo", 0).getEntry();
    entryDistance = tab_autonomo.add("Distance", 0).getEntry();
    entryTolerance = tab_autonomo.add("Tolerance", 0).getEntry();
    UsbCamera camera = CameraServer.getInstance().startAutomaticCapture(0);
    UsbCamera camera2 = CameraServer.getInstance().startAutomaticCapture(1);
    camera.setResolution(640, 320);
    camera2.setResolution(640, 320);
  }

  @Override
  public void robotPeriodic() {
    SmartDashboard.putBoolean("limitDown",m_claw.limitDown.get());
    SmartDashboard.putBoolean("limitUp",m_claw.limitUp.get());
    SmartDashboard.putBoolean("Led Verde", m_Leds.fitaVerde.get());
    SmartDashboard.putBoolean("Led Branco", m_Leds.fitaBranca.get());
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
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
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
    //Deploing autonomus tests here
    Robot.m_drive.arcadeDrive(-0.6, Robot.m_drive.pidOutput);
  }
}