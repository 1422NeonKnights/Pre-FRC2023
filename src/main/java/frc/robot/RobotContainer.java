// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.DriveConstants;
import frc.robot.commands.GoForward;
import frc.robot.commands.XboxDrive;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  //subsystems
  public static final DriveTrain drivetrain = new DriveTrain();
  
  //commands
  
  //Joysticks
  public static final XboxController XboxStick = new XboxController(DriveConstants.XBOX_JOY);
  public static final Joystick leftStick = new Joystick(DriveConstants.LEFT_JOY);
  public static final Joystick rightStick = new Joystick(DriveConstants.RIGHT_JOY);

  //gyro
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // if(leftStick.getZ()<=0 || rightStick.getZ()<=0){
    //   drivetrain.setDefaultCommand(new ArcadeDrive());
    // }else if(leftStick.getZ()>0 || rightStick.getZ()>0){
    //   drivetrain.setDefaultCommand(new TankDrive());
    // }

    drivetrain.setDefaultCommand(new XboxDrive());
      
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return new SequentialCommandGroup(
      new GoForward()
    

    );
  }
}
