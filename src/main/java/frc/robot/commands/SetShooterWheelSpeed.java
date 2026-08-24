package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterWheel;

public class SetShooterWheelSpeed extends Command{
    private ShooterWheel shooterWheel;
    private double speed;

    public SetShooterWheelSpeed(ShooterWheel shooterWheel, double speed) {
        this.shooterWheel = shooterWheel;
        this.speed = speed;
        addRequirements(shooterWheel);
    }
    
    @Override
    public void initialize() {
        shooterWheel.setSpeed(speed);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
