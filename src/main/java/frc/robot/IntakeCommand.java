package frc.robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeCommand extends CommandBase {

    public IntakeCommand() {
        setName("Intake Command");
        addRequirements(Intake.getInstance());
    }

    @Override
    public void initialize() {
        super.initialize();
    }

    @Override
    public void execute() {
        double joystickValue = OI.getInstance().getController().getLeftY();
        Intake.getInstance().falconSpeed(joystickValue);
        if (OI.getInstance().getController().getAButtonPressed())  {
            Intake.getInstance().intakeBackwardPress();
        }
        if (OI.getInstance().getController().getBButtonPressed())  {
            Intake.getInstance().intakeForwardPress();
        }
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
    }

    @Override
    public boolean isFinished() {
        return super.isFinished();
    }
}
