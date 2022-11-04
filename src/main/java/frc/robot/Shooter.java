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
    int counter;

    double endPosition;

    double output;

    public void initHardware() {
        endPosition = OI.getInstance().getController().getLeftY();
        falconUp = new WPI_TalonFX(0);
        falconDown = new WPI_TalonFX(1);
        hood = new WPI_TalonFX(2);
        hood.config_kP(0, 0.30);
        hood.config_kI(0, 0.);
        hood.config_kD(0, 0.);
        counter = 0;
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


    public void flywheelHood(double time, double num_ticks) {
        double hoodspt = num_ticks * OI.getInstance().getController().getLeftY();
        hood.set(ControlMode.Position, hoodspt);
    }



}