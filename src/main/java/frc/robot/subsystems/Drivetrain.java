
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;

import frc.robot.commands.Drive;
import frc.robot.RobotMap;


/**
 * This subsystem includes all the motor controllers, variables and methods for the Drivetrain of the robot.
 * All motor controllers and sensors used in this subsystem are declared on the RobotMap.
 * We are using a PIDSubsytem to work with autonomous in the future.
 * 
 * More detailed descriptions for the methods are listed below.
 */
public class Drivetrain extends PIDSubsystem {

  private DifferentialDrive drive;
  public AHRS navX;
  public double pidOutput;
  public Encoder enc;

  public Drivetrain() {
     
    // This super is inherited from the PIDSubsytem to set values to the P, I and D constants.
    super("Drivetrain", 0.1,0.0003, 0); 

    // We will use the navx to get feedback about the robot's yaw and acceleration

    // The differential drive uses the left and right motors from the robot as parameters.
   
    Spark BackLeft = new Spark(RobotMap.MOTOR_BACK_LEFT);
    Spark FrontLeft = new Spark(RobotMap.MOTOR_FRONT_LEFT);
    Spark FrontRight = new Spark(RobotMap.MOTOR_FRONT_RIGHT);
    Spark BackRight = new Spark(RobotMap.MOTOR_BACK_RIGHT);

    SpeedControllerGroup Left = new SpeedControllerGroup(BackLeft, FrontLeft);
    SpeedControllerGroup Right = new SpeedControllerGroup(BackRight, FrontRight);
    
    drive = new DifferentialDrive(Left,Right); 

    navX = new AHRS(SPI.Port.kMXP); 
    navX.reset();

    enc = new Encoder(RobotMap.ENCODER_A, RobotMap.ENCODER_B, false, Encoder.EncodingType.k4X);

    /* 
    Define o período máximo para a detecção de interrompção.
    Define o valor que representa o período máximo do codificador antes de assumir que
    o dispositivo conectado está parado. Esse tempo limite permite que os usuários determinem
    se as rodas ou outro eixo pararam de girar. 
    */
    enc.setMaxPeriod(1);
    
    /* 
    Set the minimum rate of the device before the hardware reports it stopped.
    The minimum rate. The units are in distance per second as scaled by the value from 
    */
    enc.setMinRate(0.8);

    // distancia percorrida para cada pulso do encoder 1 pulso = 16,66 cm no autonomo
    enc.setDistancePerPulse(16.66);

    // direção do encoder
    enc.setReverseDirection(false);
    // quantidade de teste para média de erro
    enc.setSamplesToAverage(3);

    // These are the PID configs. DONT FORGET TO ENABLE() IT.
    setInputRange(-180f,180f);
    setOutputRange(-0.5f, 0.5f); 
    setAbsoluteTolerance(3);
    setSetpoint(0);
    enable();    
   
  }


  @Override
  public void initDefaultCommand() {
    
    setDefaultCommand(new Drive()); // We use the Drive() command as default because that is the primary function of this subsystem.

  }

  /**
   *  This method is used to set values to the driver's motors. It is set based on the controller's axys.
   *  It is similar to a cartesian plane. Move parameter is y, and spin parameter is x.
   *  If the robot's axis is inverted, be free to add a minus (-) to the parameter, or remove it.
   *  Or you can use the setInverted() method. 
   *  @param move double that is used as intensity of the axis
   *  @param spin double that is used to compute the heading and bearing of the axis
   *  @see DifferentialDrive
   */
  public void arcadeDrive(double move, double spin){
    SmartDashboard.putNumber("DriveTrain-Move",move);
    SmartDashboard.putNumber("DriveTrain-Spin",spin);
    SmartDashboard.putNumber("NavX-Yaw", navX.getYaw());
    SmartDashboard.putNumber("Encoder-Distance", enc.getDistance());
    SmartDashboard.putNumber("Encoder-Pulses", enc.get());  
    if(-move < 0) enc.setReverseDirection(true);
    else if(-move >= 0) enc.setReverseDirection(false);  
    drive.arcadeDrive(-move, spin); 
  }
  
  public void stop() {
    drive.arcadeDrive(0, 0);
  }

  /**
   * <p> ONLY THE DRIVETRAIN CAN USE IT </p>
   * <p> returns the navx`s Yaw </p>
   * @return input for the PID class
   */
  @Override
  protected double returnPIDInput() { 
    return navX.getYaw();
    // This is the input for the PID class. We are using the navx's Yaw.
  }

  /**
   * <p> ONLY THE DRIVETRAIN CAN USE IT </p>
   * <p> Stores a output for PID CALCULATIONS </p>
   * @param output input for the PID class
   */
  @Override
  protected void usePIDOutput(double output) {

    // This variable stores the output for your PID calculation. It is actually configured to set values for the motors.
    this.pidOutput = output; 

  }
}