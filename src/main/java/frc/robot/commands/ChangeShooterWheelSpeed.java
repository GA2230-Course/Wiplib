package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterWheelSubsystem.ShooterWheelSubsystem;

public class ChangeShooterWheelSpeed extends Command{
    private ShooterWheelSubsystem shooterWheel;
    private double amount;
    private boolean loop;

    public ChangeShooterWheelSpeed(ShooterWheelSubsystem shooterWheel, double amount, boolean loop) {
        this.shooterWheel = shooterWheel;
        this.amount = amount;
        this.loop = loop;
        addRequirements(shooterWheel);
    }
    
    @Override
    public void initialize() {
        if (!loop) {
            shooterWheel.changeWantedSpeed(amount);
            this.cancel();
        }
    }

    @Override
    public void execute() {
        shooterWheel.changeWantedSpeed(amount);
    }
}
