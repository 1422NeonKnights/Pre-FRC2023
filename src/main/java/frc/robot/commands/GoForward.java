// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

public class GoForward extends CommandBase {
  double speed = 0.6;
  double rotation = 0;
  /** Creates a new GoForward. */
  public GoForward() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    DriveTrain.gyro.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //gets the gyro value
    double gyroValue = DriveTrain.gyro.getAngle();

    //corrects the rotation value for the robot within
    if(Math.round(gyroValue)>0){
      rotation =  gyroValue/15;
    }else if(Math.round(gyroValue)<0){
      rotation =  gyroValue/15;
    }
    
    RobotContainer.drivetrain.arcadeDrive(speed, rotation);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
