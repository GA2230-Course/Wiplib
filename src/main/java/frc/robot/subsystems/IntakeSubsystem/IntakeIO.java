package frc.robot.subsystems.IntakeSubsystem;

import org.littletonrobotics.junction.AutoLog;

public interface IntakeIO {
    default void setRollerSpeed(double speed) {}
    default void setFourBarAngle(double speed) {}
    default void updateInputs(IntakeIOInputs inputs) {}

    @AutoLog
    public static class IntakeIOInputs {
        public double rollerMasterVelocity = 0.0;
        public double rollerMasterVoltage = 0.0;
        public double rollerMasterTemp = 0.0;
        public boolean isRollerMasterMotorConnected = false;

        public double fourBarPosition = 0.0;
        public double fourBarTemp = 0.0;
        public boolean isFourBarMotorConnected = false;
    }
}