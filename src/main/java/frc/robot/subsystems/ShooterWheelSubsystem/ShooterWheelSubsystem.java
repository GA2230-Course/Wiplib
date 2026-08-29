package frc.robot.subsystems.ShooterWheelSubsystem;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterWheelSubsystem extends SubsystemBase{
    public enum SystemState {
        IDLE,
        SHOOTING,
    }

    private SystemState wantedSystemState = SystemState.IDLE;
    private SystemState currentSystemState = SystemState.IDLE;

    private double rotationSpeed = 0;
    private double wantedRotationSpeed = 0;


    @Override
    public void periodic() {
        currentSystemState = handleStateTransition();

        switch (currentSystemState) {
            case IDLE:
                break;
            case SHOOTING:
                handleWantedSpeed();
                System.out.print("SHOOTING state, updating speed to: " + rotationSpeed);
                break;
            default:
                break;
        } 
    }

    public void changeWantedSpeed(double amount) {
        wantedRotationSpeed = Math.min(1, Math.max(wantedRotationSpeed + amount, 0)); // clamps the rotationSpeed value between 0 and 1
    }

    public void setWantedSpeed(double speed) {
        wantedRotationSpeed = Math.min(1, Math.max(speed, 0)); // clamps the rotationSpeed value between 0 and 1
    }

    public void handleWantedSpeed() {
        rotationSpeed = wantedRotationSpeed;
    }

    private SystemState handleStateTransition() {
        return wantedSystemState;
    }

    public void setWantedState(SystemState wantedSystemState) {
        this.wantedSystemState = wantedSystemState;
    }
}
