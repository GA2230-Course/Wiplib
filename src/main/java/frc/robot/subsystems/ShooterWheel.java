package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterWheel extends SubsystemBase{
    private double rotationSpeed = 0;

    @Override 
    public void periodic() {
        System.out.print("Wheel speed: " + rotationSpeed);
    }

    public void changeSpeed(double amount) {
        rotationSpeed = Math.min(1, Math.max(rotationSpeed + amount, 0)); // clamps the rotationSpeed value between 0 and 1
    }

    public void setSpeed(double speed) {
        rotationSpeed = Math.min(1, Math.max(speed, 0)); // clamps the rotationSpeed value between 0 and 1
    }
}
