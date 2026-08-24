// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.AutonomousInitCommand;
import frc.robot.commands.ChangeShooterWheelSpeed;
import frc.robot.commands.ToggleIntake;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.ShooterWheel;

public class RobotContainer {
  private Intake intake;
  private ShooterWheel shooterWheel;
  private Command AutonomousInitOpenIntakeCommand;
  private Command toggleIntake;
  private Command IncreaseWheelSpeed;
  private Command DecreaseWheelSpeed;


  private CommandXboxController joystick = new CommandXboxController(0);

  public RobotContainer() {
    intake = new Intake();
    shooterWheel = new ShooterWheel();
    AutonomousInitOpenIntakeCommand = new AutonomousInitCommand(intake, shooterWheel);
    toggleIntake = new ToggleIntake(intake);
    IncreaseWheelSpeed = new ChangeShooterWheelSpeed(shooterWheel, Constants.ShooterWheelSpeedChangeIncrement, true);
    DecreaseWheelSpeed = new ChangeShooterWheelSpeed(shooterWheel, -Constants.ShooterWheelSpeedChangeIncrement, true);
    configureBindings();
  }

  private void configureBindings() {
    joystick.a().onTrue(toggleIntake);

    joystick.rightBumper().whileTrue(IncreaseWheelSpeed);
    joystick.leftBumper().whileTrue(DecreaseWheelSpeed);
  }

  public Command getAutonomousCommand() {
    return AutonomousInitOpenIntakeCommand;
  }
}
