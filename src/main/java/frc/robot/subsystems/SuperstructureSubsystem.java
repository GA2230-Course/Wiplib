package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.IntakeSubsystem.IntakeSubsystem;
import frc.robot.subsystems.ShooterWheelSubsystem.ShooterWheelSubsystem;

public class SuperstructureSubsystem extends SubsystemBase{
    public enum SuperState {
        IDLE,
        INTAKE,
        SHOOTING
    }

    private boolean intakeWhileShooting = false;

    private SuperState wantedSuperState = SuperState.IDLE;
    private SuperState currentState = SuperState.IDLE;

    private IntakeSubsystem intake;
    private ShooterWheelSubsystem shooterWheel;

    public SuperstructureSubsystem(IntakeSubsystem intake, ShooterWheelSubsystem shooterWheel) {
        this.intake = intake;
        this.shooterWheel = shooterWheel;
    }

    @Override
    public void periodic() {
        currentState = handleStateTransition();

        switch (currentState) {
            case IDLE:
                intake.setWantedState(IntakeSubsystem.SystemState.CLOSE);
                shooterWheel.setWantedState(ShooterWheelSubsystem.SystemState.IDLE);
                break;
            case INTAKE:
                intake.setWantedState(IntakeSubsystem.SystemState.OPEN);
                shooterWheel.setWantedState(ShooterWheelSubsystem.SystemState.IDLE);
                break;
            case SHOOTING:
                intake.setWantedState(intakeWhileShooting ? IntakeSubsystem.SystemState.OPEN : IntakeSubsystem.SystemState.CLOSE);
                shooterWheel.setWantedState(ShooterWheelSubsystem.SystemState.SHOOTING);
                break;
            default:
                intake.setWantedState(IntakeSubsystem.SystemState.IDLE);
                shooterWheel.setWantedState(ShooterWheelSubsystem.SystemState.IDLE);
                break;
        }
    }

    public SuperState handleStateTransition() {
        return wantedSuperState;
    }

    public void setWantedState(SuperState wantedSuperState) {
        this.wantedSuperState = wantedSuperState;
    }
}
