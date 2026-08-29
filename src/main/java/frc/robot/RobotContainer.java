// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.AutonomousInitCommand;
import frc.robot.commands.ChangeShooterWheelSpeed;
import frc.robot.subsystems.SuperstructureSubsystem;
import frc.robot.subsystems.IntakeSubsystem.IntakeIOCTRE;
import frc.robot.subsystems.IntakeSubsystem.IntakeIOSim;
import frc.robot.subsystems.IntakeSubsystem.IntakeSubsystem;
import frc.robot.subsystems.ShooterWheelSubsystem.ShooterWheelSubsystem;
import frc.robot.subsystems.ShooterWheelSubsystem.ShooterWheelConstants;
import frc.robot.subsystems.SuperstructureSubsystem.SuperState;

public class RobotContainer {
  private static SuperstructureSubsystem superStructure;
  private IntakeSubsystem intake;
  private ShooterWheelSubsystem shooterWheel;
  private Command AutonomousInitOpenIntakeCommand;
  private Command IncreaseWheelSpeed;
  private Command DecreaseWheelSpeed;

  private CommandXboxController joystick = new CommandXboxController(0);

  public RobotContainer() {
    if (Robot.isReal()) {
      intake = new IntakeSubsystem(new IntakeIOCTRE());
    } else {
      intake = new IntakeSubsystem(new IntakeIOSim());
    }
    shooterWheel = new ShooterWheelSubsystem();
    superStructure = new SuperstructureSubsystem(intake, shooterWheel);
    AutonomousInitOpenIntakeCommand = new AutonomousInitCommand(intake, shooterWheel);
    IncreaseWheelSpeed = new ChangeShooterWheelSpeed(shooterWheel, ShooterWheelConstants.SHOOTER_WHEEL_SPEED_CHANGE_INCREMENT, true);
    DecreaseWheelSpeed = new ChangeShooterWheelSpeed(shooterWheel, -ShooterWheelConstants.SHOOTER_WHEEL_SPEED_CHANGE_INCREMENT, true);
    configureBindings();
  }

  private void configureBindings() {
    joystick.a().onTrue(new InstantCommand(() -> {
      superStructure.setWantedState(superStructure.handleStateTransition() == SuperState.INTAKE ? SuperState.IDLE : SuperState.INTAKE);
    }));

    joystick.rightBumper().whileTrue(IncreaseWheelSpeed);
    joystick.leftBumper().whileTrue(DecreaseWheelSpeed);

    joystick.b().onTrue(new InstantCommand(() -> {
      superStructure.setWantedState(SuperState.SHOOTING);
    })).onFalse(new InstantCommand(() -> {
      superStructure.setWantedState(SuperState.IDLE);
    }));
  }

  public Command getAutonomousCommand() {
    return AutonomousInitOpenIntakeCommand;
  }
  public static SuperstructureSubsystem getSuperStructure() {
    return superStructure;
  }
}
