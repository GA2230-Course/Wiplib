package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;

public class CloseIntake extends Command{
    private Intake intake;

    public CloseIntake(Intake intake) {
        this.intake = intake;
        addRequirements(intake);
    }

    @Override
    public void initialize() {
        intake.close();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
