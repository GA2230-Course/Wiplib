package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SuperstructureSubsystem extends SubsystemBase{
    public enum SuperState {
        IDLE,
        INTAKE,
        SHOOTING
    }

    private boolean intakeWhileShooting = false;

    private SuperState wantedSuperState = SuperState.IDLE;
    private SuperState currentState = SuperState.IDLE;

    private Intake intake;
    private ShooterWheel shooterWheel;

    public SuperstructureSubsystem(Intake intake, ShooterWheel shooterWheel) {
        this.intake = intake;
        this.shooterWheel = shooterWheel;
    }

    @Override
    public void periodic() {
        currentState = handleStateTransition();

        switch (currentState) {
            case IDLE:
                intake.setWantedState(Intake.SystemState.CLOSE);
                shooterWheel.setWantedState(ShooterWheel.SystemState.IDLE);
                break;
            case INTAKE:
                intake.setWantedState(Intake.SystemState.OPEN);
                shooterWheel.setWantedState(ShooterWheel.SystemState.IDLE);
                break;
            case SHOOTING:
                intake.setWantedState(intakeWhileShooting ? Intake.SystemState.OPEN : Intake.SystemState.CLOSE);
                shooterWheel.setWantedState(ShooterWheel.SystemState.SHOOTING);
                break;
            default:
                intake.setWantedState(Intake.SystemState.IDLE);
                shooterWheel.setWantedState(ShooterWheel.SystemState.IDLE);
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
