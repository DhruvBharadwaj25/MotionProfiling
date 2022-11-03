package frc.robot;

import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;

public class ShooterCommand extends CommandBase {

    int counter;
    double time;

    @Override
    public void initialize() {
        counter = 0;
        time = 0;
    }

    @Override
    public void execute() {
        double joystickShooter = OI.getInstance().getController().getRightY();
        double joystickHood = OI.getInstance().getController().getLeftY();

        //joystick error
        if (joystickShooter > -0.1 && joystickShooter < 0.1) {
            Shooter.getInstance().flywheelSpinSpeed(0);
        }

        //so that joystick can't be < 0
        else if (joystickShooter < 0) {
            Shooter.getInstance().flywheelSpinSpeed(0);
        }

        //shooting ball at speed directed by joystick
        else {
            Shooter.getInstance().flywheelSpinSpeed(joystickShooter);
        }

        if (joystickHood > -0.1 && joystickHood < 0.1) {
            Shooter.getInstance().hood.set(0);
        }

        else {
            Shooter.getInstance().flywheelHood(time);
        }

        time += 0.02;


    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return super.isFinished();
    }
}
