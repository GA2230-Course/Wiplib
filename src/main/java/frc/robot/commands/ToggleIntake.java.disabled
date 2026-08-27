package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Intake.SystemState;

public class ToggleIntake extends Command{
    private Intake intake;

    public ToggleIntake(Intake intake) {
        this.intake = intake;
        addRequirements(intake);
    }

    @Override
    public void initialize() {
        if (intake.isOpen()) {
            intake.setWantedState(SystemState.CLOSE);
            return;
        }
        intake.setWantedState(SystemState.OPEN);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
