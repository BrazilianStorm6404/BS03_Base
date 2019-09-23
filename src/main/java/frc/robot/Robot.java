package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Tower;


public class Robot extends TimedRobot {
  public static Drivetrain m_drive;
  public static Claw m_claw;
  public static Tower m_tower;
  public static OI m_oi;

  @Override
  public void robotInit() {

    m_drive = new Drivetrain();
    m_tower = new Tower();
    m_claw = new Claw();
    m_oi = new OI();
    UsbCamera camera = CameraServer.getInstance().startAutomaticCapture(0);
    UsbCamera camera2 = CameraServer.getInstance().startAutomaticCapture(1);
    camera.setResolution(640, 320);
    camera2.setResolution(640, 320);
  }

  @Override
  public void robotPeriodic() {
    SmartDashboard.putBoolean("limitDown",m_claw.limitDown.get());
    SmartDashboard.putBoolean("limitUp",m_claw.limitUp.get());
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
  }

  @Override
  public void testPeriodic() {
  }
}