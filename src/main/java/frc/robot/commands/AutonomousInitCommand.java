package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Constants;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.ShooterWheel;

public class AutonomousInitCommand extends Command {
    private OpenIntakeWithTimeout openIntakeCommand;
    private SetShooterWheelSpeed setSpeedCommand;
    
    public AutonomousInitCommand(Intake intake, ShooterWheel shooterWheel) {
        openIntakeCommand = new OpenIntakeWithTimeout(intake, Constants.AutonomousInitOpenIntakeTimeout);
        setSpeedCommand = new SetShooterWheelSpeed(shooterWheel, Constants.AutonomousInitShooterWheelSpeed);
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
