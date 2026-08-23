// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.commands.OpenIntakeWithTimeout;
import frc.robot.subsystems.Intake;

public class RobotContainer {
  private Intake intake;
  private Command AutonomousInitOpenIntakeCommand;

  public RobotContainer() {
    configureBindings();
    intake = new Intake();
    AutonomousInitOpenIntakeCommand = new OpenIntakeWithTimeout(intake, Constants.AutonomousInitOpenIntakeTimeout);
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return AutonomousInitOpenIntakeCommand;
  }
}
