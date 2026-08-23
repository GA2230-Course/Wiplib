package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase{
    private boolean intakeOpen = false;

    @Override
    public void periodic() {
        System.out.println("Intake is: " + ((intakeOpen) ? "Open" : "Closed"));
    }

    public void open() {
        intakeOpen = true;
    }

    public void close() {
        intakeOpen = false;
    }

}
