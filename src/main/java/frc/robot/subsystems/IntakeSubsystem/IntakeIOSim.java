package frc.robot.subsystems.IntakeSubsystem;

import static edu.wpi.first.units.Units.Volts;

import com.ctre.phoenix6.sim.TalonFXSimState;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;
import frc.robot.Constants;

public class IntakeIOSim extends IntakeIOCTRE {
    private final TalonFXSimState rollerMasterMotorSim;
    private final DCMotorSim rollerSim;

    private final TalonFXSimState fourBarMotorSim;
    private final DCMotorSim fourBarSim;

    
    public IntakeIOSim() {
        super();
        rollerMasterMotorSim = rollerMasterMotor.getSimState();
        rollerSim = new DCMotorSim(
            LinearSystemId.createDCMotorSystem(
                DCMotor.getKrakenX60(2),
                 IntakeConstants.ROLLER_SIM_MOI,
                  IntakeConstants.ROLLER_GEAR_RATIO),
            DCMotor.getKrakenX60(2));

        fourBarMotorSim = fourBarMotor.getSimState();
        fourBarSim = new DCMotorSim(
            LinearSystemId.createDCMotorSystem(
                DCMotor.getKrakenX60(1), 
                IntakeConstants.FOURBAR_SIM_MOI,  
                IntakeConstants.FOURBAR_GEAR_RATIO 
            ),
            DCMotor.getKrakenX60(1));
    }

    @Override
    public void updateInputs(IntakeIOInputs inputs) {
        updateSimulation();
        super.updateInputs(inputs);
    }

    private void updateSimulation() {
        rollerMasterMotorSim.setSupplyVoltage(RobotController.getBatteryVoltage());
        rollerSim.setInputVoltage(rollerMasterMotorSim.getMotorVoltageMeasure().in(Volts));
        rollerSim.update(Constants.DEAFUT_PERIOD_SECS);
        rollerMasterMotorSim.setRawRotorPosition(rollerSim.getAngularPosition().times(IntakeConstants.ROLLER_GEAR_RATIO));

        fourBarMotorSim.setSupplyVoltage(RobotController.getBatteryVoltage());
        fourBarSim.setInputVoltage(fourBarMotorSim.getMotorVoltageMeasure().in(Volts));
        fourBarSim.update(Constants.DEAFUT_PERIOD_SECS);
        fourBarMotorSim.setRawRotorPosition(fourBarSim.getAngularPosition().times(IntakeConstants.FOURBAR_GEAR_RATIO));
    }
}