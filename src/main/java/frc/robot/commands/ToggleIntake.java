package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;

public class ToggleIntake extends Command{
    private Intake intake;

    public ToggleIntake(Intake intake) {
        this.intake = intake;
        addRequirements(intake);
    }

    @Override
    public void initialize() {
        if (intake.isOpen()) {
            intake.close();
            return;
        }
        intake.open();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
