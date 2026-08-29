package frc.robot.subsystems.IntakeSubsystem;

import com.ctre.phoenix6.configs.TalonFXConfiguration;

public class IntakeConstants {
    public static final double OPEN_VOLTAGE = 1; //Place holder numbers.
    public static final double CLOSE_VOLTAGE = -1;
    public static final double IDLE_VOLTAGE = 0;

    public static final TalonFXConfiguration ROLLER_MOTOR_CONFIG = new TalonFXConfiguration();
    public static final TalonFXConfiguration FOURBAR_MOTOR_CONFIG = new TalonFXConfiguration();

    public static final double ROLLER_GEAR_RATIO = 3; //Place holder numbers i got from ai
    public static final double ROLLER_SIM_MOI = 0.005;
    public static final double FOURBAR_GEAR_RATIO = 50.0; 
    public static final double FOURBAR_SIM_MOI = 0.05; 
}
