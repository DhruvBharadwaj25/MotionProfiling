package frc.robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ConveyorCommand extends CommandBase {

    Conveyor conveyor;

    @Override
    public void initialize() {
        conveyor = new Conveyor();
    }

    @Override
    public void execute() {
        if (OI.getInstance().getController().getRightBumperPressed()) {
            conveyor.conveyorForward(0.5);
        }

        if (OI.getInstance().getController().getRightBumperReleased()) {
            conveyor.conveyorForward(0);
        }

        conveyor.numBallsConveyor();
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
