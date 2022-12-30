// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.Constants.DriveConstants;

public class MarioDrive extends CommandBase {
  double moveSpeed = 0;
  /** Creates a new MarioDrive. */
  public MarioDrive() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (RobotContainer.XboxStick.getAButtonPressed()) {
      moveSpeed = DriveConstants.MAX_SPEED;
    } else if (RobotContainer.XboxStick.getAButtonReleased()) {
      moveSpeed = 0;
    }
    if (RobotContainer.XboxStick.getBButtonPressed()) {
      moveSpeed = -DriveConstants.MAX_SPEED;
    } else if (RobotContainer.XboxStick.getBButtonReleased()) {
      moveSpeed = 0;
    }

    double rotateSpeed = -RobotContainer.XboxStick.getLeftX();
    RobotContainer.drivetrain.arcadeDrive(moveSpeed, rotateSpeed);
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
