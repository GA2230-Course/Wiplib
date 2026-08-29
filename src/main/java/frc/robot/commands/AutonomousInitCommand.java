package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Constants;
import frc.robot.subsystems.IntakeSubsystem.IntakeSubsystem;
import frc.robot.subsystems.ShooterWheelSubsystem.ShooterWheelSubsystem;

public class AutonomousInitCommand extends Command {
    private OpenIntakeWithTimeout openIntakeCommand;
    private SetShooterWheelSpeed setSpeedCommand;
    
    public AutonomousInitCommand(IntakeSubsystem intake, ShooterWheelSubsystem shooterWheel) {
        openIntakeCommand = new OpenIntakeWithTimeout(intake, Constants.AUTONOMOUS_INIT_OPEN_INTAKE_TIMEOUT);
        setSpeedCommand = new SetShooterWheelSpeed(shooterWheel, Constants.AUTONOMOUS_INIT_SHOOTER_WHEEL_SPEED);
    }

    @Override
    public void initialize() {
        CommandScheduler.getInstance().schedule(openIntakeCommand, setSpeedCommand);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
