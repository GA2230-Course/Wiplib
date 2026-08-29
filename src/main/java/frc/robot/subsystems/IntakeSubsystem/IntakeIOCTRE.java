package frc.robot.subsystems.IntakeSubsystem;

import com.ctre.phoenix6.BaseStatusSignal;
import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Temperature;
import edu.wpi.first.units.measure.Voltage;
import frc.robot.Ports;

public class IntakeIOCTRE implements IntakeIO {
    protected final TalonFX rollerMasterMotor;
    protected final TalonFX fourBarMotor;

    private final StatusSignal<AngularVelocity> rollerMasterVelocitySignal;
    private final StatusSignal<Voltage> rollerMasterVoltageSignal;
    private final StatusSignal<Angle> fourBarPositionSignal;

    private final StatusSignal<Temperature> rollerMasterTempSignal;
    private final StatusSignal<Temperature> fourBarTempSignal;

    private final BaseStatusSignal[] signals;

    public IntakeIOCTRE() {
        rollerMasterMotor = new TalonFX(Ports.INTAKE_ROLLER_MASTER_MOTOR.id(), Ports.INTAKE_ROLLER_MASTER_MOTOR.bus());
        rollerMasterMotor.getConfigurator().apply(IntakeConstants.ROLLER_MOTOR_CONFIG);

        fourBarMotor = new TalonFX(Ports.INTAKE_FOUR_BAR_MOTOR.id(), Ports.INTAKE_FOUR_BAR_MOTOR.bus());
        fourBarMotor.getConfigurator().apply(IntakeConstants.FOURBAR_MOTOR_CONFIG);

        rollerMasterVelocitySignal = rollerMasterMotor.getVelocity();
        rollerMasterVoltageSignal = rollerMasterMotor.getMotorVoltage();
        fourBarPositionSignal = fourBarMotor.getPosition();

        rollerMasterTempSignal = rollerMasterMotor.getDeviceTemp();
        fourBarTempSignal = fourBarMotor.getDeviceTemp();


        signals = new BaseStatusSignal[] {
            rollerMasterVelocitySignal,
            rollerMasterVoltageSignal,
            fourBarPositionSignal,
            rollerMasterTempSignal,
            fourBarTempSignal
        };
    }
    
    @Override 
    public void updateInputs(IntakeIOInputs inputs) {
        BaseStatusSignal.refreshAll(signals);

        inputs.rollerMasterVelocity = rollerMasterVelocitySignal.getValueAsDouble();
        inputs.rollerMasterVoltage = rollerMasterVoltageSignal.getValueAsDouble();
        inputs.rollerMasterTemp = rollerMasterTempSignal.getValueAsDouble();
        inputs.isRollerMasterMotorConnected = rollerMasterMotor.isConnected();

        inputs.fourBarPosition = fourBarPositionSignal.getValueAsDouble();
        inputs.fourBarTemp = fourBarTempSignal.getValueAsDouble();
        inputs.isFourBarMotorConnected = fourBarMotor.isConnected();
    }
}
