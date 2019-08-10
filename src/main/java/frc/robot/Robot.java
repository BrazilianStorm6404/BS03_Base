package frc.robot;

import org.opencv.core.Mat;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
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

  Thread visionThread = new Thread(() -> { 
    UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
    camera.setResolution(640, 320);
  
    CvSink cvSink = CameraServer.getInstance().getVideo();
    CvSource outStream = CameraServer.getInstance().putVideo("Alinhamento", 640, 320);
    
    boolean draw = true; // não condiz com a realidade, apenas teste
    int angle = 10; // não condiz com a realidade e será usado apenas para testes
    Mat mat = new Mat();
    
    while (!Thread.interrupted()) { 
      if (cvSink.grabFrame(mat) == 0) {
        // Send the output the error.
        outStream.notifyError(cvSink.getError());
        // skip the rest of the current iteration
        continue;
      }
      // inserir todo o código de alinhamento.
      outStream.putFrame(mat);
    }
  });

  @Override
  public void robotInit() {

    m_drive = new Drivetrain();
    m_tower = new Tower();
    m_claw = new Claw();
    m_oi = new OI();

    //RobotMap.Sensors.navX.reset();
  }

  @Override
  public void robotPeriodic() {

    SmartDashboard.putBoolean("limitDown",m_tower.limitDown.get());
    SmartDashboard.putBoolean("limitUp",m_tower.limitUp.get());
    
    SmartDashboard.putNumber("X",m_oi.driverController.getX());

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
