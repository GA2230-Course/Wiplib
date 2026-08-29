package frc.robot.subsystems.IntakeSubsystem;



import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase{
    private boolean intakeOpen = false;

    public enum SystemState {
        IDLE,
        OPEN,
        CLOSE
    }

    private SystemState wantedSystemState = SystemState.IDLE;
    private SystemState currentSystemState = SystemState.IDLE;

    private IntakeIO io;
    private IntakeIOInputsAutoLogged inputs = new IntakeIOInputsAutoLogged();


    public IntakeSubsystem(IntakeIO io) {
        this.io = io;
    }

    @Override
    public void periodic() {
        io.updateInputs(inputs);
        Logger.processInputs("Intake", inputs);
        currentSystemState = handleStateTransition();

        switch (currentSystemState) {
            case IDLE:
                System.out.println("IDLE state, setting voltage to: " + IntakeConstants.IDLE_VOLTAGE);
                break;
            case OPEN:
                open();
                System.out.println("OPEN state, setting voltage to: " + IntakeConstants.OPEN_VOLTAGE);
                break;
            case CLOSE:
                close();
                System.out.println("CLOSE state, setting voltage to: " + IntakeConstants.CLOSE_VOLTAGE);
                break;
            default:
                System.out.println("IDLE state, setting voltage to: " + IntakeConstants.IDLE_VOLTAGE);
                break;
        } 
    }

    public void open() {
        intakeOpen = true;
    }

    public void close() {
        intakeOpen = false;
    }

    public boolean isOpen() {return intakeOpen;}

    private SystemState handleStateTransition() {
        return wantedSystemState;
    }

    public void setWantedState(SystemState wantedSystemState) {
        this.wantedSystemState = wantedSystemState;
    }
}
