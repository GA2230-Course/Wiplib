package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;

public class OpenIntakeWithTimeout extends Command{
    private Intake intake;
    private double timeout;
    private double startTime;

    public OpenIntakeWithTimeout(Intake intake, double timeout) {
        this.intake = intake;
        this.timeout = timeout;
        addRequirements(intake);
    }

    @Override
    public void initialize() {
        intake.open();
        startTime = Timer.getFPGATimestamp();
    }

    @Override
    public boolean isFinished() {
        return (Timer.getFPGATimestamp() - startTime >= timeout);
    }

    @Override 
    public void end(boolean interrupted) {
        intake.close();
    }
}
