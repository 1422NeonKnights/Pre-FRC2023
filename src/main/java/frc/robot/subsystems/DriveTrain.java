// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveTrain extends SubsystemBase {
  //define TalonSRX
  WPI_TalonSRX rightMotor1;
  WPI_TalonSRX rightMotor2;
  WPI_TalonSRX leftMotor1;
  WPI_TalonSRX leftMotor2;

  //groups
  MotorControllerGroup leftMotors;
  MotorControllerGroup rightMotors;

  DifferentialDrive differentialDrive;

  /** Creates a new DriveTrain. */
  public DriveTrain() {
    //config motors
    // create motors
    rightMotor1 = new WPI_TalonSRX(DriveConstants.DRIVETRAIN_RIGHT_FRONT_TALON);
    rightMotor2 = new WPI_TalonSRX(DriveConstants.DRIVETRAIN_RIGHT_BACK_TALON);
    leftMotor1 = new WPI_TalonSRX(DriveConstants.DRIVETRAIN_LEFT_FRONT_TALON);
    leftMotor2 = new WPI_TalonSRX(DriveConstants.DRIVETRAIN_LEFT_BACK_TALON);

    // factory reset
    rightMotor1.configFactoryDefault();
    rightMotor2.configFactoryDefault();
    leftMotor1.configFactoryDefault();
    leftMotor2.configFactoryDefault();

    // break mode
    rightMotor1.setNeutralMode(NeutralMode.Brake);
    rightMotor2.setNeutralMode(NeutralMode.Brake);
    leftMotor1.setNeutralMode(NeutralMode.Brake);
    leftMotor2.setNeutralMode(NeutralMode.Brake);

    //current limiting
    // peak current
    rightMotor1.configPeakCurrentLimit(35, 10);
    rightMotor2.configPeakCurrentLimit(35, 10);
    leftMotor1.configPeakCurrentLimit(35, 10);
    leftMotor2.configPeakCurrentLimit(35, 10);

    // duration
    rightMotor1.configPeakCurrentDuration(200, 10);
    rightMotor2.configPeakCurrentDuration(200, 10);
    leftMotor1.configPeakCurrentDuration(200, 10);
    leftMotor2.configPeakCurrentDuration(200, 10);

    // continuous
    rightMotor1.configContinuousCurrentLimit(30, 10);
    rightMotor2.configContinuousCurrentLimit(30, 10);
    leftMotor1.configContinuousCurrentLimit(30, 10);
    leftMotor2.configContinuousCurrentLimit(30, 10);

    // enable
    rightMotor1.enableCurrentLimit(true);
    rightMotor2.enableCurrentLimit(true);
    leftMotor1.enableCurrentLimit(true);
    leftMotor2.enableCurrentLimit(true);

    //inversion
    rightMotor1.setInverted(false);
    rightMotor2.setInverted(false);
    leftMotor1.setInverted(true);
    leftMotor2.setInverted(true);

    //Open loop ramp(prevent sudden speed changes)
    rightMotor1.configOpenloopRamp(DriveConstants.DRIVE_RAMP_RATE, 15);
    rightMotor2.configOpenloopRamp(DriveConstants.DRIVE_RAMP_RATE, 15);
    leftMotor1.configOpenloopRamp(DriveConstants.DRIVE_RAMP_RATE, 15);
    leftMotor2.configOpenloopRamp(DriveConstants.DRIVE_RAMP_RATE, 15);

    //motor controller groups
    rightMotors = new MotorControllerGroup(rightMotor1, rightMotor2);
    leftMotors = new MotorControllerGroup(leftMotor1, leftMotor2);

    //differential drive for arcade/tank
    differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
  }

  //tank drive
  public void tankDrive(double right, double left){
    differentialDrive.tankDrive(left, right);
  }

  //arcade drive
  public void arcadeDrive(double moveSpeed, double rotateSpeed){
    differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);
  }
}
