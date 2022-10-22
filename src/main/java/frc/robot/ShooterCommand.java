package frc.robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ShooterCommand extends CommandBase {

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        int counter = 0;
        double joystickShooter = OI.getInstance().getController().getRightY();

        //when x button pressed open/close hood
        if (OI.getInstance().getController().getXButtonPressed()) {
            //if hood down make it go up
            if (counter % 2 == 0) {
                Shooter.getInstance().flywheelHoodUp();
            }
            //if hood up make it go down
            if (counter % 2 == 1) {
                Shooter.getInstance().flywheelHoodDown();
            }
            counter += 1;
        }

        //joystick error
        if (joystickShooter > -0.1 && joystickShooter < 0.1) {
            Shooter.getInstance().flywheelSpinSpeed(0);
        }

        //so that joystick cant be < 0
        else if (joystickShooter < 0) {
            Shooter.getInstance().flywheelSpinSpeed(0);
        }

        //setting shooter = joystickNumber
        else {
            Shooter.getInstance().flywheelSpinSpeed(joystickShooter);
        }
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return super.isFinished();
    }
}
