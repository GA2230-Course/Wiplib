package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.SuperstructureSubsystem.SuperState;

public class CloseIntake extends Command{
    @Override
    public void initialize() {
        RobotContainer.getSuperStructure().setWantedState(SuperState.IDLE);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
