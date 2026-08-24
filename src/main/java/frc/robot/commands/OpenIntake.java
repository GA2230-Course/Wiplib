package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;

public class OpenIntake extends Command{
    private Intake intake;

    public OpenIntake(Intake intake) {
        this.intake = intake;
        addRequirements(intake);
    }

    @Override
    public void initialize() {
        intake.open();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
