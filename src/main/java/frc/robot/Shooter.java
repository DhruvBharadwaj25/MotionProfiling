package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import org.opencv.core.TickMeter;


public class Shooter {

    private static Shooter instance;

    public static Shooter getInstance() {
        if (instance == null) {
            instance = new Shooter();
        }
        return instance;
    }

    WPI_TalonFX falconUp;
    WPI_TalonFX falconDown;
    WPI_TalonFX hood;

    double endPosition;

    TrapezoidProfile.State start;
    TrapezoidProfile.State end;
    TrapezoidProfile.Constraints constraints;
    TrapezoidProfile profile;
    PIDController controller;

    Encoder encoder;
    double output;

    public void initHardware() {
        endPosition = OI.getInstance().getController().getLeftY();
        falconUp = new WPI_TalonFX(0);
        falconDown = new WPI_TalonFX(1);
        hood = new WPI_TalonFX(2);
        start = new TrapezoidProfile.State(hood.getSelectedSensorPosition(), 0);
        end = new TrapezoidProfile.State(endPosition, 0);
        encoder = new Encoder(Constants.ENCODER_IDS[0], Constants.ENCODER_IDS[1]);
        controller = new PIDController(0.3, 0, 0);
        constraints = new TrapezoidProfile.Constraints(2, 0.2);
        profile = new TrapezoidProfile(constraints, end, start);
    }

    public void flywheelSpinSpeed(double speed) {
        //always want positive speed
        if (speed < 0) {
            falconDown.set(0);
            falconUp.set(0);
        }

        else {
            falconUp.set(-speed);
            falconDown.set(speed);
        }
    }

    public void flywheelHood(double time) {
        TrapezoidProfile.State setpoint = profile.calculate(time);
        controller.setSetpoint(setpoint.velocity);
        output = controller.calculate(hood.getSelectedSensorPosition());
        hood.set(ControlMode.PercentOutput, output);
    }
}