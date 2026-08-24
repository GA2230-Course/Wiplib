package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterWheel;

public class ChangeShooterWheelSpeed extends Command{
    private ShooterWheel shooterWheel;
    private double amount;
    private boolean loop;

    public ChangeShooterWheelSpeed(ShooterWheel shooterWheel, double amount, boolean loop) {
        this.shooterWheel = shooterWheel;
        this.amount = amount;
        this.loop = loop;
        addRequirements(shooterWheel);
    }
    
    @Override
    public void initialize() {
        if (!loop) {
            shooterWheel.changeSpeed(amount);
            this.cancel();
        }
    }

    @Override
    public void execute() {
        shooterWheel.changeSpeed(amount);
    }
}
