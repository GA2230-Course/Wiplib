package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.SuperstructureSubsystem.SuperState;

public class OpenIntakeWithTimeout extends Command{
    private double timeout;
    private double startTime;

    public OpenIntakeWithTimeout(Intake intake, double timeout) {
        this.timeout = timeout;
    }

    @Override
    public void initialize() {
        RobotContainer.getSuperStructure().setWantedState(SuperState.INTAKE);
        startTime = Timer.getFPGATimestamp();
    }

    @Override
    public boolean isFinished() {
        return (Timer.getFPGATimestamp() - startTime >= timeout);
    }

    @Override 
    public void end(boolean interrupted) {
        RobotContainer.getSuperStructure().setWantedState(SuperState.IDLE);
    }
}
